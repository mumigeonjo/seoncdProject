package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.MemberDTO;
import mumi.model.service.MumiService;

public class UserUpdateFormAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		try {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");

			if (id == null) {
				throw new SQLException("로그인하고 이용해주세요.");
			}

			MemberDTO dto = MumiService.userUpdateForm(id);
			request.setAttribute("dto", dto);
			mv.setPath("view/myPage.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("404.html");
		}

		return mv;
	}

}
