package com.koreait.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//모든 컨트롤러에서 구현해야 할 execute메소드를 추상메소드로 선언해 놓는다.
//재사용의 목적, 개발 속도 상승
public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
