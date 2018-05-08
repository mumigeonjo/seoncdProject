package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.CartDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.service.MumiService;

/**
 * ������������ ���� �� �� �ִ� ��.
 * @author user
 *
 */
public class UserOrderlistReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		List<CartDTO> list = new ArrayList<>();
		HttpSession session = request.getSession();
		//���ǿ� ����� ���̵� �о��
		try {
			list=MumiService.selectOrderAllById((String)session.getAttribute("id"));
			session.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setPath("");
		
		return mv;
	}
}