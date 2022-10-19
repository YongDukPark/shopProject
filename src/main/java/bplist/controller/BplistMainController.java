package bplist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bplist.model.BplistBean;
import bplist.model.BplistDao;

@Controller
public class BplistMainController {

	@Autowired
	private BplistDao bdao;

	private final String command = "main.blist";
	private final String gotoPage = "shopmallMain";
	
	
	@RequestMapping(command)
	public String doAction(BplistBean bean, Model model) {
		
		List<BplistBean> saleProd = bdao.getMainPrice(bean);
		List<BplistBean> soldoutProd = bdao.getMainStock(bean);
		List<BplistBean> menProd = bdao.getMainMen(bean);
		List<BplistBean> wemenProd = bdao.getMainWemen(bean);

		model.addAttribute("saleProd", saleProd);
		model.addAttribute("soldoutProd", soldoutProd);
		model.addAttribute("menProd", menProd);
		model.addAttribute("wemenProd", wemenProd);

		return gotoPage;
		
	};
	
	
}
