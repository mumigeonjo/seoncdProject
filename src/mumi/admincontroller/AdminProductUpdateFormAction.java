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



public class AdminProductUpdateFormAction implements Action {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("errorView/error.jsp");
		
		String pCode = request.getParameter("pCode");
		try{
			if(pCode==null){
				throw new SQLException("pCode가 없습니다.");
			}
			ProductDTO proDto = MumiService.adminProductRead(pCode);
			if(proDto==null){
				throw new SQLException("해당하는 상품이 없습니다.");
			}else{
				request.setAttribute("proDto", proDto);
				mv.setPath("adminProductUpdate.jsp");
			}
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		return mv;
	}

}



