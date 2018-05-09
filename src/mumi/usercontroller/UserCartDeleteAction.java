package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.service.MumiService;

/**
 * ��ٱ��� ���� ��ư�� ������ �� ����ȴ�.
 * �� ������� ��ٱ��� ��Ͽ��� üũ�� ��ǰ�� �����..?
 * �信�� ������ ��ǰ�� �ε����� �����ش�. -> �信�� �̸� ������ ���߰ڳ�..? JSON����?
 * �䰡 ��� ����Ŀ� ���� ���ڰ� �޶���.
 * @author user
 *
 */
public class UserCartDeleteAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		ServletContext application = request.getServletContext();
		
		//�信�� ������ ��ǰ�� �ε����� �����ش�.
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
