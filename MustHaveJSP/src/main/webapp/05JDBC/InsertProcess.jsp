<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="common.JDBConnect" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String sId = request.getParameter("id");
String sPass = request.getParameter("pass");
String sName = request.getParameter("name");
try{
	JDBConnect jdbc = new JDBConnect();

	String sql = "insert into member (id, pass, name) values(?, ?, ?)";
	PreparedStatement ps = jdbc.getCon().prepareStatement(sql);
	ps.setString(1, sId);
	ps.setString(2, sPass);
	ps.setString(3, sName);
	ps.executeUpdate();
	ps.close();
	response.sendRedirect("InsertSuccess.jsp");
}catch(Exception e){
	request.setAttribute("sysmsg", e.getMessage());
	request.getRequestDispatcher("InsertFail.jsp").forward(request, response);
}
%>