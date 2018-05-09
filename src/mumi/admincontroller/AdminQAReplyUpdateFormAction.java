package mumi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mumi.model.dto.QADTO;
import mumi.model.dto.QAReplyDTO;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;

public class AdminQAReplyUpdateFormAction implements Action {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				HttpSession session = request.getSession();
				ModelAndView mv=new ModelAndView();
				
				int qIndexNo =Integer.parseInt(request.getParameter("qIndexNo"));
				String content=request.getParameter("qContent");
				String qDate = request.getParameter("qDate");

				System.out.println(content+"|"+qIndexNo);
				
				try{
					
					QAReplyDTO qDTO = new QAReplyDTO(qIndexNo,qDate,content);
					
					request.setAttribute("userQAReplyUpdate", qDTO); //forward방식 이동
					mv.setPath("view/userQAReplyUpdateForm.jsp");
					
					
					
					
				}catch(Exception e) {
					
					e.printStackTrace();
					
				}
				
				return mv;
			}

		}


