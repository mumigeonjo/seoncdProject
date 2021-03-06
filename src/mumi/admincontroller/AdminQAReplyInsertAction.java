package mumi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QADTO;
import mumi.model.dto.QAReplyDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;
public class AdminQAReplyInsertAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result =0;
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		
		int bIndexNo=Integer.parseInt(request.getParameter("bIndexNo"));
		String content=request.getParameter("qContent");
		System.out.println(bIndexNo);


		
		try{
			
			result = MumiService.insertAnswer(new QAReplyDTO(bIndexNo, content));
			int i =MumiService.updateHasAnswer(bIndexNo);
			System.out.println(i);
			request.setAttribute("result", result);
			/*
			for(QADTO qaDTO:list) {
				System.out.println(qaDTO);
			}*/
			
			mv.setPath("view/QA.jsp");
			//mv.setRedirect(false);
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return mv;
	}

}