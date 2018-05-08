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
		
		//��ȿ�� üũ
		if(nTitle==null ||nContent==null||nIndexNo==null) {
			try { // �ٷ� url�ּҷ� �������� �˷��ֱ� ���� (http://localhost:8000/ex12_MVCElecBoard/elec?command=insert)
				throw new SQLException("�Է°��� ������� �ʽ��ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {

			int re = MumiService.updateNotice(dto);
			if(re>0) { //����� �Ϸ�Ǿ���
				mv.setPath("mumi?command=noticeRead");
				mv.setRedirect(true); //redirect������� �̵�				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("errorView/error.jsp");
		}
		return mv;	

	}

}
