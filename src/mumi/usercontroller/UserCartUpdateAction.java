package mumi.usercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 이거 필요 없을듯..? 장바구니 추가는 insert와 겹치고 status 변경은 구매 기능과 겹침
 * @author user
 *
 */
public class UserCartUpdateAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
