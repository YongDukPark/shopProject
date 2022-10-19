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
		
		
		
		//로그인 안했을경우
		if(id == null) {
			model.addAttribute("type","login");
			
			return alert;
		}
		
		
		//확인용(상품정보 받아오기용) shopbox에서
		bean = sdao.getSingleOrder(id, num);
		
		
		//만약 장바구니에 상품이 있으면 update 진행 방금 입력한 상품 수량으로
		if(bean != null) {
			sdao.cancelOrder(num, id);
		}
		
		//값 넣어오기
		bean = sdao.getProduct(num);
		
		//bean 값 바꿔주기
		bean.setId(id);
		bean.setStock(Integer.parseInt(stock));
		
		System.out.println("1");
		
		//장바구니 insert 작업진행
		
		sdao.singleShopboxInsert(bean);
		
		//confirm 으로 장바구니 갈건지 안갈건지 물어보고 true면 넘어가고 false면 history.go(-1)
		
		model.addAttribute("type","Paymentcompleted");
		
		System.out.println("2");
			
		return alert;
	}
	
}
