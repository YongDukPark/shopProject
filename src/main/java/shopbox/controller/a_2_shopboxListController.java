package shopbox.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shopbox.model.shopboxBean;
import shopbox.model.shopboxDao;

@Controller
public class a_2_shopboxListController {
	private final String command = "shopboxlist.sbox";
	private String alert = "redirect:/alert.sbox";
	private String shopbox = "a_1_shopboxList";
	
	@Autowired
	private shopboxDao sdao;
	
	//��ٱ��Ϸ�
	@RequestMapping(value = command)
	public String doAction(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		
		int[] stockCheck = new int[300];
		
		//�α��� üũ
		if(id == null) {
			model.addAttribute("type","login");
			
			return alert;
		}
		
		List<shopboxBean> lists = sdao.getListOrder(id);
		System.out.println("lists.size():"+lists.size());
		
		System.out.println("�������?");
		
		//���� �ܿ������� �˱����Ѱ�
		for(int i=0;i<lists.size();i++) {
			int stock = sdao.getShopStock(lists.get(i).getNum());
			stockCheck[i] = stock;
			System.out.println("lists.get(i).getNum():"+lists.get(i).getNum());
			System.out.println("stockCheck[i]"+stockCheck[i]);
		}
		
		int totalPrice = 0;
		
		System.out.println("����� ����?");
		
		for(int i=0;i<lists.size();i++) {
			totalPrice+=lists.get(i).getPrice()*lists.get(i).getStock();
		}
		
		model.addAttribute("stockCheck",stockCheck);
		model.addAttribute("lists",lists);
		model.addAttribute("totalPrice",totalPrice);
		model.addAttribute("listsSize",lists.size());
		
		return shopbox;
	}
	
	
}
