package shopbox.controller;

import java.util.ArrayList;
import java.util.List;

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
public class listOrderController {
	
	
	private final String listOrder="order.sbox";
	private String getPage="listOrderPage";
	
	//수량 확인용
	int[] stockCheck = new int[300];
	
	@Autowired
	private shopboxDao sdao;
	
	
	//장바구니에서 주문시 리스트 보여주기용
	@RequestMapping(value=listOrder,method = RequestMethod.GET)
	public ModelAndView doAction2(HttpSession session, HttpServletRequest request, shopboxBean bean) {
		String type = "list";
		
		System.out.println("1");
		
		ModelAndView mav = new ModelAndView();
		//세션값 가져오기
		String id = (String)session.getAttribute("id");
		
		
		//장바구니에서 체크한 상품들
		String[] num = request.getParameterValues("rowcheck");
		
		
		//lists 출력용
		//List<shopboxBean> lists = sdao.getListOrder(id);
		
		
		//담기용
		List<shopboxBean> lists = new ArrayList<shopboxBean>();
		
		System.out.println("2");
		
		//1. dao 에서 id랑 rowcheck 값으로 가져오기
		for(int i=0;i<num.length;i++) {
			bean = sdao.getCheckList(num[i],id);
			//2. bean 으로 반복하고 lists.set(i, bean)	이런식으로 넣자
			System.out.println("들어가나?");
			lists.add(bean);
			
		}
		
		System.out.println("lists.size : " + lists.size());
		
		System.out.println("3");
		
		System.out.println("lists.size():"+lists.size());
		System.out.println("여기오니?");
		
		//상점 잔여수량을 알기위한거
		for(int i=0;i<lists.size();i++) {
			int stock = sdao.getShopStock(lists.get(i).getNum()); 	
			stockCheck[i] = stock;
			System.out.println("lists.get(i).getNum():"+lists.get(i).getNum());
			System.out.println("stockCheck[i]"+stockCheck[i]);
		}
		System.out.println("4");
		
//		//상점 잔여수량을 알기위한거	보험용
//		for(int i=0;i<lists.size();i++) {
//			int stock = sdao.getShopStock(lists.get(i).getNum());
//			stockCheck[i] = stock;
//			System.out.println("lists.get(i).getNum():"+lists.get(i).getNum());
//			System.out.println("stockCheck[i]"+stockCheck[i]);
//		}
		
		
		int totalPrice = 0;
		
		System.out.println("여기는 오니?");
		
		for(int i=0;i<lists.size();i++) {
			totalPrice+=lists.get(i).getPrice()*lists.get(i).getStock();
		}
		
		mav.addObject("stockCheck",stockCheck);
		mav.addObject("lists",lists);
		mav.addObject("type",type);
		mav.addObject("totalPrice",totalPrice);
		mav.addObject("listsSize",lists.size());
		mav.setViewName(getPage);
		
		return mav;
	}
	
	
	
}
