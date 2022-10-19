package cmunity.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

import cmunity.model.BpreplyBeanCmu;
import cmunity.model.cmunityBean;
import cmunity.model.cmunityDao;

@Controller
public class cmunityDetailController {
	
	private final String detailView = "detail.cmu";
	private String view = "c_cmunityDetail";
	
	@Autowired
	private cmunityDao cdao;
	
	@Autowired
	ServletContext servletContext; 
	
	@RequestMapping(value = detailView)
	public String detailView(@RequestParam(value="num")String num,
							 @RequestParam(value="type")String type,
							cmunityBean bean, Model model) {
		System.out.println("여기는");
		System.out.println("type:"+type);
		
		cdao.upReadCount(num);
		
		bean = cdao.detailView(num);
		
		List<BpreplyBeanCmu> replylist =  cdao.replylist(Integer.parseInt(num) );
		
		model.addAttribute("bean",bean);
		model.addAttribute("replylist",replylist);
		
		return view;
	}
	
	@RequestMapping(value="insertreply.cmu", method=RequestMethod.POST)
	public String doAcasdtion( HttpServletRequest request,
	BpreplyBeanCmu replyBean 	,Model model			,HttpSession session) {
		System.out.println("여기오냐");
		System.out.println("1"+replyBean.getId());
		System.out.println("2"+replyBean.getContent());
		System.out.println("3"+replyBean.getImg());
		System.out.println("4"+replyBean.getInsertdate());
		System.out.println("5"+replyBean.getType());
		System.out.println("6"+replyBean.getNum());
		
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		replyBean.setId(id);
		System.out.println("너니?"+replyBean.getType());
		String uploadPath = servletContext.getRealPath("/resources");
		
		MultipartFile multi = replyBean.getUpload();
		int num = replyBean.getNum();
		
		int cnt = cdao.insertreply(replyBean); 
		
		List<BpreplyBeanCmu> replylist =  cdao.replylist(num);
		model.addAttribute("replylist",replylist);
		model.addAttribute("num",replyBean.getNum());
		model.addAttribute("type","cmu");
		
		if (cnt > 0 ) {
			File f = new File(uploadPath + "\\" + replyBean.getImg());	
			
			try {
				multi.transferTo(f);	// transferTo: 예외 2가지 발생하므로 반드시 예외처리해줘야 함
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/detail.cmu";
		}
		else {
			//return "redirect:/insertForm.cmu";
			return "redirect:/detail.cmu";
		}
		
		
	}
	
	
}
