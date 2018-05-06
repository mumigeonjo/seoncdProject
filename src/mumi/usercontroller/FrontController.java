package mumi.usercontroller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mumi")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Action> map;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// aplication������ �����Map�� ������ ���������� �����Ѵ�.
		map = (Map<String, Action>) config.getServletContext().getAttribute("map");

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// parameter �Ѿ���� command �ޱ� = key
		String key = request.getParameter("command");
		if (key == null) {
			key = "main";
		} 

		// map���� key�� �ش��ϴ� Ŭ������ ������ �޼ҵ带 ȣ���ϰ� ���ϰ��� �޴´�.
		ModelAndView mv = map.get(key).execute(request, response);
		// ���ϰ�(ModelAndView)�� ���� �̵���İ� �̵���θ� ���Ѵ�.
		if (mv.isRedirect()) {
			response.sendRedirect(mv.getPath());
		} else {
			request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
	}

}
