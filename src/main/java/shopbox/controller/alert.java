package shopbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class alert {
	
	
	
	@RequestMapping(value="alertStock.sbox")
	public String action(HttpServletResponse response, @RequestParam(value = "type") int type) {
		PrintWriter pw = null;	//set1
		response.setContentType("text/html; charset=UTF-8"); //set1
		System.out.println( "type:" + type);
		
		if(type==1) {
			
			try {
				pw = response.getWriter(); //�� ����Ҷ� ���¾� �� ����� �ȳ���.
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('��ǰ�� ��� Ȯ�����ּ���.');  history.go(-1);</script>");	//��� �����ϰ�
			pw.flush();	//��� ����ϴµ�
			//���� 
			//return "redirect:/order.sbox";
			return "order.sbox";
		}
		
		return "";
	}

}
