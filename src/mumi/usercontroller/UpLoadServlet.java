package mumi.usercontroller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UpLoadServlet
 */
@WebServlet("/UpLoad")
public class UpLoadServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      String saveDir = request.getServletContext().getRealPath("/save");
      System.out.println(saveDir);
      int maxSize = 1024 * 1024 * 100;// 100Mb
      String encoding = "UTF-8";

      // DefaultFileRenamePolicy 객체는 동일한 파일이름이 업로드되면 첨부된 파일 이름 옆에 숫자가 붙는다.
      MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
      
      String name = m.getParameter("name");
      String subject = m.getParameter("subject");
      
      String fileSystemName = m.getFilesystemName("file");     //파일 정책에 의해 변경된 이름
      String originalName = m.getOriginalFileName("file"); //파일 정책에 의해 변경되기 전 이름
      
      long fileSize = m.getFile("file").length();
      //다운로드를 할 수 있또록 save폴더에 있는 모든 목록을 저장한다.
      String [] fileNames =new File(saveDir).list();
      
      //정보저장 -> result.jsp 이동해서 ${requestScope.name}
      /*request.setAttribute("name", name);
      request.setAttribute("subject", subject);
      request.setAttribute("fileSystemName", fileSystemName);
      request.setAttribute("originalName", originalName);
      request.setAttribute("fileSize", fileSize);
      request.setAttribute("fileNames", fileNames);*/
      
      Map<String, Object> map = new HashMap<>();
      map.put("name", name);
      map.put("subject", subject);
      map.put("fileSystemName", fileSystemName);
      map.put("originalName", originalName);
      map.put("fileSize", fileSize);
      map.put("fileNames", fileNames);
      
      request.setAttribute("map", map); //뷰에서 ${map} / ${map['key이름']}
      //뷰(result.jsp)쪽으로 이동해서 정보를 출력한다.
      request.getRequestDispatcher("result.jsp").forward(request, response);
      
   }
}
// 기존방법으로 작성
// form에 속성으로 enctype="multipart/form-data" 설정되면 request로 전송되는 값을 받을 수 없다.

/*
 * String name = request.getParameter("name"); String subject =
 * request.getParameter("subject"); String file = request.getParameter("file");
 * 
 * System.out.println(name); System.out.println(subject);
 * System.out.println(file);
 */