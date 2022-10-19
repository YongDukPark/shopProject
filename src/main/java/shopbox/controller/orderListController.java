package shopbox.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import utility.Paging;

//�����ڿ�
// final Order ������
@Controller
public class orderListController {
	
	private final String ordlist = "/Ordlist.sbox";	//�����ڿ�
	//private final String ordlist = "/Ordlist.sbox";	//�Ϲ� ����ڿ�
	private String goListPage = "orderList";
	
	
	@Autowired
	private shopboxDao sdao;
	
	
	@RequestMapping(value = ordlist,method = RequestMethod.GET)
	public String orderList(
							@RequestParam(value="whatColumn",required = false) String whatColumn,
							@RequestParam(value="keyword",required = false) String keyword,
							@RequestParam(value="pageNumber",required = false) String pageNumber,
							HttpServletRequest request, HttpSession session, Model model
							) {
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		
		
		
		//���� ���ǰ� �ҷ����� id����
		String id = (String)session.getAttribute("id");	//String ���� �ٿ�ĳ����
		map.put("id", id);
		
		System.out.println("�����?");
		
		//��������� �ٲ� ��ǰ�� �ҷ������
		int totalCount=sdao.totalCount(map);
		System.out.println("totalCount:"+totalCount);
		
		System.out.println("�����?");
		String url=request.getContextPath()+ordlist;
		Paging pageInfo=new Paging(pageNumber, null, totalCount, url, whatColumn, keyword);
		
		
		//��������Ʈ �̱��
		List<shopboxBean> lists = sdao.getOrderList(pageInfo,map);
		
		System.out.println("Lists size : " + lists.size());
		
		model.addAttribute("lists",lists);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("pageInfo",pageInfo);
		return goListPage;
	}
	
}
