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

public class AdminNoticeUpdateFormAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		MumiService service = new MumiService();
		
		String nIndexNo = request.getParameter("nIndexNo");
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		
		int re = 0;
		//��ȿ�� üũ
		if(nIndexNo==null||nTitle==null||nContent==null) {
			try { // �ٷ� url�ּҷ� �������� �˷��ֱ� ���� (http://localhost:8000/ex12_MVCElecBoard/elec?command=insert)
				throw new SQLException("�Է°��� ������� �ʽ��ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		NoticeDTO dto = new NoticeDTO(nIndexNo,nTitle,nContent);
			
		request.setAttribute("noticeUpdate", dto); //forward��� �̵�
		mv.setPath("view/noticeUpdateForm.jsp");
		
		return mv;	
	}
}
