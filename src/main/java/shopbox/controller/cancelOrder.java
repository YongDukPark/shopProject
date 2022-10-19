package shopbox.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shopbox.model.shopboxDao;

@Controller
public class cancelOrder {
	
	private final String command = "cancelOrder.sbox";
	private final String adminCommand = "adminCancel.sbox";
	
	
	private String goPage = "redirect:/Ordlist.sbox";
	
	@Autowired shopboxDao sdao;
	
	//���� ĵ��(���ΰŸ� ����)
	@RequestMapping(value=command)
	public String userCancelOrder(@RequestParam("num") String num, HttpSession session) {
		
		String id = (String)session.getAttribute("id");
		
		
		sdao.cancelOrder(num,id);
		
		return goPage;
	}
	
	//������ ����ĵ�� (��ü����)
	@RequestMapping(value=adminCommand)
	public String adminCancelOrder(@RequestParam("num")String num, @RequestParam("id")String id) {
		
		System.out.println("num:"+num);
		System.out.println("id:"+id);
		
		sdao.cancelOrder(num,id);
		
		
		return goPage;
	}
	
}
