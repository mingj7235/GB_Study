package com.koreait.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//모든 컨트롤러에서 구현해야할 execute 메소드를 추상 메소드로 선언해 놓는다.
//재사용의 목적, 개발 속도 상승
public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
