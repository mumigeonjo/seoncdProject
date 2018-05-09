package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.ProductDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminProductReadAction implements Action{

	//http://localhost:8000/second_PJ/mumi?command=userProductRead
	
	@Override //�ٿ�
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		
		//�𵨹�ȣ �ޱ�
		String pCode = request.getParameter("pCode");
				
		try {
			ProductDTO productDTO = MumiService.adminProductRead(pCode);
			request.setAttribute("proDto", productDTO);//viewpage���� ${proDTO}
			mv.setPath("view/adminProductRead.jsp"); 
			
			//System.out.println(list);	
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//�������� ${errorMsg}
			mv.setPath("errorView/error.jsp");			
		}
		return mv;
	}
}
