package benlist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import benlist.model.benlistBean;
import benlist.model.benlistDao;

@Controller
public class benInsertController {
	
	private final String command = "benList.ben";
	private final String Action = "report.ben";	
	
	@Autowired
	private benlistDao bdao;
	
	
	//신고버튼 누름
	@RequestMapping(value = command)
	public void doAction(@RequestParam("num") String num, @RequestParam("id")String id, 
							HttpSession session, HttpServletResponse response, Model model) {
		
		response.setContentType("text/html; charset=UTF-8"); //set1
		PrintWriter pw = null;	//set1
		
		String userid = (String)session.getAttribute("id");
		
		if(userid==null) {
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('로그인을 먼저 해주세요'); location.href='login.ulist' </script>");	//얘로 셋팅하고
			pw.flush();	//얘로 출력하는듯
		}
		
		//System.out.println(num);
		//System.out.println(id);
		
		else {
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> window.open('benPopUp.jsp?num="+num+"&id="+id+"','신고','width=500 height=300'); history.go(-1); focusPopup.focus(); </script>");	//얘로 셋팅하고
			pw.flush();	//얘로 출력하는듯
		}
	}
	
	
	//글 작성하고 submit
	@RequestMapping(value=Action, method = RequestMethod.POST)
	public String doAction(@ModelAttribute("report") @Valid benlistBean bean , BindingResult result
							,HttpServletResponse response) {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = null;	
		
		//빈칸 잡기용
		if(result.hasErrors()) { 
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('사유와 내용을 입력해주세요'); history.go(-1); </script>");	
			pw.flush();
			//return "";
			return "";
			}
		
		//신고 진행
		bdao.report(bean);
		
		try {
			pw = response.getWriter(); //글 출력할때 쓰는애 난 기억이 안난다.
		} catch (IOException e) {
			e.printStackTrace();
		}	
		pw.println("<script> alert('신고가 완료되었습니다.');  window.close() </script>");	
		pw.flush();
		
		return "";
	}
	
	
}
