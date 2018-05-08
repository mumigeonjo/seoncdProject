package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.OrderDTO;
import mumi.model.service.MumiService;

/**
 * 구매 버튼 클릭 + 구매 페이지에서 수정된 값이 들어감
 * @author user
 *
 */
public class UserOrderInsertAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//나중에 수정할 필요 있을듯
		ModelAndView mv = new ModelAndView();
		Cookie [] cookies = request.getCookies();
		HttpSession session = request.getSession();
		int oIndexNo=0;
		OrderDTO orderDTO;
		
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("oIndexNo")) {
				oIndexNo=Integer.parseInt(cookie.getValue());
				break;
			}
		}
		String pCode = (String)request.getAttribute("pCode");
		
		switch((char)request.getAttribute("size")) {
		case 'S':
			pCode.replace(pCode.charAt(pCode.length()-1), 'S');
			break;
		case 'L':
			pCode.replace(pCode.charAt(pCode.length()-1), 'L');
			break;
		default:
		}
		
		orderDTO = new OrderDTO(oIndexNo, pCode,
				null, (int)request.getAttribute("oEA"),
				null, 1, (String)request.getAttribute("oAddr"), (String)request.getAttribute("oPhone"));
		
		try {
			MumiService.insertOrder(orderDTO);
			mv.setPath("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}

}
