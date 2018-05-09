package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.ProductDTO;
import mumi.model.service.MumiService;

public class UserProductReadAction implements Action{

	//http://localhost:8000/second_PJ/mumi?command=userProductRead
	
	@Override //�ٿ�
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		
		//�𵨹�ȣ �ޱ�
		String pName = request.getParameter("pName");
				
		try {
			List<ProductDTO> list = MumiService.userProductRead(pName);
			request.setAttribute("list", list);//viewpage���� ${proDTO}
			mv.setPath("view/userProductRead.jsp"); 
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//�������� ${errorMsg}
			mv.setPath("errorView/error.jsp");			
		}
		return mv;
	}
}
