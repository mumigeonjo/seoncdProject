package mumi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QAReplyDTO;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminQAReplyFormAction implements Action {


	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
			HttpSession session = request.getSession();
			ModelAndView mv=new ModelAndView();
			
			int bIndexNo =Integer.parseInt(request.getParameter("bIndexNo"));
			

			
			try{
				
				
				request.setAttribute("bIndexNo", bIndexNo); //forward방식 이동
				mv.setPath("view/userQAReplyForm.jsp");
				
				
				
				
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return mv;
		}

	}

