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
		
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		String memberId = (String)session.getAttribute("id");
		String rContent = request.getParameter("rContent");
		String rDate = request.getParameter("rDate");
		String rPhoto = request.getParameter("rPhoto");
		int rRate = Integer.parseInt(request.getParameter("rRate"));
		
		try {
			int result=MumiService.userReviewUpdate(new ReviewDTO(0, null, null,new Date().toLocaleString(), rContent,  rPhoto,
			 rRate));
			if(result>0) {
			mv.setPath("view/review.jsp");
			mv.setRedirect(true);
			}else {
				throw new SQLException("수정에 실패했습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("404.html");
			
		}
		
		
		return mv;
	}


}
