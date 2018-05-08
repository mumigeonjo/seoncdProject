package mumi.usercontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.CartDTO;
import mumi.model.service.MumiService;
import net.sf.json.JSONArray;

/**
 * ���� ���������� �̸� �� �ѷ���
 * ���� ��ư Ŭ���ؼ� ����. ��ٱ��Ͽ� �ִ� orderIndex�� �Ѿ��
 * �ش� orderIndex�� ��Ű�� �����ص�. ���߿� ���� �޼ҵ忡�� �ʿ��ϱ� �����̴�.
 */
public class UserOrderReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		Cookie oIndexNoCookie;
		ServletContext application = request.getServletContext();
		//request�� �Ѿ����?
		try {
			int oIndexNo = (int)request.getAttribute("oIndexNo");
			JSONArray cartDTO = 
					JSONArray.fromObject(MumiService.selectOrderByProductNum(oIndexNo));
			request.setAttribute("order", cartDTO);
			oIndexNoCookie = new Cookie("oIndexNo", oIndexNo+"");
			oIndexNoCookie.setMaxAge(60*60);	//1�ð�
			oIndexNoCookie.setPath(application.getContextPath());
			
			response.addCookie(oIndexNoCookie);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setPath("");
		return mv;
	}

}
