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
		
		ModelAndView mv=new ModelAndView();
		int qIndexNo =Integer.parseInt(request.getParameter("qIndexNo"));

		String qDate = "1991/11/29";
		String qContent = request.getParameter("qContent");

		try{
			
			result = MumiService.updateAnswer(new QAReplyDTO(qIndexNo, qDate, qContent));
			
			
			mv.setPath("view/QA.jsp");
			//mv.setRedirect(false);
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return mv;
	}

}
