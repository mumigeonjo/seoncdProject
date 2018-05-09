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
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String memberId= (String)session.getAttribute("id");
		
		String pCode = request.getParameter("pCode");
		
			if(memberId.equals("admin")) {
				int rIndexNo = Integer.parseInt(request.getParameter("rIndexNo"));
				
				try {
					int result = MumiService.adminReviewDelete(rIndexNo);
					if (result > 0) {
						//mv.setPath("view/productDetail.jsp");
						mv.setPath("mumi?command=userReviewRead&pCode="+pCode);
						mv.setRedirect(true);
					} else {
						throw new SQLException("리뷰삭제에 실패했습니다.");

					}

				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", e.getMessage());
					mv.setPath("404.html");
				}
			}else {
				mv.setPath("index.html");
				mv.setRedirect(true);
			}
		
		return mv;

	}

}
