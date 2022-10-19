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

import userlist.model.SearchidBean;
import userlist.model.SearchpassBean;
import userlist.model.userlistBean;
import userlist.model.userlistDao;

@Controller
public class SearchUserController {
	
	@Autowired
	private userlistDao uDao;
	
@RequestMapping(value="SearchId.ulist",method=RequestMethod.GET)
public String SearchId() {
	return "SearchIdForm";
}
@RequestMapping(value="SearchPass.ulist",method=RequestMethod.GET)
public String SearchPass() {
	return "SearchPassForm";
}
@RequestMapping(value="SearchId.ulist",method=RequestMethod.POST)
public String SearchId(/*userlistBean user,*/HttpServletResponse response,@RequestParam("birth") String birth,@RequestParam("name") String name, HttpServletRequest request ,@ModelAttribute("searchidBean")
@Valid SearchidBean searchidBean,BindingResult result) {
	userlistBean user;
	if(birth=="") {
		request.setAttribute("birth",searchidBean.getBirth());
		request.setAttribute("name",searchidBean.getName() );
		return "SearchIdForm";	
	}
	else if(result.hasErrors()) {
		request.setAttribute("name",searchidBean.getName() );
		request.setAttribute("birth",searchidBean.getBirth());
		return "SearchIdForm";
	}
	else {
		user= new userlistBean();
		user.setBirth(Integer.parseInt(birth));
		user.setName(name);
		//request.setAttribute("name",searchidBean.getName() );
	//	request.setAttribute("birth",searchidBean.getBirth());
	}
	userlistBean suser = uDao.SearchId(user);
	if(suser==null) {
		request.setAttribute("name",searchidBean.getName() );
		request.setAttribute("birth",searchidBean.getBirth());
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("<script>alert('존재하지 않는 회원입니다.');</script>");
		pw.flush();
		return "SearchIdForm";
	}
	request.setAttribute("userid", suser.getId());
	return "ResultId";
}
@RequestMapping(value="SearchPass.ulist",method=RequestMethod.POST)
public String SearchPass(HttpServletResponse response,@RequestParam("id") String id,@RequestParam("birth") String birth,@RequestParam("name") String name, HttpServletRequest request
		,@ModelAttribute("searchpassBean")@Valid SearchpassBean searchpassBean,BindingResult result) {
	userlistBean user;
	if(birth=="") {
		request.setAttribute("birth",searchpassBean.getBirth());
		request.setAttribute("name",searchpassBean.getName() );
		request.setAttribute("id",searchpassBean.getId() );
		return "SearchPassForm";	
	}
	else if(result.hasErrors()) {
		request.setAttribute("birth",searchpassBean.getBirth());
		request.setAttribute("name",searchpassBean.getName() );
		request.setAttribute("id",searchpassBean.getId() );
		return "SearchPassForm";
	}
	else {
		user= new userlistBean();
		user.setBirth(Integer.parseInt(birth));
		user.setName(name);
		user.setId(id);
	
	}
   userlistBean suser = uDao.SearchPass(user);
	
   if(suser==null) {
		request.setAttribute("birth",searchpassBean.getBirth());
		request.setAttribute("name",searchpassBean.getName() );
		request.setAttribute("id",searchpassBean.getId() );
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("<script>alert('존재하지 않는 회원입니다.');</script>");
		pw.flush();
		return "SearchPassForm";
	}
   
	request.setAttribute("userpass", suser.getPass());
	return "ResultPass";
}
}
