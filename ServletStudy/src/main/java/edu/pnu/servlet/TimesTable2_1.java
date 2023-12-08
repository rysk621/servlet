package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/timestable2_1")
public class TimesTable2_1 extends HttpServlet { // servlet class... 꼭 serial ID 넣어줘야 함
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("구구단을 외자");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		int dan = 3;
		out.println("<h2>구구단 order by dan(dan = " + dan + ")</h2><div style=\"inline-table\">");
		for (int i = 2; i < 10; i++) {
			out.println("<table>");
			for (int j = 1; j < 10; j++) {
				out.println("<tr><td>"+i + " * " + j + " = " + j * i + "</td></tr>");
			}
			out.println("</table>");
			if((i-1)%3 == 0) 			out.println("<br>");
		}
		out.println("</div>");
		out.close();
	}
}
