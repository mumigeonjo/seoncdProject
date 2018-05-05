package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.ProductDTO;
import mumi.model.service.MumiService;

public class UserProductAllReadAction implements Action{

	@Override //다영
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*ModelAndView mv = new ModelAndView();
		
		try {
			List<ProductDTO> list = MumiService.userProductAllRead();
			request.setAttribute("list", list);//viewpage에서 ${list}
			mv.setPath("?"); 
			
			//System.out.println(list);	
		} catch (SQLException e) {
			e.printStackTrace();
			//request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
			//mv.setPath("errorView/error.jsp");			
		}	*/
		return null;
	}

}
