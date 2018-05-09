package mumi.admincontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.ProductDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminProductAllReadAction implements Action{

	// http://localhost:8000/second_PJ/mumi?command=adminProductAllRead
	
	@Override //다영
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> list = MumiService.userProductAllRead();
		request.setAttribute("list", list);//viewpage에서 ${list}
		mv.setPath("adminProductList.jsp");
		
		return mv;
	}

}
