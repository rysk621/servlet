<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="common.JDBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String sId = request.getParameter("id");
String sPass = request.getParameter("pass");
String sName = request.getParameter("name");

if (sId == null || sPass == null || sName == null){
	// no input
	response.sendRedirect("InsertForm.jsp");
	//request.getRequestDispatcher("InsertFail.jsp").forward(request, response);
	return;
}

//insert success


// insert fail

%>