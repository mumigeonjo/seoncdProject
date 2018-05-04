package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.service.MumiService;

public class UserLeaveAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		try {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id==null) {
			throw new SQLException("세션이 만료되었습니다.");
		}
		
		int result = MumiService.deleteUserById(id);
		
		if(result==0) {
			throw new SQLException("회원탈퇴에 실패했습니다.");
		}
		
		session.invalidate();
		mv.setPath("index.html");
		
		}catch(SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("404.html");
		}
		return mv;

		}
}
