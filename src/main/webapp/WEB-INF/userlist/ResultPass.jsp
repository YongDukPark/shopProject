<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/loginbar.jsp" %>
<%  String userpass=(String)request.getAttribute("userpass"); %>
    
<h3>
회원님의 비밀번호는 '${userpass}' 입니다.
</h3>