package notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class NoticeInsertController {
	private final String command = "/insert.nt";

	private String getPage = "noticeInsertForm"; 
	private String gotoPage = "redirect:/list.nt";
	
	@Autowired
	private NoticeDao ndao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)  
	public String doAction(HttpSession session) {
/*	 HttpSession session
		System.out.println("loginInfo:"+session.getAttribute("loginInfo"));
		if(session.getAttribute("loginInfo") == null) { 
			session.setAttribute("destination", "redirect:/insert.nt");
			
			return "redirect:/loginForm.??"; 
		}
		else {
			return getPage;
		}
*/	
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@Valid NoticeBean noticeBean, BindingResult result ) { 
		
		//System.out.println("Ãâ·Â¿ë");
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			System.out.println(servletContext.getRealPath("/resources")+"\\" + noticeBean.getImage());
			System.out.println("hasError");
			mav.setViewName(getPage);
			return mav;
		}
		
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println(uploadPath+"\\" + noticeBean.getImage());
		 
		MultipartFile multi = noticeBean.getUpload();
		int cnt = ndao.insertNotice(noticeBean);
		if(cnt > 0) {
			 File f = new File(uploadPath+"\\" + noticeBean.getImage());
			 System.out.println("uploaded");
			 try {
				multi.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 mav.setViewName(gotoPage);
		 }
		 else {
			 mav.setViewName(getPage);
		 }
		return mav;
	}
	
	
}
