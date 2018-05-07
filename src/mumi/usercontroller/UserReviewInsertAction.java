package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.filters.SessionInitializerFilter;

import mumi.model.dto.ReviewDTO;
import mumi.model.service.MumiService;

public class UserReviewInsertAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result =0;
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		
		
		int rIndexNo= (int)session.getAttribute("rIndexNo");
		String pCode= (String)session.getAttribute("pCode");
		String memberId= (String)session.getAttribute("memberId");
		String rDate= (String)session.getAttribute("rDate");
		String rcontent= (String)session.getAttribute("rcontent");
		String rphoto= (String)session.getAttribute("rphoto");
		int rRate= (int)session.getAttribute("rRate");
		
		try {
			ReviewDTO reviewDTO= new ReviewDTO(rIndexNo, pCode, memberId, rDate, rcontent, rphoto,rRate);
			result=MumiService.userReviewInsert(reviewDTO);
			request.setAttribute("result", result);
			
			mv.setPath("???");
			mv.setRedirect(false);
			return mv;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
