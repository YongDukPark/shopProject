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
	
	
	//�Ű��ư ����
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
			pw.println("<script> alert('�α����� ���� ���ּ���'); location.href='login.ulist' </script>");	//��� �����ϰ�
			pw.flush();	//��� ����ϴµ�
		}
		
		//System.out.println(num);
		//System.out.println(id);
		
		else {
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> window.open('benPopUp.jsp?num="+num+"&id="+id+"','�Ű�','width=500 height=300'); history.go(-1); focusPopup.focus(); </script>");	//��� �����ϰ�
			pw.flush();	//��� ����ϴµ�
		}
	}
	
	
	//�� �ۼ��ϰ� submit
	@RequestMapping(value=Action, method = RequestMethod.POST)
	public String doAction(@ModelAttribute("report") @Valid benlistBean bean , BindingResult result
							,HttpServletResponse response) {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = null;	
		
		//��ĭ ����
		if(result.hasErrors()) { 
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('������ ������ �Է����ּ���'); history.go(-1); </script>");	
			pw.flush();
			//return "";
			return "";
			}
		
		//�Ű� ����
		bdao.report(bean);
		
		try {
			pw = response.getWriter(); //�� ����Ҷ� ���¾� �� ����� �ȳ���.
		} catch (IOException e) {
			e.printStackTrace();
		}	
		pw.println("<script> alert('�Ű� �Ϸ�Ǿ����ϴ�.');  window.close() </script>");	
		pw.flush();
		
		return "";
	}
	
	
}
