package mumi.usercontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QADTO;
import mumi.model.dto.QAReplyDTO;
import mumi.model.service.MumiService;


public class UserQAReadAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("id");
		List<QADTO> list=new ArrayList<>();
		
		try {

			
			list = MumiService.selectQAByQAIndex(userid);
			
			
			request.setAttribute("userQARead", list);
			
			mv.setPath("view/QA.jsp");
			

		} catch (Exception e) {

			e.printStackTrace();

		}

		return mv;
	}
}
