package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/timestable")
public class TimesTable extends HttpServlet { // servlet class... 꼭 serial ID 넣어줘야 함
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("구구단을 외자");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String snum = req.getParameter("num");
		int num = 2; // declare int variable, initialize default value
		if (snum != null) {
			num = Integer.parseInt(snum);
		}
		out.println("<h2>구구단을 "+num+"단만 외자</h2>");
		out.println("<div style=\"border:solid 1px gray\">");
		for (int i = 1; i < 10; i++) {
			out.println("<ul>"+num+" * "+i+" = "+num*i+"</ul>");
		}
		out.println("</div>");
		out.close();
	}
}
