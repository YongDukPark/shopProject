package shopbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class testjava {
	
	
	@RequestMapping(value="testjava.sbox")
	public String doAction(@RequestParam("test5") String test) {
		
		System.out.println("test");
		
		return "어디로든지문";
	}
	
}
