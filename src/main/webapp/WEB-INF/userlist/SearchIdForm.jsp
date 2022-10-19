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
<form:form commandName="searchidBean" action="SearchId.ulist" method="post">

<h1>아이디 찾기</h1>


이름 <input type="text" name="name" value="${name}">	<form:errors cssClass="err" path="name" /><br><br>
생년월일 <input type="text" name="birth" placeholder="ex)19930405" value="${birth}"><form:errors cssClass="err" path="birth" /><br><br>

<input type="submit" value="아이디 찾기">
</form:form>