package nhan.ntu.edu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MainController {
	// Được tiêm vào (inject) từ application.properties.

		@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
		public String index() {
			return "index";
		}
		
}
