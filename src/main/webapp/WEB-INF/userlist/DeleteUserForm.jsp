<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../common/common.jsp" %>
 <%@ include file="../common/loginbar.jsp" %>
<style type="text/css">
.err {
	color: red;
	font-weight: bold;
}
</style>
 <form:form commandName="deleteuserBean" action="DeleteUser.ulist" method="post">
<h3>회원탈퇴</h3><br><br>
비밀번호 <input type="password" name="pass">
<form:errors cssClass="err" path="pass" /><br><br>
<input type="submit" value="탈퇴하기">
</form:form>