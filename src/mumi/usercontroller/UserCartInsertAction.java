package mumi.usercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 장바구니 추가 버튼을 눌렀을 때 실행한다.
 * 각 사용자의 장바구니 페이지에 해당 상품을 추가한다.
 * 수량은 1, 사이즈는 M 사이즈 디폴트(상품코드로) 주소 등은 마이페이지에 저장된 주소로 저장한다.
 * status는 0. 아직 구매 버튼을 누르지 않았으므로.
 * @author user
 *
 */
public class UserCartInsertAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
