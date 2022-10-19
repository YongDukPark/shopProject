package shopbox.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shopbox.model.shopboxBean;
import shopbox.model.shopboxDao;

@Controller
public class a_1_shopboxInsertController {
	private final String command = "shopboxinsert.sbox";
	private String alert = "redirect:/alert.sbox";
	//private String login = "login";
	
	@Autowired
	private shopboxDao sdao;
	
	@RequestMapping(value = command)
	public String doAction(HttpSession session, Model model, shopboxBean bean,
							@RequestParam(value="num")String num,
							@RequestParam(value="stock")String stock) {
		
		String id = (String)session.getAttribute("id");
		
		System.out.println("num : " + num);
		System.out.println("stock : "+ stock);
		
		
		
		//�α��� ���������
		if(id == null) {
			model.addAttribute("type","login");
			
			return alert;
		}
		
		
		//Ȯ�ο�(��ǰ���� �޾ƿ����) shopbox����
		bean = sdao.getSingleOrder(id, num);
		
		
		//���� ��ٱ��Ͽ� ��ǰ�� ������ update ���� ��� �Է��� ��ǰ ��������
		if(bean != null) {
			sdao.cancelOrder(num, id);
		}
		
		//�� �־����
		bean = sdao.getProduct(num);
		
		//bean �� �ٲ��ֱ�
		bean.setId(id);
		bean.setStock(Integer.parseInt(stock));
		
		System.out.println("1");
		
		//��ٱ��� insert �۾�����
		
		sdao.singleShopboxInsert(bean);
		
		//confirm ���� ��ٱ��� ������ �Ȱ����� ����� true�� �Ѿ�� false�� history.go(-1)
		
		model.addAttribute("type","Paymentcompleted");
		
		System.out.println("2");
			
		return alert;
	}
	
}
