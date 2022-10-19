package shopbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopbox.model.shopboxDao;

@Controller
public class singleOrderController2 {
	
	private final String command="finalSingleOrder.sbox";
	private String goPage = "finalOrder";
	
	@Autowired
	private shopboxDao sdao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String order(@RequestParam(value="totalprice", required = false) String totalPrice,
						@RequestParam(value="num", required = false) String num, HttpSession session,
						HttpServletResponse response, Model model) {
		
		System.out.println(totalPrice);
		System.out.println(num);
		String id = (String) session.getAttribute("id");
		response.setContentType("text/html; charset=UTF-8"); //set1
		PrintWriter pw = null;	//set1
		
		//ModelAndView mav = new ModelAndView();
		int count = 1;
		
			
		int checkStock = sdao.selectStockCheck1(num);
		int checkOrStock = sdao.selectStockCheck2(num,id);
		
		if((checkStock-checkOrStock)<0) {
			
			try {
				pw = response.getWriter(); //글 출력할때 쓰는애 난 기억이 안난다.
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			session.removeAttribute("insert");
			sdao.cancelOrder(num, id);
			
			pw.println("<script> alert('상품중 재고를 확인해주세요.'); history.go(-2);</script>");	//얘로 셋팅하고
			pw.flush();	//얘로 출력하는듯
			
			
			return "redirect:/single.sbox";
		}
		
		
		
		//상품 주문시 장바구니> 배송중 교체
		sdao.selectBynum(num,id);
		
		//상품 주문시 status 배송중으로 교체하는 코드 + 장바구니 담은시간에서 주문한 시간으로 변하는 코드
		sdao.changeStatus(num,id);
		
		
		
		//mav.addObject("count", count);
		
		model.addAttribute("totalPrice",totalPrice);
		model.addAttribute("count",count);
		//mav.setViewName(goPage);
		
		session.removeAttribute("insert");
		
		return goPage;
	}
}
