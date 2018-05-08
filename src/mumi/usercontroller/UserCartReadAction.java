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
 * ��ٱ��� ��� �ҷ�����, ��ٱ��� ��ư�� ������ �� ����ȴ�.
 * ====================================================
 * �̹� �α����� �� ���¿����� ���� ���� - ���ǿ� ����� ���̵� �ҷ��� null ���θ� Ȯ���Ѵ�.
 * ���ǿ� ���̵� ������� �ʾҴٸ� '�α��� �� �̿� �����մϴ�' �˸��� ����� �Ѵ�.
 * ���ǿ� ���̵� ����Ǿ� �ִٸ�, DB order_detail ���̺��� ������� ��ٱ��ϸ� �����´�.
 * =====================================================
 * �α��� ��ȿ�� üũ�� ���� ������ ��� �� ���������� �� ���̾�.
 * ���⼱ ��ٱ��� �������� ���� �������� ��츸 ��������.
 * @author ���ؿ�
 */
public class UserCartReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		//���ǿ� ����� ID�� �ҷ��´�.
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		//�������κ��� �ҷ��� ID�� null�� �ƴϴ�. null�� ��� ��ٱ��� ������ ���� ��ü�� �� ��
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
