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
}//�α��� ������ �̵�

	@RequestMapping(value=command,method=RequestMethod.POST)
	public String doActon(HttpServletRequest request,HttpSession session, HttpServletResponse response , @ModelAttribute("UserBean")
	 userlistBean userBean, @ModelAttribute("loginBean") @Valid LoginBean loginBean,BindingResult result) {
		response.setContentType("text/html; charset=UTF-8");

		if(result.hasErrors()) {
			request.setAttribute("id",loginBean.getId() );
			request.setAttribute("pass",loginBean.getPass() );
			
			
			return getPage;
		}
		//�ӽ�
		
	userlistBean user = uDao.searchId(userBean.getId());
	PrintWriter pw=null;
	if(user == null) { 
		request.setAttribute("id",loginBean.getId() );
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.println("<script> alert('�ش� ���̵� �������� �ʽ��ϴ�');</script>");
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
		}//���̵� �����ϸ鼭 �����ġ
		else { 
			request.setAttribute("id",loginBean.getId() );
			
			try {
				pw=response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.println("<script> alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');</script>");
			pw.flush();
		}//���̵� �����ϸ鼭 �������ġ
		return getPage;
	}//���̵� �����Ұ��
		

	}//login ���� �޼ҵ� �α��� �Ϸ��Ҷ�
}//class