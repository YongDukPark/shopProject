package notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import notice.model.NoticeDao;

@Controller
public class NoticeDeleteController {
	private final String command = "/delete.nt";
	private final String gotoPage = "redirect:/list.nt";	
	
	@Autowired
	private NoticeDao nddao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(@RequestParam(value="num", required = true)int num,
							@RequestParam(value="pageNumber", required=true)int pageNumber) {

		int cnt = nddao.deleteNotice(num);
		return gotoPage+"?pageNumber="+pageNumber;
	}
	
}
