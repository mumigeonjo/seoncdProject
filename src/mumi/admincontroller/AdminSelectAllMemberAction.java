package mumi.admincontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.MemberDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminSelectAllMemberAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();

		try {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");

			if (!id.equals("admin")) {
				throw new Exception("관리자로 로그인하고 이용하세요");
			}
			
			List<MemberDTO> list = MumiService.adminSelectAllMember();
			request.setAttribute("list", list);
			mv.setPath("view/memberList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("404.html");
		}
		return mv;
	}

}
