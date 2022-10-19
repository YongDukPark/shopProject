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
			pw.println("<script> alert('�α��� ���� ���ּ���');  location.href='login.ulist';</script>");	//��� �����ϰ�
			pw.flush();	//��� ����ϴµ�
			return "";
		}
		
		else if(type.equals("Paymentcompleted")) {
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script>"
					+ " var answer = confirm('��ٱ��Ϸ� ���ðڽ��ϱ�?');  "
					+ "if(answer==true){ location.href='shopboxlist.sbox' }"
					+ "else if(answer==false){ history.go(-1) }"
					+ "</script>");	//��� �����ϰ�
			pw.flush();	//��� ����ϴµ�
			return "";
		}
		
		
		return "";
	}
	
}
