package userlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import userlist.model.userlistDao_gang;


@Controller
public class userDeleteController {
	private final String command="userDelete.ulist";
	private String gotoPage="redirect:/userList.ulist";
	@Autowired
	private userlistDao_gang udao;
	@RequestMapping(command)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		udao.deleteUser(num);
		return gotoPage+"?pageNumber="+pageNumber;
	}
}
