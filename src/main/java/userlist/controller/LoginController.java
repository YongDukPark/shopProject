package userlist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import userlist.model.LoginBean;
import userlist.model.userlistBean;
import userlist.model.userlistDao;
@Controller
public class LoginController {
	private final String command = "login.ulist";
	private final String getPage = "login";
private String gotoPage="MemberMain";
@Autowired
private userlistDao uDao;

@RequestMapping(value=command,method=RequestMethod.GET)
public String doAction() {
	
	return getPage;
}//로그인 폼으로 이동

	@RequestMapping(value=command,method=RequestMethod.POST)
	public String doActon(HttpServletRequest request,HttpSession session, HttpServletResponse response , @ModelAttribute("UserBean")
	 userlistBean userBean, @ModelAttribute("loginBean") @Valid LoginBean loginBean,BindingResult result) {
		response.setContentType("text/html; charset=UTF-8");

		if(result.hasErrors()) {
			request.setAttribute("id",loginBean.getId() );
			request.setAttribute("pass",loginBean.getPass() );
			
			
			return getPage;
		}
		//임시
		
	userlistBean user = uDao.searchId(userBean.getId());
	PrintWriter pw=null;
	if(user == null) { 
		request.setAttribute("id",loginBean.getId() );
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.println("<script> alert('해당 아이디가 존재하지 않습니다');</script>");
		pw.flush();
		return getPage;
	}
	
	else { 

		if(user.getPass().equals(userBean.getPass())) { 
			request.setAttribute("id",loginBean.getId());
			if(user.getId().equals("admin")) {
				session.setAttribute("loginInfo", user);
				session.setAttribute("id", user.getId());
				   return "AdminMain";
			}
			session.setAttribute("id", user.getId());
			session.setAttribute("loginInfo", user);
			
			String id = (String)session.getAttribute("id");
			System.out.println("login id:"+id);
			
			return gotoPage;
		}//아이디가 존재하면서 비번일치
		else { 
			request.setAttribute("id",loginBean.getId() );
			
			try {
				pw=response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.println("<script> alert('비밀번호가 일치하지 않습니다.');</script>");
			pw.flush();
		}//아이디가 존재하면서 비번불일치
		return getPage;
	}//아이디가 존재할경우
		

	}//login 관련 메소드 로그인 하려할때
}//class