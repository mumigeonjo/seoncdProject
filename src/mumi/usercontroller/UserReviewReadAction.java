package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QADTO;
import mumi.model.dto.ReviewDTO;
import mumi.model.service.MumiService;

public class UserReviewReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		String pCode = request.getParameter("pCode");//pCode
		try {
			List<ReviewDTO> list= MumiService.userReviewRead(pCode);
			System.out.println("list = " + list);
			request.setAttribute("list", list);
			mv.setPath("view/productDetail.jsp");
			//mv.setRedirect(false);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("404.html");
			
		}
		return mv;
	}
}
	


