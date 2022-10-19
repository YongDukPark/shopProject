package userlist.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shopbox.model.shopboxBean;
import userlist.model.userlistBean_gang;
import userlist.model.userlistDao_gang;

@Controller
public class userDetailController {
		
	private final String command="userDetail.ulist";
	private String getPage="userDetail";
	@Autowired
	private userlistDao_gang udao;
	@RequestMapping(command)
	public String doAction(
			@RequestParam("id") String id,
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
		System.out.println(id);
		userlistBean_gang user=udao.getUser(num);
		List<shopboxBean> payments=udao.paymentHistory(id);
		
		model.addAttribute("user",user);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("payments",payments);
		return getPage;
		}
}