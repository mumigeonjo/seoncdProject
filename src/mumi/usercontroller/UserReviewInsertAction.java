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

public class UserReviewInsertAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		

		
		String pCode= request.getParameter("pCode");
		String memberId = request.getParameter("memberId");
		String rContent = request.getParameter("rContent");
		String rPhoto = request.getParameter("rPhoto");
		int rRate = Integer.parseInt(request.getParameter("rRate"));
		try {
			ReviewDTO reviewDTO = new ReviewDTO(0, pCode, memberId, null, rContent, rPhoto, rRate);
			result = MumiService.userReviewInsert(reviewDTO);
			System.out.println("result"+result);
			if (result > 0) {
				request.setAttribute("result", result);
				mv.setPath("view/productDetail.jsp");
				mv.setRedirect(false);
			} else {
				throw new SQLException("리뷰작성에 실패했습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("view/404.html");
		}
		return mv;

	}

}
