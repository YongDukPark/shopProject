package shopbox.controller;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopbox.model.shopboxBean;
import shopbox.model.shopboxDao;

@Controller
public class listOrderController2 {
	
	private final String command="finalListOrder.sbox";
	private String goPage = "finalOrder";
	//private String backPage = "redirect:/order.sbox";
	private String backPage = "retry";
	
	@Autowired
	private shopboxDao sdao;
	
	
	//결제 진행시
	@RequestMapping(value = command,method = RequestMethod.GET)
	public ModelAndView order(HttpServletRequest request, HttpSession session, shopboxBean bean) {
		
		
		
		ModelAndView mav = new ModelAndView();
		//체크한 상품들 num번호 가져오는곳
		String[] num = request.getParameterValues("rowcheck");
		
		
		
		int[] stockCheck = new int[300];
		int[] stockOrCheck = new int[300];
		int type = 2;
		int count = 0;
		int totalPrice = 0;
		
		String id = (String) session.getAttribute("id");
		
		
		//재고 가져와서 주문이 가능한지 비교하기용
		for(int i=0;i<num.length;i++) {
			
			int checkStock = sdao.selectStockCheck1(num[i]);
			int checkOrStock = sdao.selectStockCheck2(num[i],id);
			int price = sdao.totalPrice(num[i],id);
			totalPrice += price;
			
			
			stockCheck[i] = checkStock;
			stockOrCheck[i] = checkOrStock;
		}
		
		System.out.println("totalPrice:"+totalPrice);
		
		//갯수가 부족하여 주문 불가할경우
		for(int i = 0;i<num.length;i++) {	//set1
			if((stockCheck[i]-stockOrCheck[i])<0) {
				type = 1;
				mav.addObject("type",type);
				mav.setViewName("redirect:/alertStock.sbox");
				
				return mav;
				
			}
		}
		
		System.out.println("type : " + type);
		
		if(type == 2) {
			//for 로 반복해서 실행시키기
			//select 로 상품 정보 가져온후 거기있는 상품의 stock 감소시키기
			for(int i=0;i<num.length;i++) {
				//System.out.println(num[i]);	//넘어오는 상품번호
				
				//상품 주문시 장바구니> 배송중 교체
				sdao.selectBynum(num[i],id);
				
				//상품 주문시 status 배송중으로 교체하는 코드 + 장바구니 담은시간에서 주문한 시간으로 변하는 코드
				sdao.changeStatus(num[i],id);
				
				
				
				count+=1;	// count 누적 상품 갯수
			}
			
			mav.addObject("count",count);
			mav.addObject("totalPrice",totalPrice);
			mav.setViewName(goPage);
			goPage="finalOrder";
		}
		
		else {
			mav.setViewName(backPage);	//장바구니로 보내자 어떠한 문제인지는 몰라도 리턴이 안된다.
			
		}
		
		return mav;
		
		
	}
	
	
	
}
