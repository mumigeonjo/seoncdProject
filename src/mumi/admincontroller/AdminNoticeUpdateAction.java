package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.NoticeDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminNoticeUpdateAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		MumiService service = new MumiService();
		
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		String nIndexNo = request.getParameter("nIndexNo");
		
		NoticeDTO dto = new NoticeDTO(nIndexNo,nTitle, nContent);
		
		System.out.println("AdminNoticeUpdateAction : "+ nTitle+" : "+nContent+" : "+nIndexNo);
		
		//유효성 체크
		if(nTitle==null ||nContent==null||nIndexNo==null) {
			try { // 바로 url주소로 들어왔을때 알려주기 위해 (http://localhost:8000/ex12_MVCElecBoard/elec?command=insert)
				throw new SQLException("입력값이 충분하지 않습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {

			int re = MumiService.updateNotice(dto);
			if(re>0) { //등록이 완료되었다
				mv.setPath("mumi?command=noticeRead");
				mv.setRedirect(true); //redirect방식으로 이동				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("errorView/error.jsp");
		}
		return mv;	

	}

}
