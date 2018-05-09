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

public class UserReviewUpdateAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv=new ModelAndView();
		
		int rIndexNo= Integer.parseInt(request.getParameter("rIndexNo"));
		String pCode= request.getParameter("pCode");
		String memberId= request.getParameter("memberId");
		String rContent= request.getParameter("rContent");
		int rRate = Integer.parseInt(request.getParameter("rRate"));
		
		try {
			int result = MumiService.updateUserReview(new ReviewDTO(rIndexNo, pCode, memberId, null, rContent, null, rRate));
			mv.setPath("view/productDetail.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("view/404.html");
		}
		
		return mv;

	}
}
