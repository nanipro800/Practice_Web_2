package nhan.ntu.edu.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;

	  @Column(name = "name")
	  private String name;

	  @Column(name = "email")
	  private String email;

	  @Column(name = "phone")
	  private String phone;
	  
	  @Column(name = "facebook")
	  private String facebook;
	  
	  @Column(name = "avatar")
	  private String avatar;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	  
	  
	  

}
