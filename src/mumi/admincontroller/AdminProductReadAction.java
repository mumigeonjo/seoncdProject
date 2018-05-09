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
	
	@Override //다영
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		
		//모델번호 받기
		String pCode = request.getParameter("pCode");
				
		try {
			ProductDTO productDTO = MumiService.adminProductRead(pCode);
			request.setAttribute("proDto", productDTO);//viewpage에서 ${proDTO}
			mv.setPath("view/adminProductRead.jsp"); 
			
			//System.out.println(list);	
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
			mv.setPath("errorView/error.jsp");			
		}
		return mv;
	}
}
