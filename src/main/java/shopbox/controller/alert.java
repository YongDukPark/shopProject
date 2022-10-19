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
				pw = response.getWriter(); //글 출력할때 쓰는애 난 기억이 안난다.
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('상품중 재고를 확인해주세요.');  history.go(-1);</script>");	//얘로 셋팅하고
			pw.flush();	//얘로 출력하는듯
			//나느 
			//return "redirect:/order.sbox";
			return "order.sbox";
		}
		
		return "";
	}

}
