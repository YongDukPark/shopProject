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
public class updateOrder {
	
	private final String viewProduct = "viewProduct.sbox"; 
	private String productDetail = "productDetail"; 
	private final String command = "update.sbox";
	
	
	
	@Autowired
	private shopboxDao sdao;
	
	
	@RequestMapping(value=viewProduct)
	public String viewProduct(HttpSession session, @RequestParam(value="num") String num, Model model) {
		
		String id = (String) session.getAttribute("id");
		
		shopboxBean bean = sdao.productDetail(num,id);
		
		model.addAttribute("bean",bean);
		
		return productDetail;
	}
	
	
	@RequestMapping(value=command)
	public void update(HttpSession session, @RequestParam(value="num") String num) {
		
		String id = (String) session.getAttribute("id");
		
		sdao.updateOptions(num,id);
		
		
		
	}
	
	
}
