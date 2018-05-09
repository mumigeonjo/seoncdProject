package mumi.usercontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.NoticeDTO;
import mumi.model.service.MumiService;

public class UserNoticeReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		MumiService service = new MumiService();
		
		try {
			List<NoticeDTO> list =MumiService.selectNoticeAll(); //static�̴ϱ� �׳� ������ �ᵵ��

			request.setAttribute("noticeRead", list); //forward��� �̵�
			mv.setPath("view/notice.jsp");
			//mv.setPath("elecView/list.jsp");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("errorView/error.jsp");
		}
		return mv;	
	}

}
