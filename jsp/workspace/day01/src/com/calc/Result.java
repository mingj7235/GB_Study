package com.calc;

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
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Calc cal = new Calc();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*int num1, num2;
		String result ;
		String oper;
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		oper = request.getParameter("oper");
		
		try {
			result = cal.calc(num1, num2, oper) + "";
			out.write("<html><body>계산기 <br> <h3> 계산 결과 </h3> <hr>" + num1 + "  " +oper + "  " + num2 + "  " + " = " + result + "</body></html>");
			out.write("<a href='calc'>뒤로이동!</a></body></html>");
			out.close();
		} catch (ArithmeticException e) {
			out.write("<html><body>계산기 <br> <h3> 0으로 나눌수없습니다.  </h3> <hr> </body></html>");
			out.write("<br><a href='calc'>뒤로이동!</a></body></html>");
			out.close();
			
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1, num2;
		int result =0  ;
		String oper;
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			/*if (request.getParameter("input").contains("+")) {
				String nums[] = request.getParameter("input").split("\\+");
				num1 = Integer.parseInt(nums[0]);
				num2 = Integer.parseInt(nums[1]);
				oper = "+";
				result = cal.calc(num1, num2, oper);
			} else if (request.getParameter("input").contains("-")) {
				String nums[] = request.getParameter("input").split("\\-");
				num1 = Integer.parseInt(nums[0]);
				num2 = Integer.parseInt(nums[1]);
				oper = "-";
				result = cal.calc(num1, num2, oper);
			} else if (request.getParameter("input").contains("*")) {
				String nums[] = request.getParameter("input").split("\\*");
				num1 = Integer.parseInt(nums[0]);
				num2 = Integer.parseInt(nums[1]);
				oper = "*";
				result = cal.calc(num1, num2, oper);
			} else if (request.getParameter("input").contains("/")) {
				String nums[] = request.getParameter("input").split("\\/");
				num1 = Integer.parseInt(nums[0]);
				num2 = Integer.parseInt(nums[1]);
				oper = "/";
				result = cal.calc(num1, num2, oper);
			}*/
			
			
			
			
			out.write("<html><body>계산기 <br> <h3> 계산 결과 </h3> <hr>" + result + "</body></html>");
			out.write("<a href='calc'>뒤로이동!</a></body></html>");
			out.close();
		} catch (NumberFormatException e1) {
			out.write("<html><body>계산기 <br> <h3> 0으로 나눌수없습니다.  </h3> <hr> </body></html>");
			out.write("<br><a href='calc'>뒤로이동!</a></body></html>");
			out.close();
			
		}
			
		
		
	}

}
