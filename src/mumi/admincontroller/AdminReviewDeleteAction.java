package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;
public class AdminReviewDeleteAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MumiService service= new MumiService();
		ModelAndView mv = new ModelAndView();
		int rIndexNo = Integer.parseInt(request.getParameter("rIndexNo"));
		
		try {
			int re= service.adminReviewDelete(rIndexNo);
		}catch(SQLException e){
			e.printStackTrace();
		}
			
		return mv;
		
	}

}
