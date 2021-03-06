package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminNoticeDeleteAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		MumiService service = new MumiService();
		
		String nIndexNo = request.getParameter("nIndexNo");
		
		//유효성 체크
		if(nIndexNo==null) {
			try { // 바로 url주소로 들어왔을때 알려주기 위해 (http://localhost:8000/ex12_MVCElecBoard/elec?command=insert)
				throw new SQLException("입력값이 충분하지 않습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {

			int re = MumiService.deleteNotice(nIndexNo);
			if(re>0) { //삭제가 완료되었다
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
