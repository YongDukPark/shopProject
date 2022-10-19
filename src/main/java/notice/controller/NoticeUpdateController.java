package notice.controller;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class NoticeUpdateController {

	private final String command = "update.nt";
	private String getPage = "noticeUpdateForm";
	private String gotoPage = "redirect:/list.nt";
	
	@Autowired
	private NoticeDao nudao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(
							@RequestParam(value="num", required=true) int num,
							@RequestParam(value="pageNumber", required=true) int pageNumber,
							Model model) {
		NoticeBean nubean = nudao.getNotice(num);
		model.addAttribute("nubean",nubean);
		model.addAttribute("pageNumber",pageNumber);

		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
								@Valid NoticeBean nubean,BindingResult result,
								@RequestParam(value="pageNumber",required = true) int pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		System.out.println("pageNumber:" + pageNumber);
		
		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = nudao.updateNotice(nubean);
		if(cnt>0) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(gotoPage);
		}
		else {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		}
		return mav;
		}
		
		
	}
	


