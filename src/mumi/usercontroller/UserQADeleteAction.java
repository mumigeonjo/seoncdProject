package mumi.usercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QADTO;
import mumi.model.service.MumiService;

public class UserQADeleteAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		int bIndexNo =(int)session.getAttribute("b_indexno");
		
		try{
			
			int result = MumiService.deleteQA(bIndexNo);
			session.setAttribute("result", result);
			/*
			for(QADTO qaDTO:list) {
				System.out.println(qaDTO);
			}*/
			
			mv.setPath("???");
			mv.setRedirect(false);
			return mv;
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}


}
