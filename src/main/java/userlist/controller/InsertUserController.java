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
import org.springframework.web.bind.annotation.RequestParam;

import userlist.model.InsertuserBean;
import userlist.model.userlistBean;
import userlist.model.userlistDao;

@Controller
public class InsertUserController {
	private final String command = "InsertUser.ulist";
	private final String getPage = "InsertUserForm";
	private String gotoPage = "InsertComplete";

	@Autowired
	private userlistDao uDao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String inertForm() {
		return getPage;
	}// 회원가입 클릭시

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doActon(HttpServletResponse response, HttpServletRequest request,
			@RequestParam("pass") String pass,@RequestParam("repass") String repass,
			@ModelAttribute("insertuserBean") @Valid InsertuserBean insertuserBean, BindingResult result) {
		if (result.hasErrors()) {
			request.setAttribute("id", insertuserBean.getId());
			request.setAttribute("name", insertuserBean.getName());
			request.setAttribute("gender", insertuserBean.getGender());
			request.setAttribute("birth", insertuserBean.getBirth());
			request.setAttribute("address1", insertuserBean.getAddress1());
			request.setAttribute("address2", insertuserBean.getAddress2());
			request.setAttribute("pass", insertuserBean.getPass());
			request.setAttribute("repass", insertuserBean.getRepass());
			request.setAttribute("gender", insertuserBean.getGender());
			
			
			if((repass!="")&&(pass.equals(repass)==false)) {
			String	flag="nomatch";
			
				request.setAttribute("flag", flag);
			
			}
			else if(pass.equals(repass)==true){
				String flag="match";
				request.setAttribute("flag", flag);
			}
			
			return getPage;
		}
		if((repass!="")&&(pass.equals(repass)==false)) {
			String	flag="nomatch";
			request.setAttribute("id", insertuserBean.getId());
			request.setAttribute("name", insertuserBean.getName());
			request.setAttribute("gender", insertuserBean.getGender());
			request.setAttribute("birth", insertuserBean.getBirth());
			request.setAttribute("address1", insertuserBean.getAddress1());
			request.setAttribute("address2", insertuserBean.getAddress2());
			request.setAttribute("pass", insertuserBean.getPass());
			request.setAttribute("repass", insertuserBean.getRepass());
			request.setAttribute("gender", insertuserBean.getGender());
			request.setAttribute("flag", flag);
			return getPage;
		}
		userlistBean userBean = new userlistBean();
		userBean.setId(insertuserBean.getId());
		userBean.setPass(insertuserBean.getPass());
		userBean.setName(insertuserBean.getName());
		userBean.setGender(insertuserBean.getGender());
		userBean.setBirth(Integer.parseInt(insertuserBean.getBirth()));

		userBean.setAddress1(insertuserBean.getAddress1());
		userBean.setAddress2(insertuserBean.getAddress2());

		int cnt = uDao.inserUser(userBean);
		if (cnt != 1) {
			 response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = null;
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.println("<script>alert('회원가입 실패 관리자에게 문의해주세요.')</script>");
			pw.flush();
			return getPage;
		}
		return gotoPage;
	}// 가입하기 클릭시
	
	  @RequestMapping(value="Idcheck.ulist") 
	  public String	  idcheck(HttpServletResponse response, @RequestParam("id") String id, HttpSession session	) { 
		  response.setContentType("text/html; charset=UTF-8");

		  PrintWriter pw =null;
		  if(id=="") {
			  try {
				  pw =	response.getWriter();
			  } catch (IOException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
			 
			  pw.println("<script>alert('아이디를 입력해주세요.');history.go(-1);</script>");
			  pw.flush();
			  return getPage;
		  }
		 
		  userlistBean user=uDao.searchId(id);
	
	 
	  if(user==null) {	  
		  try {
			  pw =	response.getWriter();
		  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		 
		  pw.println("<script>alert('사용가능한 아이디입니다.');history.go(-1);</script>");
		  pw.flush();
	  }
	  else {
		  try {
			  pw =	response.getWriter();
		  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		  pw.println("<script>alert('사용중인 아이디입니다.');history.go(-1);</script>");
		  pw.flush();
	  }
	 
	  
	  
	return getPage;
	 }//중복확인 클릭시
	 
}
