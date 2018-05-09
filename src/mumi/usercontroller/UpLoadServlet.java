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

      // DefaultFileRenamePolicy ��ü�� ������ �����̸��� ���ε�Ǹ� ÷�ε� ���� �̸� ���� ���ڰ� �ٴ´�.
      MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
      
      String name = m.getParameter("name");
      String subject = m.getParameter("subject");
      
      String fileSystemName = m.getFilesystemName("file");     //���� ��å�� ���� ����� �̸�
      String originalName = m.getOriginalFileName("file"); //���� ��å�� ���� ����Ǳ� �� �̸�
      
      long fileSize = m.getFile("file").length();
      //�ٿ�ε带 �� �� �ֶǷ� save������ �ִ� ��� ����� �����Ѵ�.
      String [] fileNames =new File(saveDir).list();
      
      //�������� -> result.jsp �̵��ؼ� ${requestScope.name}
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
      
      request.setAttribute("map", map); //�信�� ${map} / ${map['key�̸�']}
      //��(result.jsp)������ �̵��ؼ� ������ ����Ѵ�.
      request.getRequestDispatcher("result.jsp").forward(request, response);
      
   }
}
// ����������� �ۼ�
// form�� �Ӽ����� enctype="multipart/form-data" �����Ǹ� request�� ���۵Ǵ� ���� ���� �� ����.

/*
 * String name = request.getParameter("name"); String subject =
 * request.getParameter("subject"); String file = request.getParameter("file");
 * 
 * System.out.println(name); System.out.println(subject);
 * System.out.println(file);
 */