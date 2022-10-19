package cmunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cmunity.model.cmunityBean;
import cmunity.model.cmunityDao;

@Controller
public class cmunityMainController {
	
	private final String command = "main.cmu";
	private String goPage = "a_cmunityMain";
	
	@Autowired
	private cmunityDao cdao;
	
	@RequestMapping(command)
	public String doAction(cmunityBean bean, Model model) {
		
		//main likecount 10 이상
		List<cmunityBean> like = cdao.getMainLike(bean);
		//성별 여성 readcount 20 이상
		List<cmunityBean> girl = cdao.getMainGirl(bean);
		//성별 남성 readcount 20 이상
		List<cmunityBean> men = cdao.getMainMen(bean);
		
		model.addAttribute("like",like);
		model.addAttribute("girl",girl);
		model.addAttribute("men",men);
		
		return goPage;
	}
	
}
