package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminProductDeleteAction implements Action {

	@Override  //´Ù¿µ
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		String pCode = request.getParameter("pCode");
		
		try {
			int result = MumiService.adminProductDelete(pCode);
			mv.setPath("mumi?command=adminProductAllRead");
			mv.setRedirect(true);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		return mv;
	}

}
