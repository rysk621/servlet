<%
request.setAttribute("InsertErrMsg", "Try another id.");
request.getRequestDispatcher("InsertForm.jsp").forward(request,response);
//response.sendRedirect("InsertForm.jsp");
%>
