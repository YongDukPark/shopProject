package bplist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bplist.model.BplistDao;

@Controller
public class BplistDeleteController {
	private final String command = "delete.blist";
	private final String gotoPage = "redirect:/list.blist";

	@Autowired
	private BplistDao bdao;

	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(
							@RequestParam(value="num", required=true)int num,
							@RequestParam(value="pageNumber", required=true)int pageNumber
							) {

		int cnt = bdao.deleteProduct(num);
		return gotoPage+"?pageNumber="+pageNumber;
		
	}

}



