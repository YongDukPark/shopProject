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
	
	//���ϻ�ǰ �ֹ���
	@RequestMapping(value=singleOrder,method = RequestMethod.GET)
	public ModelAndView doAction(HttpSession session, shopboxBean bean,
								@RequestParam("num")String bpnum, 
								@RequestParam("stock")int bpstock,
								@RequestParam("poption")String bpoption
								) {
		String id = (String) session.getAttribute("id");
		//bean �� �ֱ�
		ModelAndView mav = new ModelAndView();
		System.out.println("id:"+id);
		System.out.println(id);
		
		//������ ���� �ȳְ� �ֹ��ϱ��ϸ� �׳� �ٷ� �Ѿ
		if(id == null) {
			
			mav.addObject("type","login");
			mav.setViewName(alert);
			
			return mav;
		}
		
		
		bean = sdao.getSingleOrder(id,bpnum);
		
		//������ ���� ������� ���� ���� �����
		if(bean != null) {
			sdao.cancelOrder(bpnum, id);
		}
		
		
		//insert �۾� üũ��
		String insert = (String)session.getAttribute("insert");
		
		System.out.println("insert : " + insert);
		System.out.println("�̱��̾� �������?");
		//�Ѱ��� ��ǰ��ȣ������� ��ǰ���� �����´����� �� ��ǰ��ȣ���� �� stock , options bean�� �ְ� shopbox�� insert ����, 
		
		
		//1.���� ��ǰ��ȣ ���� �������� (bplist)
		bean = sdao.getProduct(bpnum);
		
		//2.��ǰ�� ���� �ٲٱ�
		bean.setId(id);
		bean.setStock(bpstock);
		bean.setPoption(bpoption);
		
		//if(insert == null) {
			//3.�ٲ� ������ insert�����ϱ�
		sdao.singleShopboxInsert(bean);
			
			//insert �۾� �ߴ���
		insert = "y";
			//�ѹ� �־������ ���� �ȵǰ�
		session.setAttribute("insert", insert);
			
		//}
		
		System.out.println("������� ������");
		
		
		
		//��ǰ���� ��������
		bean = sdao.getSingleOrder(id,bpnum);
		
		System.out.println("���⸦ ������?");
		
		
		System.out.println(bean.getNum());
		//��ǰ �ܿ����� üũ
		int stock = sdao.getShopStock(bean.getNum());
		
		
		
		mav.addObject("bean",bean);
		mav.addObject("stock",stock);
		mav.addObject("insert",insert);
		mav.setViewName(getPage);
		
		
		return mav;
	}

}
