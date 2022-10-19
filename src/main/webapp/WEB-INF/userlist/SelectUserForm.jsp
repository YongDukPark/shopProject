<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--  <%@page import="java.io.PrintWriter" %> --%>
     <%@ include file="../common/common.jsp" %>
     <%@ include file="../common/loginbar.jsp" %>
     <%@ include file="../common/userinfo.jsp" %>
     <script type="text/javascript" src="resources/js/jquery.js"></script>
<%-- <% 
/* PrintWriter pw=null;
if(gender=="남자"){
	pw =response.getWriter();
	pw.print("<script>document.getElementById('gender')[1].checked</script>");
	pw.flush();
}
	else if(gender=="여자"){
		pw =response.getWriter();
		pw.print("<script>document.gender[2].checked='checked'</script>");
		pw.flush();
	} */
	
 %> --%>

<style type="text/css">
.err {
	color: red;
	font-weight: bold;
}
</style>

<form:form commandName="selectuserBean" action="UpdateUser.ulist" method="post">

<h1>내 정보</h1>
아이디 <input type="text" name="id" disabled="disabled" value="${loginInfo.id}"><br><br>

이름 <input type="text" name="name" value="${loginInfo.name}"><form:errors cssClass="err" path="name" /><br><br>
성별 <select name="gender" id="gender">
<option value="남자" >남자</option>
<option value="여자">여자</option>
</select><br><br>
생년월일 <input type="text" name="birth" value="${loginInfo.birth}"><%-- <form:errors cssClass="err" path="birth" /> --%><br><br>
주소 <input type="text" name="address1" value="${loginInfo.address1}"><form:errors cssClass="err" path="address1" /><br><br>
상세주소 <input type="text" name="address2"  value="${loginInfo.address2}"><form:errors cssClass="err" path="address2" /><br><br>
<input type="submit" value="수정하기">
</form:form>
     <script type="text/javascript">
     
var gender ='${loginInfo.gender}';
if(gender=="남자"){
	$("#gender").val('남자').prop("selected", true);
	//document.gender[1].checked=true;
}
else if(gender=="여자"){
	$("#gender").val('여자').prop("selected", true);
	//document.gender[2].checked=true;
	
}
</script>