package bplist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bplist.model.BplistDao;
import bplist.model.BpreplyBean;

@Controller
public class UpdateReplyController {
	@Autowired
	private BplistDao bdao;
@RequestMapping(value="updatereply.blist" ,method = RequestMethod.GET)
public String doupdsdatereply(
		@RequestParam("replenum") int replenum
		
		, HttpServletRequest request
		) {
	BpreplyBean replyBean = bdao.selectreply(replenum);
	request.setAttribute("replyBean", replyBean);
	request.setAttribute("replenum", replenum);
	return "replyUpdateForm";
}
@RequestMapping(value="updatereply.blist" ,method = RequestMethod.POST)
public String doupdatereply(
		@RequestParam("num") int num,
		BpreplyBean replyBean ,Model model
		) {
	int cnt = bdao.updatereply(replyBean);
	List<BpreplyBean> replylist =  bdao.replylist(num);
	model.addAttribute("replylist",replylist);
	return "productDetailView";
}

}
