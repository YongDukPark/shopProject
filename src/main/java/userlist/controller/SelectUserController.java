package userlist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import userlist.model.SelectuserBean;
import userlist.model.userlistBean;
import userlist.model.userlistDao;
@Controller
public class SelectUserController {
	private final String command = "SelectUser.ulist";
	private final String command2 = "UpdateUser.ulist";
	private final String getPage = "SelectUserForm";
//private String gotoPage="InsertComplete";

	@Autowired
	private userlistDao uDao;

@RequestMapping(value=command,method=RequestMethod.GET)
public String doAtion() {
	return  getPage;
}
@RequestMapping(value=command2,method=RequestMethod.POST)
public String doAtion(HttpSession session, HttpServletResponse response,userlistBean user,
//		@ModelAttribute("selectuserBean") @Valid SelectuserBean selectuserBean,
		BindingResult result) {
//if(result.hasErrors()) {
//	return  getPage;
//}
	response.setContentType("text/html; charset=UTF-8");
userlistBean loginInfo =(userlistBean)session.getAttribute("loginInfo");
	user.setId(loginInfo.getId());
	
	int cnt = uDao.UpdateUser(user);
	if(cnt!=1) {
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<script> alert('수정이 실패하였습니다.');</script>");
		pw.flush();
			return  getPage;
	}
	
	session.setAttribute("loginInfo", user);
PrintWriter pw=null;
try {
	pw = response.getWriter();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
pw.println("<script> alert('수정이 완료되었습니다.');</script>");
pw.flush();
	return  getPage;
}
}
