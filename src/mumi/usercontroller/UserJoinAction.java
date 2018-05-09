package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.MemberDTO;
import mumi.model.service.MumiService;

public class UserJoinAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String addr = request.getParameter("addr");

			if (id == null || pwd == null || name == null || phone == null || addr == null) {
				throw new SQLException("입력값이 충분하지 않습니다.");
			}

			int result = MumiService.insertUser(new MemberDTO(id, pwd, name, phone, addr, 0));
			System.out.println(result+"=result");
			if (result > 0) {
				mv.setPath("index.html");
				mv.setRedirect(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "동일한 아이디가 있습니다.");
			mv.setPath("view/register.jsp");
		}
		return mv;
	}

}
