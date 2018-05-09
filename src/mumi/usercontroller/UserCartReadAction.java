package mumi.usercontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.CartDTO;
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
		//String id = (String)session.getAttribute("id");
		List<CartDTO> list=new ArrayList<>();		
		//�������κ��� �ҷ��� ID�� null�� �ƴϴ�. null�� ��� ��ٱ��� ������ ���� ��ü�� �� ��
		try {
			list = MumiService.readCart("aaa");
			//list.add(new CartDTO(1, "aa", 3));
			//JSONArray cart = JSONArray.fromObject(list);
			//��, �׷��ϱ� Ŭ���̾�Ʈ���� ��� ���� ������. �̰� �³�? �ƴϸ� out.println?
			//PrintWriter out = response.getWriter();
			//out.println(cart);
			mv.setPath("/view/cart.jsp");
			request.setAttribute("list", list);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

}
