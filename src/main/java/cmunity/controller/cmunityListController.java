package cmunity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cmunity.model.cmunityBean;
import cmunity.model.cmunityDao;
import utility.Paging;

@Controller
public class cmunityListController {
	private final String command="List.cmu";
	private final String goPage="b_cmunityCondition";
	
	@Autowired
	cmunityDao cdao;
	
	@RequestMapping(value=command)
	public ModelAndView viewList(
							@RequestParam(value="whatColumn", required=false) String whatColumn,
							@RequestParam(value="keyword", required=false) String keyword,
							@RequestParam(value="pageNumber", required=false) String pageNumber,
							@RequestParam(value="gender", required=false) String gender,
							HttpServletRequest request) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");

		int totalCount = cdao.totalCount(map);
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber, null, totalCount, url, whatColumn, keyword);
		
		//자유게시판
		List<cmunityBean> lists = cdao.List(pageInfo, map);
		
		System.out.println("lists.size : " + lists.size());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(goPage);
		
		return mav;
	}
	
}
