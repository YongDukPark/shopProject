package shopbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class a_99_shopboxAlert {


	private final String command = "alert.sbox";
	
	@RequestMapping(value = command)
	public String alert(HttpSession session, Model model, @RequestParam(value="type")String type, HttpServletResponse response) {
		
		
		PrintWriter pw = null;	//set1
		response.setContentType("text/html; charset=UTF-8"); //set1
		System.out.println( "type:" + type);
		
		if(type.equals("login")) {
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('로그인 먼저 해주세요');  location.href='login.ulist';</script>");	//얘로 셋팅하고
			pw.flush();	//얘로 출력하는듯
			return "";
		}
		
		else if(type.equals("Paymentcompleted")) {
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script>"
					+ " var answer = confirm('장바구니로 가시겠습니까?');  "
					+ "if(answer==true){ location.href='shopboxlist.sbox' }"
					+ "else if(answer==false){ history.go(-1) }"
					+ "</script>");	//얘로 셋팅하고
			pw.flush();	//얘로 출력하는듯
			return "";
		}
		
		
		return "";
	}
	
}
