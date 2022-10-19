package bplist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bplist.model.BplistBean;
import bplist.model.BplistDao;
import utility.Paging;

@Controller
public class BplistListController {

	private final String command = "/list.blist";
	private String getPage = "productList";
	
	@Autowired
	private BplistDao bdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
							@RequestParam(value="whatColumn", required=false) String whatColumn,
							@RequestParam(value="keyword", required=false) String keyword,
							@RequestParam(value="pageNumber", required=false) String pageNumber,
							HttpServletRequest request
						  ) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");

		int totalCount = bdao.totalCount(map);
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber, null, totalCount, url, whatColumn, keyword);
		
		List<BplistBean> list = bdao.productList(pageInfo, map);
		
		ModelAndView mav = new ModelAndView();
			mav.addObject("list", list);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pageInfo", pageInfo);
			//mav.addObject("gender",gender);
			//mav.addObject("categoy",categoy);
			mav.setViewName(getPage);
			
		return mav;
	}
	
	
	
}
