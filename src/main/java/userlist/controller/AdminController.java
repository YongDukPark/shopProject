package userlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AdminController {

@RequestMapping(value="AdminInfo.ulist",method=RequestMethod.GET)
public String SearchId() {
	return "AdminInfo";
}
}
