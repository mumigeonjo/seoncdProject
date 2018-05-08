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
 * ��ٱ��� �߰� ��ư�� ������ �� �����Ѵ�.
 * �� ������� ��ٱ��� �������� �ش� ��ǰ�� �߰��Ѵ�.
 * ������ 1, ������� M ������ ����Ʈ(��ǰ�ڵ��) �ּ� ���� ������������ ����� �ּҷ� �����Ѵ�.
 * status�� 0. ���� ���� ��ư�� ������ �ʾ����Ƿ�.
 * pCode ������. ������ ������ DB���� �����ϰų� ���ǿ� �̹� �����. 
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
		
		//�α������� ���� ����ڰ� ��ٱ��� ��ư�� ���� ���
		String id = (String)session.getAttribute("memberID");
		if(id!=null) {
			//���� ���� ������ ���ǰ� �Ǿ�� ��
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
			//�ƹ� ó���� �ϸ� �� ��. ������ �״�� �����ؾ���.
			//mv.setPath("#");
		}
		return mv;
	}

}
