package bplist.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bplist.model.BplistBean;
import bplist.model.BplistDao;
import bplist.model.BpreplyBean;

@Controller
public class BplistDetailViewController {

	private final String command = "/detail.blist";
	private String getPage = "productDetailView";

	@Autowired
	private BplistDao bdao;
	
	@Autowired
	ServletContext servletContext; 
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(
							@RequestParam(value="num", required=true) int num,
							@RequestParam(value="pageNumber", required=false) int pageNumber,
							Model model,
							HttpServletRequest request,HttpSession session
						  ) {
		
		System.out.println(num+","+pageNumber);
		BplistBean bb = bdao.getProduct(num);
		
		session.setAttribute("productinfo", bb);
		
		model.addAttribute("bb", bb);
		model.addAttribute("pageNumber", pageNumber);
		
		List<BpreplyBean> replylist =  bdao.replylist(num);
		
		model.addAttribute("replylist",replylist);
		
		
		return getPage;
	}
	
	@RequestMapping(value="insertreply.blist", method=RequestMethod.POST)
	public String doAcasdtion( HttpServletRequest request,
	BpreplyBean replyBean 	,Model model			,HttpSession session) {
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		replyBean.setId(id);
		System.out.println(replyBean.getType());
		String uploadPath = servletContext.getRealPath("/resources");
		
		MultipartFile multi = replyBean.getUpload();
		int num = replyBean.getNum();
		
		int cnt = bdao.insertreply(replyBean); 
		
		List<BpreplyBean> replylist =  bdao.replylist(num);
		model.addAttribute("replylist",replylist);
		
		if (cnt > 0 ) {
			File f = new File(uploadPath + "\\" + replyBean.getImg());	
			
			try {
				multi.transferTo(f);	// transferTo: 예외 2가지 발생하므로 반드시 예외처리해줘야 함
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getPage;
		}
		else {
			//return "redirect:/insertForm.cmu";
			return getPage;
		}
		
		
	}
	
}
