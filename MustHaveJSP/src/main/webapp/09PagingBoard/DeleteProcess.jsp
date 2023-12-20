<%@ page import="model1.board.BoardDAO" %>
<%@ page import="model1.board.BoardDTO" %>

<%@ include file="./IsLoggedIn.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String num = request.getParameter("num");
BoardDTO dto = new BoardDTO();
BoardDAO dao = new BoardDAO(application);
dto = dao.selectView(num);

// 로그인된 사용자의 id 얻어오기
String sessionId = session.getAttribute("UserId").toString();

int delResult = 0;

if(sessionId.equals(dto.getId())){
	// 작성자가 본인임
	dto.setNum(num);
	delResult = dao.deletePost(dto); // 삭제 처리, delResult는 1이 됨.
	dao.close();
	
	//삭제 성공/실패 처리
	if (delResult == 1){
		JSFunction.alertLocation("삭제되었습니다.", "List.jsp", out);
	}else{
		JSFunction.alertBack("삭제에 실패하였습니다.", out);
	}
}else{
	JSFunction.alertBack("본인만 삭제할 수 있습니다.", out);
	return;
}
%>