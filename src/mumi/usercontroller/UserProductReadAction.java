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

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*		
		ModelAndView mv = new ModelAndView();
		
		//�𵨹�ȣ �ޱ�
		String pCode = request.getParameter("pCode");
				
		try {
			ProductDTO productDTO = MumiService.userProductRead(pCode);
			request.setAttribute("productDTO", productDTO);//viewpage���� ${list}
			mv.setPath("?"); 
			
			//System.out.println(list);	
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//�������� ${errorMsg}
			mv.setPath("errorView/error.jsp");			
		}	*/
		return null;
	}

}
