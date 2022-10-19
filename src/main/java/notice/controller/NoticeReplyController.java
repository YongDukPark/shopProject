package notice.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class NoticeReplyController {

	private final String command = "/reply.nt";
	private String getPage = "noticeReplyForm";
	private String gotoPage = "redirect:/list.nt";

	@Autowired
	private NoticeDao ntdao;

	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView doAction(
								@RequestParam(value = "ref",required = true)int ref,
								@RequestParam(value = "restep",required = true)int restep,
								@RequestParam(value = "relevel",required = true)int relevel
								) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ref",ref);
		mav.addObject("restep",restep+1);
		mav.addObject("relevel",relevel+1);
		mav.setViewName(getPage);

		return mav;
	}

	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@Valid NoticeBean nrbean, BindingResult result ,
								@RequestParam("ref")int ref,
								@RequestParam("restep")int restep,
								@RequestParam("relevel")int relevel,
								HttpServletRequest request) {
//		@RequestParam("pageNumber") String pageNumber,
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("ref", ref);
			mav.addObject("restep",restep+1);
			mav.addObject("relevel",relevel+1);

			mav.setViewName(getPage);
			return mav;
		}

		nrbean.setRegdate(new Timestamp(System.currentTimeMillis()));
		nrbean.setRef(ref);

		ntdao.replyNotice(nrbean,restep,relevel);

		mav.setViewName(gotoPage);

		return mav; 
	}
}


