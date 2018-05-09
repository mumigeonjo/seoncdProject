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
		
		HttpSession session = request.getSession();
		int oIndexNo=0;
		OrderDTO orderDTO;
		
		oIndexNo = Integer.parseInt(request.getParameter("oIndexNo"));
		String pCode = request.getParameter("pCode");
		String size = request.getParameter("size");
		if(size.equals("S"))
			pCode.replace(pCode.charAt(pCode.length()-1), 'S');
		else if(size.equals("L"))
			pCode.replace(pCode.charAt(pCode.length()-1), 'L');
		System.out.println("pCode : "+pCode);
		/*
		switch(request.getParameter("size")) {
		case 'S':
			pCode.replace(pCode.charAt(pCode.length()-1), 'S');
			break;
		case 'L':
			pCode.replace(pCode.charAt(pCode.length()-1), 'L');
			break;
		default:
		}
		*/
		
		orderDTO = new OrderDTO(oIndexNo, pCode,
				null, Integer.parseInt(request.getParameter("oEA")),
				null, 1, request.getParameter("oAddr"), request.getParameter("oPhone"));
		System.out.println(orderDTO.getoEA()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		try {
			MumiService.insertOrder(orderDTO);
			mv.setPath("view/cart.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}

}
