package bplist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bplist.model.BplistDao;
import bplist.model.BpreplyBean;

@Controller
public class DeleteReplyController {
	@Autowired	
	private BplistDao bdao;
@RequestMapping(value="deletereply.blist")
public String doupdatereply(
		@RequestParam(value="num", required = false) int num,
		@RequestParam(value="replenum", required = false) int replenum
		,Model model
		) {
	int cnt = bdao.deletereply(replenum);
	List<BpreplyBean> replylist =  bdao.replylist(num);
	model.addAttribute("replylist",replylist);
	return "productDetailView";
}
}
