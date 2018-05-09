package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.service.MumiService;

/**
 * 장바구니 삭제 버튼을 눌렀을 때 실행된다.
 * 각 사용자의 장바구니 목록에서 체크된 상품을 지운다..?
 * 뷰에서 삭제할 상품의 인덱스를 보내준다. -> 뷰에서 미리 저장해 놔야겠네..? JSON으로?
 * 뷰가 어떻게 생겼냐에 따라 인자가 달라짐.
 * @author user
 *
 */
public class UserCartDeleteAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		ServletContext application = request.getServletContext();
		
		//뷰에서 삭제할 상품의 인덱스를 보내준다.
		try {
			MumiService.deleteCart(Integer.parseInt(request.getParameter("oIndexNo")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mv.setPath("/view/cart.jsp");
		}
		return mv;
	}
}
