<%@ page import="model1.board.BoardDAO" %>
<%@ page import="model1.board.BoardDTO" %>
<%@ page import="membership.MemberDTO" %>
<%@ include file="./IsLoggedIn.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String title = request.getParameter("title");
String content = request.getParameter("content");

BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setContent(content);
// dto.setId(session.getAttribute("UserId").toString());
MemberDTO m = (MemberDTO)session.getAttribute("member");
dto.setId(m.getId());

BoardDAO dao = new BoardDAO(application);
int iResult = dao.insertWrite(dto); //원래 코드
/* int iResult = 0;
for (int i = 1; i <= 100; i++){
	dto.setTitle(title + "-" + i);
	iResult = dao.insertWrite(dto);
} */
dao.close();

if (iResult == 1){
	response.sendRedirect("List.jsp");
} else {
	JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
}
%>