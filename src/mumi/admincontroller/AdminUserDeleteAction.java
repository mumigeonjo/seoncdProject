package mumi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminUserDeleteAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();

		try {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			String memberID=request.getParameter("memberID");
			

			if (!id.equals("admin")) {
				throw new Exception("관리자로 로그인하고 이용하세요");
			}
			
			int result = MumiService.adminUserDelete(memberID);
			
			if(result>0) {
				mv.setPath("mumi?command=adminSelectAllMember");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("404.html");
		}
		return mv;
	}

}
