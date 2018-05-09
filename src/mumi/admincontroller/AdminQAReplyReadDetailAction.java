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

public class AdminQAReplyReadDetailAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		int bIndexNo =Integer.parseInt(request.getParameter("bIndexNo"));
		String memberId =(String)session.getAttribute("id");
		int categoryNo=Integer.parseInt(request.getParameter("bCategory"));
		String content=request.getParameter("bContent");
		String title=request.getParameter("bTitle");
		
		try{
			
			QADTO qDTO = new QADTO(bIndexNo,memberId,categoryNo,content,title);
			QAReplyDTO qaReplyDTO = MumiService.readAnswer(bIndexNo);
			
			request.setAttribute("userQAread", qDTO); //forward방식 이동
			request.setAttribute("readAnswer", qaReplyDTO);
			/*
			for(QADTO qaDTO:list) {
				System.out.println(qaDTO);
			}*/
			
			mv.setPath("view/UserQAReplyReadForm.jsp");
			//mv.setRedirect(false);
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return mv;
	}

}

