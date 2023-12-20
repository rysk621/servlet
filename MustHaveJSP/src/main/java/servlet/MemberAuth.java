package servlet;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import membership.MemberDAO;
import membership.MemberDTO;

public class MemberAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao;
	
	@Override
	public void init() throws ServletException {
		//application 내장 객체 얻기
		ServletContext application = this.getServletContext();
		
		//web.xml에서 DB 연결 정보 얻기
		
		dao = new MemberDAO(application);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_id = this.getInitParameter("admin_id");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		MemberDTO memberDTO = dao.getMemberDTO(id, pass);
		
//		String memberName = memberDTO.getName();
//		String memberName = "";
//		String memberId = "";
//		if(memberDTO != null) {
//			memberName= memberDTO.getName();
//			memberId = memberDTO.getId();
//		}
		if(memberDTO != null) { // memberName != null 말고 memberDTO != null로 설정, memberDTO를 생성하지 않아도 됨
			req.setAttribute("authMessage", memberDTO.getName()+" : 인증 회원입니다.");
		}else {
			if(admin_id.equals(id)) req.setAttribute("authMessage", admin_id+" : 관리자입니다.");
			else req.setAttribute("authMessage", "비회원입니다.");
		}
//		if(memberId.equals(admin_id)) {
//			req.setAttribute("authMessage", admin_id + "는 관리자입니다.");
//		}else {
//			if(memberDTO == null) req.setAttribute("authMessage", "비회원입니다.");
//			else req.setAttribute("authMessage", memberName + " 회원 인증");
//		}
		req.getRequestDispatcher("/12Servlet/MemberAuth.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		dao.close();
	}
}
