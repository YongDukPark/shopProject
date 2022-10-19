<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/loginbar.jsp" %>
    <%  
    String userid=(String)request.getAttribute("userid"); %>
    
<h3>
회원님의 아이디는 '${userid}' 입니다.
</h3>