package userlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	private final String command = "logout.ulist";
	private final String getPage = "logout";
	
@RequestMapping(value=command,method=RequestMethod.GET)
public String doAtion() {
	return  getPage;
}
}
