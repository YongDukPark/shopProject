package userlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import userlist.model.userlistBean_gang;
import userlist.model.userlistDao_gang;
import utility.Paging;

@Controller
public class userListController {
		
		private final String command = "/userList.ulist";
		private String goPage = "userList";
		@Autowired
		private userlistDao_gang udao;
		@RequestMapping(value = command)
		public String doAction(Model model,
				HttpServletRequest request,
				@RequestParam(value="pageNumber",required = false) String pageNumber,
				@RequestParam(value="pageSize",required = false) String pageSize,
				@RequestParam(value="whatColumn",required = false) String whatColumn,
				@RequestParam(value="keyword",required = false) String keyword) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("whatColumn", whatColumn);
			map.put("keyword", "%"+keyword+"%");
			String url=request.getContextPath()+command;
			int totalCount=udao.getTotalCount(map);
			Paging pageInfo=new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
			List<userlistBean_gang> list=udao.getUserList(pageInfo,map);
			model.addAttribute("list",list);
			model.addAttribute("pageInfo",pageInfo);
			model.addAttribute("totalCount",totalCount);
			return goPage;
		}
}
