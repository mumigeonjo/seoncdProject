package mumi.usercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 장바구니 목록 불러오기
 * 이미 로그인을 한 상태에서만 실행 가능 - 세션에 저장된 아이디를 불러와 null 여부를 확인한다.
 * 세션에 아이디가 저장되지 않았다면 '로그인 후 이용 가능합니다' 알림을 띄워야 한다.
 * 세션에 아이디가 저장되어 있다면, DB order_detail 테이블에서 사용자의 장바구니를 가져온다.
 * @author 김준영
 */
public class UserCartReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
