package cmunity.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cmunity.model.cmunityBean;
import cmunity.model.cmunityDao;

@Controller
public class cmunityInsertController {
	private final String command = "insertForm.cmu";
	private final String login = "login";
	private final String goPage = "d_cmunityInsert";
	private final String insert = "cmunityInsert.cmu";
	private String goInsert = "redirect:/List.cmu";
	
	@Autowired
	private cmunityDao cdao;
	
	@Autowired
	ServletContext servletContext; 
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session, HttpServletResponse response) {
		
		PrintWriter pw = null;	//set1
		response.setContentType("text/html; charset=UTF-8"); //set1
		
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('로그인 먼저 해주세요'); location.href='login.ulist'</script>");	//얘로 셋팅하고
			pw.flush();	//얘로 출력하는듯
			return login;
		}
		return goPage;
	}
	
	@RequestMapping(value=insert, method = RequestMethod.POST)
	public ModelAndView doAction(cmunityBean bean, HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		String id = (String)session.getAttribute("id");
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath : " + uploadPath);
		
		MultipartFile multi = bean.getUpload();	// <- MultipartFile이 인터페이스기 때문에 multi = new multi 형식으로 객체 만들수 없어서
		
		bean.setId(id);
		bean.setIp(request.getRemoteAddr());
		
		System.out.println("bean:"+bean.getImg());
		System.out.println("bean:"+bean.getContent());
		System.out.println("bean:"+bean.getSubject());
		System.out.println("bean:"+bean.getGender());
		System.out.println("bean:"+bean.getPname());
		System.out.println("bean:"+bean.getCategory());
		System.out.println("bean:"+bean.getPrice());
		System.out.println("bean:"+bean.getStock());
		System.out.println("bean:"+bean.getPoption());
		System.out.println("bean:"+bean.getIp());
		
		int cnt = cdao.insert(bean);
		
		String number = cdao.getInsertNumber();	//가장 마지막에 등록한 regdate의 넘 가져오기
		
		System.out.println("number:"+number);
		
		cdao.insertProduct(bean,number);
		
		if (cnt > 0 ) {
			File f = new File(uploadPath + "\\" + bean.getImg());	
			
			try {
				multi.transferTo(f);	// transferTo: 예외 2가지 발생하므로 반드시 예외처리해줘야 함
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(goInsert);
		}
		else {
			mav.setViewName("redirect:/insertForm.cmu");
		}
		return mav;
	}
	
}
