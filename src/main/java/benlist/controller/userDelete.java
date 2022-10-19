package benlist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import benlist.model.benlistDao;
import userlist.model.userlistBean_gang;

@Controller
public class userDelete {
	
	private final String userDelete = "userDelete.ben";
	private final String deleteAction = "deleteAction.ben";
	private String goPage = "count10up";
	private String Action = "redirect:/userDelete.ben";
	
	
	@Autowired
	private benlistDao bdao;
	
	
	@RequestMapping(value = userDelete, method = RequestMethod.GET)
	public String goPage(Model model) {
		
		System.out.println(1);
		List<userlistBean_gang> lists = bdao.count10up();
		System.out.println(2);
		model.addAttribute("lists",lists);
		
		return goPage;
	}
	
	@RequestMapping(value=deleteAction, method = RequestMethod.GET)
	public String userDelete1(HttpServletRequest request) {
		
		String[] num = request.getParameterValues("rowcheck");
		
		for(int i = 0 ; i<num.length-1 ; i++) {
			bdao.userDelete(num[i]);
		}
		
		return Action;
	}
}
