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
	
	//���� Ȯ�ο�
	int[] stockCheck = new int[300];
	
	@Autowired
	private shopboxDao sdao;
	
	
	//��ٱ��Ͽ��� �ֹ��� ����Ʈ �����ֱ��
	@RequestMapping(value=listOrder,method = RequestMethod.GET)
	public ModelAndView doAction2(HttpSession session, HttpServletRequest request, shopboxBean bean) {
		String type = "list";
		
		System.out.println("1");
		
		ModelAndView mav = new ModelAndView();
		//���ǰ� ��������
		String id = (String)session.getAttribute("id");
		
		
		//��ٱ��Ͽ��� üũ�� ��ǰ��
		String[] num = request.getParameterValues("rowcheck");
		
		
		//lists ��¿�
		//List<shopboxBean> lists = sdao.getListOrder(id);
		
		
		//����
		List<shopboxBean> lists = new ArrayList<shopboxBean>();
		
		System.out.println("2");
		
		//1. dao ���� id�� rowcheck ������ ��������
		for(int i=0;i<num.length;i++) {
			bean = sdao.getCheckList(num[i],id);
			//2. bean ���� �ݺ��ϰ� lists.set(i, bean)	�̷������� ����
			System.out.println("����?");
			lists.add(bean);
			
		}
		
		System.out.println("lists.size : " + lists.size());
		
		System.out.println("3");
		
		System.out.println("lists.size():"+lists.size());
		System.out.println("�������?");
		
		//���� �ܿ������� �˱����Ѱ�
		for(int i=0;i<lists.size();i++) {
			int stock = sdao.getShopStock(lists.get(i).getNum()); 	
			stockCheck[i] = stock;
			System.out.println("lists.get(i).getNum():"+lists.get(i).getNum());
			System.out.println("stockCheck[i]"+stockCheck[i]);
		}
		System.out.println("4");
		
//		//���� �ܿ������� �˱����Ѱ�	�����
//		for(int i=0;i<lists.size();i++) {
//			int stock = sdao.getShopStock(lists.get(i).getNum());
//			stockCheck[i] = stock;
//			System.out.println("lists.get(i).getNum():"+lists.get(i).getNum());
//			System.out.println("stockCheck[i]"+stockCheck[i]);
//		}
		
		
		int totalPrice = 0;
		
		System.out.println("����� ����?");
		
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
