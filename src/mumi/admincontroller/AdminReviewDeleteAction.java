package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;
public class AdminReviewDeleteAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		int rIndexNo = (int)session.getAttribute("rIndexNo");
		
		
		try {
			int result = MumiService.adminReviewDelete(rIndexNo);
			session.setAttribute("result", result); 
			
			mv.setPath("???");
			mv.setRedirect(false);
			return mv;
		}catch(SQLException e){
			e.printStackTrace();
		}
			
		return null;
		
	}

}
