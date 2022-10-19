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
	
	
	//���� �����
	@RequestMapping(value = command,method = RequestMethod.GET)
	public ModelAndView order(HttpServletRequest request, HttpSession session, shopboxBean bean) {
		
		
		
		ModelAndView mav = new ModelAndView();
		//üũ�� ��ǰ�� num��ȣ �������°�
		String[] num = request.getParameterValues("rowcheck");
		
		
		
		int[] stockCheck = new int[300];
		int[] stockOrCheck = new int[300];
		int type = 2;
		int count = 0;
		int totalPrice = 0;
		
		String id = (String) session.getAttribute("id");
		
		
		//��� �����ͼ� �ֹ��� �������� ���ϱ��
		for(int i=0;i<num.length;i++) {
			
			int checkStock = sdao.selectStockCheck1(num[i]);
			int checkOrStock = sdao.selectStockCheck2(num[i],id);
			int price = sdao.totalPrice(num[i],id);
			totalPrice += price;
			
			
			stockCheck[i] = checkStock;
			stockOrCheck[i] = checkOrStock;
		}
		
		System.out.println("totalPrice:"+totalPrice);
		
		//������ �����Ͽ� �ֹ� �Ұ��Ұ��
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
			//for �� �ݺ��ؼ� �����Ű��
			//select �� ��ǰ ���� �������� �ű��ִ� ��ǰ�� stock ���ҽ�Ű��
			for(int i=0;i<num.length;i++) {
				//System.out.println(num[i]);	//�Ѿ���� ��ǰ��ȣ
				
				//��ǰ �ֹ��� ��ٱ���> ����� ��ü
				sdao.selectBynum(num[i],id);
				
				//��ǰ �ֹ��� status ��������� ��ü�ϴ� �ڵ� + ��ٱ��� �����ð����� �ֹ��� �ð����� ���ϴ� �ڵ�
				sdao.changeStatus(num[i],id);
				
				
				
				count+=1;	// count ���� ��ǰ ����
			}
			
			mav.addObject("count",count);
			mav.addObject("totalPrice",totalPrice);
			mav.setViewName(goPage);
			goPage="finalOrder";
		}
		
		else {
			mav.setViewName(backPage);	//��ٱ��Ϸ� ������ ��� ���������� ���� ������ �ȵȴ�.
			
		}
		
		return mav;
		
		
	}
	
	
	
}
