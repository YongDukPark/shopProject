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
public class cmunityUpLikeCount {
	private final String command = "upLikeCount.cmu";
	
	@Autowired
	private cmunityDao cdao;
	
	@RequestMapping(value = command)
	public void upLikeCount(HttpServletResponse response,@RequestParam(value="num")String num) {
		
		response.setContentType("text/html; charset=UTF-8"); //set1
		PrintWriter pw = null;	//set1
		
		System.out.println("num:"+num);
		
		cdao.uplikecount(num);
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		pw.println("<script> location.href='detail.cmu?num="+num+"&type=cmu';</script>");	//얘로 셋팅하고
		pw.flush();	//얘로 출력하는듯
		
	}
}
