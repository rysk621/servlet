package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/timestable2")
public class TimesTable2 extends HttpServlet { // servlet class... 꼭 serial ID 넣어줘야 함
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("구구단을 외자");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String dir = req.getParameter("dir");
		if (dir == null) {
			dir = "ver";
		}
		out.println("<h2>구구단 direction (dir=ver, hor)</h2>");
		if (dir.equals("ver")) {
			for (int i = 2; i < 10; i++) {
				out.println("<table><th>" + i + "단</th>");
				for (int j = 1; j < 10; j++) {
					out.println("<tr><td>" + i + " * " + j + " = " + i * j + "</td></tr>");
				}
				out.println("</table>");
			}
		} else {
			out.println("<table>");
			out.println("<tr>");
			for (int i = 2; i < 10; i++) {
				out.println("<td>" + i + "단</td>");
			}
			out.println("</tr>");
			for (int j = 1; j < 10; j++) {
				out.println("<tr>");
				for (int i = 2; i < 10; i++) {
					out.println("<td>" + i + " * " + j + " = " + i * j + "</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
		}
		out.close();
	}
}
