package notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import notice.model.NoticeBean;
import notice.model.NoticeDao;
import utility.Paging;

@Controller
public class NoticeListController {
	private final String command = "/list.nt";
	private String getPage = "noticeList";

	@Autowired
	private NoticeDao ntdao;
	
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam(value="whatColumn",required = false) String whatColumn,
								@RequestParam(value="keyword",required = false) String keyword,
								@RequestParam(value="pageNumber",required = false) String pageNumber,
								@RequestParam(value="pageSize",required = false) String pageSize,
								HttpServletRequest request) {

		Map<String,String> map = new HashMap<String,String>();
		if(pageNumber==null) {
			pageNumber="1";
		}
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = ntdao.getTotalCount(map);
		
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		
		int num = totalCount+1 - (pageInfo.getPageNumber()-1) * pageInfo.getPageSize();

		ModelAndView mav = new ModelAndView();
		List<NoticeBean> list = ntdao.getNoticeList(pageInfo, map);
		mav.addObject("list", list);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("num", num);
		mav.addObject("map", map);
		
		mav.setViewName(getPage);
		return mav;
 
	}
	
}
