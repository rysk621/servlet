package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12Servlet/Testpass")
public class Testpass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sKor = req.getParameter("kor");
		int kor = Integer.parseInt(sKor);
		req.setAttribute("kor", kor);
		String sEng = req.getParameter("eng");
		int eng = Integer.parseInt(sEng);
		req.setAttribute("eng", eng);
		String sMath = req.getParameter("math");
		int math = Integer.parseInt(sMath);
		req.setAttribute("math", math);
		if (kor<60 || eng<60|| math<60) {
			req.setAttribute("result", "결과 : 과락");
			req.setAttribute("sum", "-, 과락");
			req.setAttribute("avg", "-, 과락");

			req.getRequestDispatcher("/12Servlet/Testpass.jsp").forward(req, resp);
			return;
		}
		int sum = kor + eng + math;
		double avg = sum / 3;
		req.setAttribute("sum", sum);
		req.setAttribute("avg", avg);
		
		if(avg < 70.0) req.setAttribute("result", "결과 : 불합격");
		else req.setAttribute("result", "결과 : 합격");

		req.getRequestDispatcher("/12Servlet/Testpass.jsp").forward(req, resp);
	}
}
