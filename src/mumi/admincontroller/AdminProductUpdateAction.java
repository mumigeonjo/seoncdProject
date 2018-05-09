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

	@Override  //다영
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		
		String pCode = request.getParameter("pCode");
		String pPrice = request.getParameter("pPrice");
		String pEA = request.getParameter("pEA");
		
		//String pImage = request.getParameter("pImage");
		//String pDetailImage = request.getParameter("pDetailImage");
		
		//유효성 검사
		try{
		  if(pCode==null || pPrice==null || pEA==null){
			
			  throw new SQLException("입력값이 충분하지 않습니다.");
		  }
		
		   ProductDTO productDTO = new ProductDTO(pCode, Integer.parseInt(pPrice), Integer.parseInt(pEA));
		
		   int result = MumiService.adminProductUpdate(productDTO);
		   // commmand=detailView , modelNum=? , flag=?
		   mv.setPath("mumi?command=userProductRead&pCode="+pCode);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		return mv;
		
	}
}
