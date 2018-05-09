package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mumi.model.dto.ProductDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;
public class AdminProductInsertAction implements Action{

	@Override  //다영
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//파일첨부때문에 multipartRequst필요.
		String saveDir = request.getSession().getServletContext().getRealPath("/saveImg/");
		int maxSize=1024*1024*100;//100m
	    String encoding="UTF-8";
	     
		ModelAndView mv = new ModelAndView();
		
		try {
			MultipartRequest m =
					  new MultipartRequest(request, saveDir, 
						  maxSize, encoding, new DefaultFileRenamePolicy());
			
			String pCode = m.getParameter("pCode");
			String pName = m.getParameter("pName");
			String pPrice = m.getParameter("pPrice");
			String pSize = m.getParameter("pSize");
			String pDate = m.getParameter("pDate");
			String pEA = m.getParameter("pEA");
			String pImage = m.getFilesystemName("pImage");
			String pDetailImage = m.getFilesystemName("pDetailImage");
			
			
			//입력유뮤 유효성 체크
			  if(pCode==null || pName==null || pPrice==null || pSize==null
					   ||pDate==null ||pEA==null){
				
				  throw new SQLException("입력값이 충분하지 않습니다.");
			  }
			
			ProductDTO productDTO = new ProductDTO(pCode, pName, Integer.parseInt(pPrice), pSize, pDate, Integer.parseInt(pEA), pImage, pDetailImage);

			int result = MumiService.adminProductInsert(productDTO);
			if(result>0) {
				mv.setPath("mumi?command=userProductAllRead");
				mv.setRedirect(true);//redirect방식으로 이동
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("errorView/error.jsp");
		}
		
		return mv;
	}

}
