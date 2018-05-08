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
public class AdminProductUpdateAction implements Action{

	@Override  //�ٿ�
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		
		String pCode = request.getParameter("pCode");
		int pPrice = Integer.parseInt(request.getParameter("pPrice"));
		int pEA = Integer.parseInt(request.getParameter("pEA"));
		String pImage = request.getParameter("pImage");
		String pDetailImage = request.getParameter("pDetailImage");
		
		ProductDTO productDTO = new ProductDTO(pCode, pPrice, pEA, pImage, pDetailImage);
		
		try {
			int result = MumiService.adminProductUpdate(productDTO);
			mv.setPath("?");
			mv.setRedirect(true);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		return mv;
	}

}