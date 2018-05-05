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
		
		//모델번호 받기
		String pCode = request.getParameter("pCode");
				
		try {
			ProductDTO productDTO = MumiService.userProductRead(pCode);
			request.setAttribute("productDTO", productDTO);//viewpage에서 ${list}
			mv.setPath("?"); 
			
			//System.out.println(list);	
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
			mv.setPath("errorView/error.jsp");			
		}	*/
		return null;
	}

}
