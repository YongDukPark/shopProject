<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/common.jsp" %>
    <%@ include file="../common/loginbar.jsp" %>
      <%@ page import="java.io.PrintWriter" %>
 <% String jflag=(String)request.getAttribute("flag"); %>
<style type="text/css">
.err {
	color: red;
	font-weight: bold;
}
</style>
<script type="text/javascript" src="resources/js/jquery.js"></script>

<form:form commandName="insertuserBean" action="InsertUser.ulist" method="post" >

<h1>회원가입</h1>
아이디<input type="text" name="id" value="${id}" id="id">&nbsp;
<input type="button" value="중복확인" onclick="check()">
<form:errors cssClass="err" path="id" />
<br><br>
<!-- <input type="button" value="중복확인" onclick="duplicate()" >	 -->




비밀번호 <input type="password" name="pass" id="pass" value="${pass}">	<form:errors cssClass="err" path="pass" /><br><br>
비밀번호 확인 <input type="password" name="repass" id="repass" value="${repass}">	<form:errors cssClass="err" path="repass" /><span id="errpass" class="err"></span><br><br>
이름 <input type="text" name="name" value="${name}">	<form:errors cssClass="err" path="name" /><br><br>
성별 <select name="gender" id="gender" >
<option>선택</option>
<option value="남자">남자</option>
<option value="여자">여자</option>
</select><form:errors cssClass="err" path="gender" /><br><br>
<!-- 남자<input type="radio" name="gender" value="남자" >여자<input type="radio" name="gender" value="여자" > -->
생년월일 <input type="text" name="birth" placeholder="ex)19930405" value="${birth}"><form:errors cssClass="err" path="birth" /><br><br>
주소 <input type="text" name="address1" value="${address1}"><form:errors cssClass="err" path="address1" /><br><br>
상세주소 <input type="text" name="address2" value="${address2}"><form:errors cssClass="err" path="address2" /><br><br>
<input type="submit" value="가입하기">
</form:form>

    <script type="text/javascript" >
    function check(){
    	
    var id = document.getElementById("id").value;
location.href="Idcheck.ulist?id="+id;    	
    }
    
 	
    var jsflag = '<%=jflag%>';
    if(jsflag=="nomatch"){
    
    document.getElementById('errpass').innerText='비밀번호가 일치하지 않습니다.';
    	
    }
    else{
    	
    	 document.getElementById('errpass').innerText='';
    }
    
    var gender ='${gender}';
    if(gender=="남자"){
    	$("#gender").val('남자').prop("selected", true);
    	//document.gender[1].checked=true;
    }
    else if(gender=="여자"){
    	$("#gender").val('여자').prop("selected", true);
    	//document.gender[2].checked=true;
    }
</script>