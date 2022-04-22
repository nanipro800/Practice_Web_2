package nhan.ntu.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// Được tiêm vào (inject) từ application.properties.


	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
		
}
