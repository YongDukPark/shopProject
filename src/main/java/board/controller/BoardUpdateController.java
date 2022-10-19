package board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {
	private final String command="/update.bd";
	private String getPage="/updateForm";
	private String gotoPage="redirect:/list.bd";
	@Autowired
	private BoardDao bdao;
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(@RequestParam("num") int num,@RequestParam("pageNumber") String pageNumber,Model model) {
		BoardBean bean=bdao.getArticle(num);
		model.addAttribute("bean",bean);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String doAction(@Valid @ModelAttribute("bean") BoardBean bean,BindingResult result,@RequestParam("pageNumber") String pageNumber,Model model) {
		//model.addAttribute("bean",bean);
		//model.addAttribute("pageNumber",pageNumber);
		if(result.hasErrors()) {
			System.out.println("hasError");
			model.addAttribute("pageNumber",pageNumber);
			return getPage;
		}
		int cnt=bdao.updateArticle(bean);
		if(cnt>0) {
		return gotoPage+"?pageNumber="+pageNumber;
		}
		else return getPage;
	}
}	
