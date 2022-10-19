package notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class NoticeViewController {
	private final String command ="/view.nt";
	private String getPage = "noticeView";
	
	@Autowired
	private NoticeDao nvdao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)	
	public ModelAndView doAction(@RequestParam("num") int num,
								@RequestParam("pageNumber") String pageNumber,
								Model model) {
	
		nvdao.addReadCount(num);
		NoticeBean nvbean = nvdao.getNoticenv(num);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("nvbean", nvbean); 
		mav.addObject("pageNumber", pageNumber);
		
		mav.setViewName(getPage);
		
		return mav;
	}
}	