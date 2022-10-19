package cmunity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cmunity.model.BpreplyBeanCmu;
import cmunity.model.cmunityDao;

	
@Controller
public class UpdateReplyControllerCmu {
	@Autowired
	private cmunityDao bdao;
@RequestMapping(value="updatereply.cmu" ,method = RequestMethod.GET)
public String doupdsdatereply(
		@RequestParam("replenum") int replenum,
		@RequestParam("num") int num,
		
		HttpServletRequest request
		) {
	BpreplyBeanCmu replyBean = bdao.selectreply(replenum);
	request.setAttribute("replyBean", replyBean);
	request.setAttribute("replenum", replenum);
	return "replyUpdateFormCmu";
}
@RequestMapping(value="updatereply.cmu" ,method = RequestMethod.POST)
public String doupdatereply(
		@RequestParam("num") int num,
		BpreplyBeanCmu replyBean ,Model model
		) {
	System.out.println("1");
	int cnt = bdao.updatereply(replyBean);
	System.out.println("2여기오나");
	List<BpreplyBeanCmu> replylist =  bdao.replylist(num);
	model.addAttribute("replylist",replylist);
	/*
	 * model.addAttribute("type","cmu"); model.addAttribute("num",num);
	 */
	return "redirect:/detail.cmu";
}

}
