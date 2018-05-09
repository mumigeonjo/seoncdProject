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

		int result =0;
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		
		String memberId = (String)session.getAttribute("id");
		int categoryNo=Integer.parseInt(request.getParameter("bCategory"));
		String content=request.getParameter("bContent");
		String title=request.getParameter("bTitle");
		
		
		try{
			
			result = MumiService.insertQA(new QADTO(memberId,categoryNo,content,title));
			request.setAttribute("result", result);
			
//			for(QADTO qaDTO:list) {
//				System.out.println(qaDTO);
//			}
			
			mv.setPath("view/QA.jsp");
			//mv.setRedirect(false);
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return mv;
	}

}