package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardWriteController {
	private final String command="/write.bd";
	private String getPage="/writeForm";
	private String gotoPage="redirect:/list.bd";
	@Autowired
	private BoardDao bdao;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction() {
		return getPage;
		
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@Valid @ModelAttribute("bean") BoardBean bean,BindingResult result,HttpServletRequest request) {
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		bean.setReg_date(ts);
		bean.setIp(request.getRemoteAddr());
		if(result.hasErrors()) {
			return getPage;
		}
		bdao.insertArticle(bean);
		return gotoPage;
		
	}
}
