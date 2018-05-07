package mumi.usercontroller;

import java.io.IOException;
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
		HttpSession session = request.getSession();
		String pcode =(String)session.getAttribute("pcode");
		List<ReviewDTO> list;
		
		if (userid.equals("admin")) {
			list = MumiService.selectQAListAll();
		} else {
			list = MumiService.selectQAByQAIndex(userid);
		}
		request.setAttribute("list", list);

		for (QADTO qaDTO : list) {
			System.out.println(qaDTO);
		}

		mv.setPath("???");
		mv.setRedirect(false);
		return mv;

	} catch (Exception e) {

		e.printStackTrace();

	}

	return null;
		return null;
	}

}
