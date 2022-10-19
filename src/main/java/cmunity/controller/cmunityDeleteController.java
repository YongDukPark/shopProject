package cmunity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cmunity.model.cmunityDao;

@Controller
public class cmunityDeleteController {
	private final String command = "cmuDelete.cmu";
	
	@Autowired
	private cmunityDao cdao;
	
	
	@RequestMapping(value=command)
	public void delete(HttpServletResponse response,@RequestParam(value="num")String num) {
		
		PrintWriter pw = null;	//set1
		response.setContentType("text/html; charset=UTF-8"); //set1
		
		cdao.deleteByNum(num);
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		pw.println("<script> location.href='List.cmu';</script>");	//얘로 셋팅하고
		pw.flush();	//얘로 출력하는듯
		
	}
	
	
}
