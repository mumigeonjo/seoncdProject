package mumi.usercontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.ProductDTO;
import mumi.model.service.MumiService;
import net.sf.json.JSONArray;

public class UserProductAllReadAction implements Action{

	// http://localhost:8000/second_PJ/mumi?command=userProductAllRead
	
	@Override //다영
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> list = MumiService.userProductAllRead();
		request.setAttribute("list", list);//viewpage에서 ${list}
		mv.setPath("view/userProducList.jsp");
		
		return mv;
	}

}
