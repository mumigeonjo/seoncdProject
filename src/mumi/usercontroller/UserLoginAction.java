package mumi.usercontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.MemberDTO;
import mumi.model.service.MumiService;

public class UserLoginAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		try {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if(id==null || pwd==null) {
			throw new SQLException("정보를 입력하고 이용하세요");
		}
		
		
		MemberDTO dto=MumiService.selectUserById(id, pwd);
		
		if(dto==null) {
			mv.setPath("view/loginForm.jsp");
			request.setAttribute("errorMsg", "아이디와 비밀번호를 확인하세요");
		}else {
		
		session.setAttribute("id", dto.getMemberID());
		mv.setPath("view/main.jsp");
		mv.setRedirect(false);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("view/404.html");
		}
		return mv;
	}

}
