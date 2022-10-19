package bplist.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bplist.model.BplistBean;
import bplist.model.BplistDao;


@Controller
public class BplistInsertController {

	private final String command = "/insert.blist";
	private String getPage = "productInsertForm";
	private String gotoPage = "redirect:/list.blist";
	
	
	@Autowired
	private BplistDao bdao;
	
	@Autowired
	ServletContext servletContext; 
	// 프로젝트의 resources 경로에 접근하기 위함 (why? : 그 위치에 이미지파일 등등 업로드하려고)
	
	
	// productList에서 "추가하기" 눌러서 입력폼으로 이동할 때 여기로 와서 요청 처리함
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	
	// productInsertForm.jsp에서 추가하기(submit) 눌렀을 때 
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@Valid BplistBean bb, 
								BindingResult result,
								HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		String uploadPath = servletContext.getRealPath("/resources");
		// 워크스페이스 경로\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\shop\resources
		
		MultipartFile multi = bb.getUpload();	// <- MultipartFile이 인터페이스기 때문에 multi = new multi 형식으로 객체 만들수 없어서

		bb.setIp(request.getRemoteAddr());
		
		// 유효성검사
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;	
		}
		int cnt = bdao.insertProduct(bb);
		
		if (cnt > 0 ) {
			File file = new File(uploadPath + "\\" + bb.getImg());	

			try {
				multi.transferTo(file);	// transferTo: 예외 2가지 발생하므로 반드시 예외처리해줘야 함
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(gotoPage); // 레코드 삽입 성공시 목록보기로 리다이렉트,
			
		}
		else {
			mav.setViewName(getPage);	// 레코드 삽입 실패 시 입력폼으로 돌아감.
		}
		
		return mav;
	}
	
}
