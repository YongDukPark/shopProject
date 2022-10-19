package cmunity.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cmunity.model.BpreplyBeanCmu;
import cmunity.model.cmunityDao;


@Controller
public class DeleteReplyControllerCmu {
	@Autowired	
	private cmunityDao bdao;
@RequestMapping(value="deletereply.cmu")
public String doupdatereply(
		@RequestParam(value="num", required = false) int num,
		@RequestParam(value="replenum", required = false) int replenum
		,Model model
		) {
	int cnt = bdao.deletereply(replenum);
	List<BpreplyBeanCmu> replylist =  bdao.replylist(num);
	model.addAttribute("replylist",replylist);
	model.addAttribute("num",num);
	model.addAttribute("type","cmu");
	return "redirect:/detail.cmu";
}
}
