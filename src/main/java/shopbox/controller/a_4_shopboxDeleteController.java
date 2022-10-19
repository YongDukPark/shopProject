package shopbox.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shopbox.model.shopboxDao;

@Controller
public class a_4_shopboxDeleteController {
	private final String command = "shopboxdelete.sbox";
	private String goPage = "redirect:/shopboxlist.sbox";
	
	@Autowired
	shopboxDao sdao;
	
	//��ٱ��Ͽ��� �Ѿ�� ���ǰ� �ʿ���� id��
	@RequestMapping(value = command)
	public String doAction(@RequestParam(value = "num")String num, HttpSession session) {
		
		String id = (String)session.getAttribute("id");
		
		
		sdao.cancelOrder(num, id);
		
		
		return goPage;
	}
	
}
