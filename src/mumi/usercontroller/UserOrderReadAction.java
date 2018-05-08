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
 * 결제 페이지에서 미리 값 뿌려줌
 * 결제 버튼 클릭해서 들어옴. 장바구니에 있는 orderIndex가 넘어옴
 * 해당 orderIndex는 쿠키에 저장해둠. 나중에 결제 메소드에서 필요하기 때문이다.
 */
public class UserOrderReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		Cookie oIndexNoCookie;
		ServletContext application = request.getServletContext();
		//request로 넘어오나?
		try {
			int oIndexNo = (int)request.getAttribute("oIndexNo");
			JSONArray cartDTO = 
					JSONArray.fromObject(MumiService.selectOrderByProductNum(oIndexNo));
			request.setAttribute("order", cartDTO);
			oIndexNoCookie = new Cookie("oIndexNo", oIndexNo+"");
			oIndexNoCookie.setMaxAge(60*60);	//1시간
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
