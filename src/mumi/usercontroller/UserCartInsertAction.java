package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.OrderDTO;
import mumi.model.service.MumiService;

/**
 * 장바구니 추가 버튼을 눌렀을 때 실행한다.
 * 각 사용자의 장바구니 페이지에 해당 상품을 추가한다.
 * 수량은 1, 사이즈는 M 사이즈 디폴트(상품코드로) 주소 등은 마이페이지에 저장된 주소로 저장한다.
 * status는 0. 아직 구매 버튼을 누르지 않았으므로.
 * pCode 가져옴. 나머지 정보는 DB에서 설정하거나 세션에 이미 저장됨. 
 * @author user
 *
 */
public class UserCartInsertAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		OrderDTO orderDTO = new OrderDTO();
		HttpSession session = request.getSession();
		
		//로그인하지 않은 사용자가 장바구니 버튼을 누를 경우
		String id = (String)session.getAttribute("memberID");
		if(id!=null) {
			//개인 정보 저장은 합의가 되어야 함
			orderDTO.setMemberID(id);
			orderDTO.setpCode(request.getParameter("pCode"));
			orderDTO.setoAddr((String)session.getAttribute("Addr"));
			orderDTO.setoEA(1);
			orderDTO.setoPhone((String)session.getAttribute("phone"));
			orderDTO.setoStatus(0);
			
			try {
				MumiService.insertCart(orderDTO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mv.setPath("/exampleCart.jsp");
		}
		else {
			//아무 처리도 하면 안 됨. 페이지 그대로 유지해야함.
			//mv.setPath("#");
		}
		return mv;
	}

}
