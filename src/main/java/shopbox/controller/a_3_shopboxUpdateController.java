package shopbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shopbox.model.shopboxBean;
import shopbox.model.shopboxDao;

@Controller
public class a_3_shopboxUpdateController {
	private final String command = "shopboxupdate.sbox";
	private final String updateAction = "updateAction.sbox";
	
	@Autowired
	shopboxDao sdao;
	
	//장바구니에서 넘어옴 세션값 필요없음 id만
	@RequestMapping(value = command)
	public void doAction(HttpServletResponse response, 
							@RequestParam(value="num")String num, 
							@RequestParam(value="pname")String pname, 
							HttpSession session) {
		response.setContentType("text/html; charset=UTF-8"); //set1
		
		String id = (String)session.getAttribute("id");
		
		
		PrintWriter pw = null;	//set1
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		pw.println("<script> history.go(-1); window.open('shopboxUpdatePopup.jsp?num="+num+"&id="+id+"&pname="+pname+"','수량교체','width=500 height=300'); focusPopup.focus();  </script>");	//얘로 셋팅하고
		pw.flush();	//얘로 출력하는듯
	}
	
	@RequestMapping(value = updateAction)
	public void Action(shopboxBean bean, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8"); //set1
		PrintWriter pw = null;	//set1
		//System.out.println("bean.id:"+bean.getId());
		//System.out.println("bean.stock:"+bean.getStock());
		//System.out.println("bean.num:"+bean.getNum());
		
		sdao.shopboxUpdate(String.valueOf(bean.getNum()), String.valueOf(bean.getStock()), bean.getId());
		
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		pw.println("<script> alert('교체완료 새로고침(F5)을 눌러주세요.'); window.close(); </script>");	//얘로 셋팅하고
		pw.flush();	//얘로 출력하는듯
		
	}
	
}
