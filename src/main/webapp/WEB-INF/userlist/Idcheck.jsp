<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ page import="userlist.model.userlistDao" %>
    <%@ page import="userlist.model.userlistBean" %>
    <%@ page import="java.io.PrintWriter" %>
<%
String id = request.getParameter("id");
userlistDao uDao = new userlistDao();
userlistBean user = uDao.searchId(id);
PrintWriter pw=null;
if(user==null){
response.sendRedirect("InsertUserForm.jsp?flag='o'");
	/* pw = response.getWriter();
	pw.print("<script>'사용가능한 아이디입니다.'");
	pw.flush(); */
}
else{
response.sendRedirect("InsertUserForm.jsp?flag='x'");
	/* pw = response.getWriter();
	pw.print("<script>'사용중인 아이디입니다.'");
	pw.flush(); */
}
%>