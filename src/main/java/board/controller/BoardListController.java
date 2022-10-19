package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListController {
	private final String command="/list.bd";
	private String getPage="BoardList";
	@Autowired
	private BoardDao bdao;
	@RequestMapping(command)
	public String doAction(Model model,HttpServletRequest request,HttpSession session,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword) {
		Map<String,String> map=new HashMap<String,String>();
		
		String id = (String)session.getAttribute("id");
		
		if(pageNumber==null) {
			pageNumber="1";
		}
		if(pageSize==null) {
			pageSize="5";
		}
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		int totalCount=bdao.getArticleCount(map);
		String url=request.getContextPath()+command;
		Paging pageInfo=new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		List<BoardBean> list=bdao.getArticleList(pageInfo,map);
		int countNumber=totalCount-(Integer.parseInt(pageNumber)-1)*Integer.parseInt(pageSize);
		model.addAttribute("number",countNumber);
		model.addAttribute("list",list);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}
}
