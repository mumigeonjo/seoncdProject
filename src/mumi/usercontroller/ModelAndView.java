package mumi.usercontroller;

public class ModelAndView {

	private String path;
	private boolean isRedirect; //true�� redirect, false�̸� forward���(default)

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
