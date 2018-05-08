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

public class AdminReviewDeleteAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String memberId= (String)session.getAttribute("id");
			if(memberId=="admin") {
				int rIndexNo = Integer.parseInt(request.getParameter("rIndexNo"));

				try {
					int result = MumiService.adminReviewDelete(rIndexNo);
					if (result > 0) {
						mv.setPath("???");
						mv.setRedirect(false);
					} else {
						throw new SQLException("리뷰삭제에 실패했습니다.");

					}

				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", e.getMessage());
					mv.setPath("404.html");
				}
			}else {
				mv.setPath("index.jsp");
				mv.setRedirect(true);
			}
		
	

		return mv;

	}

}
