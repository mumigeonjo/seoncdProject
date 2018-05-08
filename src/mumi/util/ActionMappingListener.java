package mumi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mumi.usercontroller.Action;

/**
 * Application Lifecycle Listener implementation class ActionMappingListener
 *
 */
@WebListener
public class ActionMappingListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent e) {
	}

	public void contextInitialized(ServletContextEvent e) {
		// ��ü���� ������ ~.properties���Ͽ� �ֱ� ������ properties ���� �о�´�.(ResourceBundle��ü �̿�)
		Map<String, Action> map = new HashMap<>();

		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");

		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		Iterator<String> it = rb.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			String className = rb.getString(key);
			try {
				Action action = (Action)Class.forName(className).newInstance();
				map.put(key, action);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// �̸� ��ü �����ؼ� map���� -> application���� (�����ʱ�ȭ�۾�)
		application.setAttribute("map", map);

	}

}
