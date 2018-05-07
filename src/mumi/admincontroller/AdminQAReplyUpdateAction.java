package mumi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QAReplyDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;
public class AdminQAReplyUpdateAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		int bIndexNo =(int)session.getAttribute("b_indexno");
		String qDate = (String)session.getAttribute("qDate");
		String qContent = (String)session.getAttribute("qContent");
		
		try{
			
			result = MumiService.updateAnswer(new QAReplyDTO(bIndexNo, qDate, qContent));
			request.setAttribute("result", result);
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
