package bplist.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bplist.model.BplistBean;
import bplist.model.BplistDao;


@Controller
public class BplistUpdateController {
	
	private final String command = "update.blist";
	private String getPage = "productUpdateForm";
	private String gotoPage = "redirect:/list.blist";
	
	@Autowired
	private BplistDao bdao;
	
	@Autowired
	ServletContext servletContext; 

	// productList.jsp
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(
							@RequestParam(value="num", required=true) int num,
							@RequestParam(value="pageNumber", required=true) String pageNumber,
							Model model
							) {
		
		BplistBean bb = bdao.getProduct(num);
		model.addAttribute("bpBean", bb);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
	
	
	// productUpdateForm.jsp
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("bpBean") BplistBean bb,
								@RequestParam(value="pageNumber", required=true) int pageNumber,
								MultipartFile upload	
								) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		String uploadPath = servletContext.getRealPath("/resources");
		
		// 湲곗〈�뿉 �뾽濡쒕뱶�맂 �뙆�씪 遺덈윭���꽌..
		MultipartFile multi = bb.getUpload();

		if(multi.getSize()>0) {	// �뙆�씪 �겕湲곌� 0蹂대떎 �겕硫� = �뙆�씪 議댁옱�븯硫�?
			
			// �뙆�씪 �궘�젣�븯怨�,
			new File(uploadPath + "\\" + bb.getImg()).delete();
			
			// �깉 �뙆�씪 �벑濡앺븯湲�
			File file = new File(uploadPath + "\\" + bb.getImg());	
			multi.transferTo(file);
		}
		
		
		int cnt = bdao.updateProduct(bb);
		
		if(cnt>0) {
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(gotoPage);	// �닔�젙 �꽦怨듯븯硫� 紐⑸줉蹂닿린濡� 媛�怨�, 
		}
		else {
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(getPage);	// �닔�젙 �떎�뙣�븯硫� �닔�젙�뤌�쑝濡� �룎�븘媛�
		}
		
		return mav;
	}

}
