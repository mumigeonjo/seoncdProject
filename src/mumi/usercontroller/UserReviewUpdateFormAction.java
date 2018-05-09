package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.ReviewDTO;
import mumi.model.service.MumiService;

public class UserReviewUpdateFormAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv=new ModelAndView();

		try {
			String rIndexNo = request.getParameter("rIndexNo");
			
			ReviewDTO dto =MumiService.userReviewUpdateForm(rIndexNo);
			
			request.setAttribute("dto", dto);
			
			mv.setPath("view/userReviewUpdateForm.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("view/404.html");
		}
		
		return mv;
	}


}
