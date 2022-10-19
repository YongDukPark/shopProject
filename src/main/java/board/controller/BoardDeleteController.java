package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardDao;
@Controller
public class BoardDeleteController {
	private final String command="/delete.bd";
	private String getPage="deleteForm";
	private String gotoPage="redirect:/list.bd";
	@Autowired
	private BoardDao bdao;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(@RequestParam("num") int num,@RequestParam("pageNumber") String pageNumber,Model model,HttpSession session,HttpServletResponse response) {
		model.addAttribute("num",num);
		model.addAttribute("pageNumber",pageNumber);
		if(session.getAttribute("id").equals("admin")) {
			bdao.deleteAdmin(num);
			return gotoPage;
		}
		return getPage;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction1(@RequestParam("num") int num,
			@RequestParam("passwd") String passwd,
			@RequestParam("pageNumber") String pageNumber,
			Model model) {
		System.out.println(num);
		model.addAttribute("num",num);
		model.addAttribute("pageNumber",pageNumber);
		int cnt=bdao.deleteArticle(num, passwd);
		if(cnt<0) {
			return getPage;
		}
		else {
			
		return gotoPage;
		}
	}
}
