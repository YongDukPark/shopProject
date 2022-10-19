package shopbox.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopbox.model.shopboxBean;
import shopbox.model.shopboxDao;

@Controller
public class singleOrderController {

	private final String singleOrder="single.sbox";
	private String getPage="singleOrderPage";
	private String alert = "redirect:/alert.sbox";
	
	@Autowired
	private shopboxDao sdao;
	
	//단일상품 주문시
	@RequestMapping(value=singleOrder,method = RequestMethod.GET)
	public ModelAndView doAction(HttpSession session, shopboxBean bean,
								@RequestParam("num")String bpnum, 
								@RequestParam("stock")int bpstock,
								@RequestParam("poption")String bpoption
								) {
		String id = (String) session.getAttribute("id");
		//bean 에 넣기
		ModelAndView mav = new ModelAndView();
		System.out.println("id:"+id);
		System.out.println(id);
		
		//문제점 수량 안넣고 주문하기하면 그냥 바로 넘어감
		if(id == null) {
			
			mav.addObject("type","login");
			mav.setViewName(alert);
			
			return mav;
		}
		
		
		bean = sdao.getSingleOrder(id,bpnum);
		
		//기존에 값이 있을경우 기존 정보 지우기
		if(bean != null) {
			sdao.cancelOrder(bpnum, id);
		}
		
		
		//insert 작업 체크용
		String insert = (String)session.getAttribute("insert");
		
		System.out.println("insert : " + insert);
		System.out.println("싱글이야 여기오니?");
		//넘겨진 상품번호기반으로 상품정보 가져온다음에 그 상품번호정보 와 stock , options bean에 넣고 shopbox에 insert 진행, 
		
		
		//1.기존 상품번호 정보 가져오기 (bplist)
		bean = sdao.getProduct(bpnum);
		
		//2.상품에 정보 바꾸기
		bean.setId(id);
		bean.setStock(bpstock);
		bean.setPoption(bpoption);
		
		//if(insert == null) {
			//3.바꾼 정보로 insert진행하기
		sdao.singleShopboxInsert(bean);
			
			//insert 작업 했는지
		insert = "y";
			//한번 넣었을경우 시행 안되게
		session.setAttribute("insert", insert);
			
		//}
		
		System.out.println("여기오면 성공임");
		
		
		
		//상품정보 가져오기
		bean = sdao.getSingleOrder(id,bpnum);
		
		System.out.println("여기를 못오나?");
		
		
		System.out.println(bean.getNum());
		//상품 잔여수량 체크
		int stock = sdao.getShopStock(bean.getNum());
		
		
		
		mav.addObject("bean",bean);
		mav.addObject("stock",stock);
		mav.addObject("insert",insert);
		mav.setViewName(getPage);
		
		
		return mav;
	}

}
