<%@ page import="model1.board.BoardDAO" %>
<%@ page import="model1.board.BoardDTO" %>
<%@ include file="./IsLoggedIn.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 수정 내용 request 받음
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");

// DTO에 수정 내용 저장
BoardDTO dto = new BoardDTO();
dto.setNum(num);
dto.setTitle(title);
dto.setContent(content);

// DB에 반영
BoardDAO dao = new BoardDAO(application);
int affected = dao.updateEdit(dto); //return int result (BoardDAO의 method updateEdit()의 return 결과)
dao.close();

// 성공/실패 처리
if (affected == 1){
	// 성공시 상세 보기 페이지로 이동(View.jsp)
	response.sendRedirect("View.jsp?num=" + dto.getNum());
}else{
	// 실패 시 이전 페이지로 이동
	JSFunction.alertBack("수정하기에 실패하였습니다", out);
}
%>