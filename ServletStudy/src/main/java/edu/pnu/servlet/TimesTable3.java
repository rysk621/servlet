package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/timestable3")
public class TimesTable3 extends HttpServlet { // servlet class... 꼭 serial ID 넣어줘야 함
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("구구단을 외자");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		int dan = 3;
		String sDan = req.getParameter("dan");
		if (sDan != null) dan = Integer.parseInt(sDan);
		out.println("<h2>구구단 order by dan(dan = " + dan + ")</h2>");
		out.println("<table>");
		String str = "";
		String[] sList = new String[8];
		for (int i = 2; i  < 10; i++) {
			for (int j = 1; j < 10; j++) {
				str += i + " * " + j + " = " + i*j + "<br />";
			}
			sList[i-2] = "<td>"+ str + "</td>";
			str = "";
		}
		
		out.println("<tr>");
		for (int i = 0; i < sList.length; i++) {
			out.println(sList[i]);
			if ((i+1)% dan == 0) out.println("</tr><tr>");
		}
		
		out.println("</tr></table>");
		out.close();
	}
}
