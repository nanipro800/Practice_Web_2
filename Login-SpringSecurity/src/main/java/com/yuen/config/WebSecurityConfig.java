package com.yuen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration 		//  Xác định lớp WebSecurityConfig của ta là một lớp dùng để cấu hình
@EnableWebSecurity  //  Kích hoạt việc tích hợp Spring Security với Spring MVC.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean // Để sử dụng được PasswordEncoder, ta phải cấu hình để PasswordEncoder trở thành một Bean.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Giúp chúng ta mã hóa mật khẩu bằng thuật toán BCrypt
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    // Cấu hình các chi tiết về bảo mật:
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            // .antMatchers(): Khai báo đường dẫn của Request
                .antMatchers("/register").permitAll() // Cho phép tất cả các user đều được phép truy cập.
                // // Chỉ cho phép các user có GrantedAuthority là ROLE_roleName mới được phép truy cập
                .antMatchers("/").hasRole("MEMBER")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
            .formLogin()
            // Trong Spring Security, trang xử lý submit form mặc định là /login. Nếu bạn muốn custom thì có thể dùng loginProcessingUrl().
                .loginPage("/login") // Đường dẫn tới trang chứa form đăng nhập
                .usernameParameter("email")
                .passwordParameter("password")
                // => Gía trị của thuộc tính name của 2 input nhập username và password
                .defaultSuccessUrl("/")  	// Đường dẫn tới trang đăng nhập thành công
                .failureUrl("/login?error") // Đường dẫn tới trang đăng nhập thất bại
                .and()
            .exceptionHandling()
            // Khi người dùng không đủ quyền để truy cập vào một trang, ta sẽ redirect người dùng về một trang 403 nào đó:
                .accessDeniedPage("/403");
    }

}