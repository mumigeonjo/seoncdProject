package mumi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QADTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminQAReadDetailAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//readforUpdateÀÌ¿ë
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		int bIndexNo =(int)session.getAttribute("b_indexno");
		
		try{
			
			QADTO qaDTO = MumiService.selectQADetailByQANO(bIndexNo);
			request.setAttribute("qaDetail", qaDTO);
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
