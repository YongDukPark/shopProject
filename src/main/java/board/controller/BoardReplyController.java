package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class BoardReplyController {
	private final String command="/reply.bd";
	private String getPage="replyForm";
	private String gotoPage="redirect:/list.bd";
	@Autowired
	private BoardDao bdao;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(@RequestParam("ref") String ref,
			@RequestParam("re_step") String re_step,
			@RequestParam("re_level") String re_level,
			@RequestParam("pageNumber") String pageNumber,
			Model model,HttpSession session,HttpServletResponse response) {
		System.out.println(session.getAttribute("id"));
		if(!session.getAttribute("id").equals("admin")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = null;
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.println("<script>alert('관리자만 답변등록 가능합니다.');history.go(-1);</script>");
			pw.flush();
			return gotoPage;
		}
		else {
		model.addAttribute("ref",ref);
		model.addAttribute("re_step",re_step);
		model.addAttribute("re_level",re_level);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
		}
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@Valid @ModelAttribute("bean") BoardBean bean,BindingResult result,
			@RequestParam("pageNumber") String pageNumber,Model model,HttpServletRequest request) {
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		bean.setReg_date(ts);
		bean.setIp(request.getRemoteAddr());
		if(result.hasErrors()) {
			return getPage;
		}
		bdao.replyArticle(bean);
		return gotoPage+"?pageNumber="+pageNumber;
	}
}
