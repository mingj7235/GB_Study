package com.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet(name = "Result_teacher", urlPatterns = { "/Result_teacher" })
public class Result_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result_teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); //인코딩 설정 하는게 중요
		
		response.setContentType("text/html; charset=UTF-8");
		
		
		String input = request.getParameter("input").replace(" ", "");
		PrintWriter out = response.getWriter();
		Calc_teacher calc = new Calc_teacher();
		String opers = "+-*/"; //4칸짜리 문자배열로 볼수있음
		char oper = ' ';
		int check = 0;
		String [] arTemp = null;
		int num1 = 0, num2 = 0;
		String resultMsg = null;
		
		out.println("<html><body><h1>서블릿으로 만든페이지</h1>");
		
		for (int i = 0; i<opers.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == opers.charAt(i)) {
					oper = input.charAt(j);
					check++;
					
				}
			}
		}
		
		out.println("<p>결과: ");
		if(check==1) {
			try {
				arTemp = input.split("\\" + oper);
				num1 = Integer.parseInt(arTemp[0]) ;
				num2 = Integer.parseInt(arTemp[1]) ;
				
				switch (oper) {
				case '+':
					resultMsg = calc.add(num1, num2) +"";
					break;
				case '-':
					resultMsg = calc.sub(num1, num2) +"";
					break;
				case '*':
					resultMsg = calc.mul(num1, num2) +"";
					break;
				case '/':
					try {
						resultMsg = calc.div(num1, num2) +"";
					} catch (ArithmeticException e) {
						resultMsg ="0으로 나눌 수 없습니다.";
					}
					break;
				}
			} catch (NumberFormatException e) {
				resultMsg ="정수의 연산만 가능합니다.";
			} catch (ArrayIndexOutOfBoundsException e) {
				resultMsg = "양식에 맞게 작성해 주세요.";
			}
		} else if (check > 1) {
			resultMsg = "두 정수의 연산만 가능합니다";
		} else {
			resultMsg = "연산자를 찾지 못했습니다.";
		}
		out.println(resultMsg + "</p>");
		out.print("<a href='calc_teacher'>JSP페이지로 이동</a></body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
