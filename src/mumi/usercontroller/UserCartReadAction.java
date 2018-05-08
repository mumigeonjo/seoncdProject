package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.service.MumiService;
import net.sf.json.JSONArray;

/**
 * 장바구니 목록 불러오기, 장바구니 버튼을 눌렀을 때 실행된다.
 * ====================================================
 * 이미 로그인을 한 상태에서만 실행 가능 - 세션에 저장된 아이디를 불러와 null 여부를 확인한다.
 * 세션에 아이디가 저장되지 않았다면 '로그인 후 이용 가능합니다' 알림을 띄워야 한다.
 * 세션에 아이디가 저장되어 있다면, DB order_detail 테이블에서 사용자의 장바구니를 가져온다.
 * =====================================================
 * 로그인 유효성 체크는 메인 페이지 등등 각 페이지에서 할 일이야.
 * 여기선 장바구니 페이지에 접속 성공했을 경우만 생각하자.
 * @author 김준영
 */
public class UserCartReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		//세션에 저장된 ID를 불러온다.
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		//세션으로부터 불러온 ID는 null이 아니다. null인 경우 장바구니 페이지 진입 자체가 안 됨
		try {
			JSONArray cartList = JSONArray.fromObject(MumiService.readCart(id));
			request.setAttribute("cartList", cartList);
			mv.setPath("/exampleCart.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

}
