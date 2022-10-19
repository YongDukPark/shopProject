package cmunity.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cmunity.model.cmunityBean;
import cmunity.model.cmunityDao;

@Controller
public class cmunityUpdateController {
	private final String command = "cmunityUpdate.cmu";
	private String goPage = "e_cmunityUpdate";
	private String goDetail = "redirect:/detail.cmu";
	
	@Autowired
	private cmunityDao cdao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam(value="num")String num, Model model) {
		
		cmunityBean bean = cdao.detailView(num);
		
		model.addAttribute("bean",bean);
		
		return goPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(cmunityBean bean, HttpServletRequest request) {
		System.out.println("1bean:"+bean.getImg());
		ModelAndView mav = new ModelAndView();
		
		MultipartFile multi = bean.getUpload();	// <- MultipartFile이 인터페이스기 때문에 multi = new multi 형식으로 객체 만들수 없어서
		String uploadPath = servletContext.getRealPath("/resources");
		int cnt=0;
		
		
		System.out.println("multi:"+multi);
		
		System.out.println("2bean:"+bean.getImg());
		System.out.println("bean:"+bean.getContent());
		System.out.println("bean:"+bean.getSubject());
		System.out.println("bean:"+bean.getGender());
		System.out.println("bean:"+bean.getPname());
		System.out.println("bean:"+bean.getCategory());
		System.out.println("bean:"+bean.getPrice());
		System.out.println("bean:"+bean.getStock());
		System.out.println("bean:"+bean.getPoption());
		System.out.println("bean:"+bean.getIp());
		System.out.println("bean:"+bean.getUpload());
		
		cnt = cdao.update(bean);
		
		if (cnt > 0 ) {
			File f = new File(uploadPath + "\\" + bean.getImg());	
			
			System.out.println();
			
			try {
				multi.transferTo(f);	// transferTo: 예외 2가지 발생하므로 반드시 예외처리해줘야 함
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.addObject("num",bean.getNum());
			mav.addObject("type","cmu");
			mav.setViewName(goDetail);
		}
		else {
			mav.setViewName("redirect:/cmunityUpdate.cmu");
		}
			
		
		return mav;
		
	}
}
