package benlist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import benlist.model.benlistBean;
import benlist.model.benlistDao;

@Controller
public class benlistController {
	
	private final String command = "benLists.ben";
	private final String Change = "benListsChange.ben";
	
	private String goPage="benList";
	
	@Autowired
	private benlistDao bdao;
	
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(Model model) {
		
		//리스트 뽑기용
		
		List<benlistBean> lists = bdao.getBenList();
		
		model.addAttribute("lists",lists);
		
		return goPage;
	}
	
	@RequestMapping(value = Change, method = RequestMethod.GET)
	public void Action(HttpServletRequest request, @RequestParam(value="option")String option, HttpServletResponse response) {
		
		String[] num = request.getParameterValues("rowcheck");
		
		PrintWriter pw = null;	
		response.setContentType("text/html; charset=UTF-8");
		
		int count = 0;
		
		System.out.println("option:" + option);
		
		if(option.equals("report")) {
			for(int i=0;i<num.length;i++) {
				System.out.println(num[i]);
				bdao.getByReport(num[i]);
			}
		}
		
		
		else if(option.equals("cancel")) {
			for(int i=0;i<num.length;i++) {
				bdao.getByCancel(num[i]);
			}
		}
		
		try {
			pw = response.getWriter(); //글 출력할때 쓰는애 난 기억이 안난다.
		} catch (IOException e) {
			e.printStackTrace();
		}	
		pw.println("<script> alert('작업이 완료되었습니다.'); history.go(-1); </script>");	
		pw.flush();
		
		
	}
	
	
}
