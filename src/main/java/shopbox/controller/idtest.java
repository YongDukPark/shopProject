package shopbox.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class idtest {
	
	@RequestMapping(value = "id.sbox", method = RequestMethod.POST)
	public String create(@RequestParam(value = "id") String id, HttpSession session) {
		
		session.setAttribute("id", id);
		
		return "start";
	}
	
	@RequestMapping(value = "idDelete.sbox", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		
		//session.getAttribute("id");
		session.removeAttribute("id");
		
		return "start";
	}
	
	
}
