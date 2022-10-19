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
				pw = response.getWriter(); //�� ����Ҷ� ���¾� �� ����� �ȳ���.
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			session.removeAttribute("insert");
			sdao.cancelOrder(num, id);
			
			pw.println("<script> alert('��ǰ�� ��� Ȯ�����ּ���.'); history.go(-2);</script>");	//��� �����ϰ�
			pw.flush();	//��� ����ϴµ�
			
			
			return "redirect:/single.sbox";
		}
		
		
		
		//��ǰ �ֹ��� ��ٱ���> ����� ��ü
		sdao.selectBynum(num,id);
		
		//��ǰ �ֹ��� status ��������� ��ü�ϴ� �ڵ� + ��ٱ��� �����ð����� �ֹ��� �ð����� ���ϴ� �ڵ�
		sdao.changeStatus(num,id);
		
		
		
		//mav.addObject("count", count);
		
		model.addAttribute("totalPrice",totalPrice);
		model.addAttribute("count",count);
		//mav.setViewName(goPage);
		
		session.removeAttribute("insert");
		
		return goPage;
	}
}
