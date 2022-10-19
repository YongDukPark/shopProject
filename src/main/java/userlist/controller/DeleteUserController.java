package userlist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import userlist.model.DeleteuserBean;
import userlist.model.userlistBean;
import userlist.model.userlistDao;

@Controller
public class DeleteUserController {
	@Autowired
	private userlistDao uDao;
	@RequestMapping(value="DeleteUser.ulist",method=RequestMethod.GET)
	public String SearchId() {
		return "DeleteUserForm";
	}
	@RequestMapping(value="DeleteUser.ulist",method=RequestMethod.POST)
	public String SearchId(@RequestParam("pass") String pass,HttpServletResponse response,HttpServletRequest request,
			@ModelAttribute("deleteuserBean") @Valid DeleteuserBean deleteuserBean ,BindingResult result
			) {
		if(result.hasErrors()) {
			return "DeleteUserForm";
		}
		userlistBean user = new userlistBean();
		user.setPass(pass);
	  int cnt = uDao.deleteuser(user);
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter pw=null;
	if(1<=cnt) {
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<script> alert('ȸ��Ż�� �Ϸ�Ǿ����ϴ�.');</script>");
		pw.flush();
		
		return "DeleteComplete";
	}//ȸ��Ż�� ������
	else {
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<script> alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');</script>");
		pw.flush();
		return "DeleteUserForm";
	}//ȸ��Ż�� ���н�
	}//�޼ҵ�
}//class
