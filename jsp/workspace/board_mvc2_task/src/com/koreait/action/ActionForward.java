package com.koreait.action;

//전송방식, 어디로 갈것인지 정해주는것임
public class ActionForward {
	private boolean isRedirect;
	private String path;
	
	public ActionForward() {;}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
