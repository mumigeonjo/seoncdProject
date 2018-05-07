package mumi.usercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QADTO;
import mumi.model.service.MumiService;

public class UserQAInsertAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

/*		int result =0;
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		
		String memberId =(String)session.getAttribute("memberid");
		int categoryNo=(int)session.getAttribute("categoryNo");
		String content=(String)session.getAttribute("content");
		String title=(String)session.getAttribute("title");

		
		try{
			
			result = MumiService.(new QADTO(memberId,categoryNo,content,title));
			request.setAttribute("result", result);
			
//			for(QADTO qaDTO:list) {
//				System.out.println(qaDTO);
//			}
			
			mv.setPath("???");
			mv.setRedirect(false);
			return mv;
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}*/
		
		return null;
	}

}