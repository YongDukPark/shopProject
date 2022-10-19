package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardContentsController {
	private final String command="/content.bd";
	private String getPage="content";
	@Autowired
	private BoardDao bdao;
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num,@RequestParam("pageNumber") String pageNumber,Model model) {
		BoardBean bean=bdao.getArticle(num);
		model.addAttribute("bean",bean);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}
	
}
