<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="common.JDBConnect" %>
<%@ page import="java.sql.PreparedStatement" %>
<%
String sId = request.getParameter("id");
String sPass = request.getParameter("pass");
String sName = request.getParameter("name");

try {
	JDBConnect jdbc = new JDBConnect(application);
	
	String sql = "insert into member (id, pass, name) values(?, ?, ?)";
	PreparedStatement ps = jdbc.getCon().prepareStatement(sql);
	ps.setString(1, sId);
	ps.setString(2, sPass);
	ps.setString(3, sName);
	ps.executeUpdate();
	ps.close();
	
	response.sendRedirect("InsertBoardSuccess.jsp");
} catch(Exception e) {
	response.sendRedirect("InsertBoardFail.jsp");
}
%>
