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

public class AdminNoticeInsertAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		MumiService service = new MumiService();
		
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		
		System.out.println("AdminNoticeInsertAction");
		
		NoticeDTO dto = new NoticeDTO(nTitle, nContent);
		
		//��ȿ�� üũ
		if(nTitle==null ||nContent==null) {
			try { // �ٷ� url�ּҷ� �������� �˷��ֱ� ���� (http://localhost:8000/ex12_MVCElecBoard/elec?command=insert)
				throw new SQLException("�Է°��� ������� �ʽ��ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {

			int re = MumiService.insertNotice(dto);
			if(re>0) { //����� �Ϸ�Ǿ���
				mv.setPath("mumi?command=noticeRead"); //default�� list���� ?command=list �ȳ־��൵��
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
