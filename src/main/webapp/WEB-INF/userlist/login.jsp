<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script type="text/javascript">  
</script>
    <style type="text/css">
.err {
	color: red;
	font-weight: bold;	
}
</style>
<%@include file="../common/common.jsp" %>
<%@ include file="../common/loginbar.jsp" %>
<%@ include file="../inc/header.jsp" %>
    
<!-- header -->
<section>
<form:form commandName="loginBean" action="login.ulist" method="post">
	<div class="container">
		<!-- content S -->
		
		<div class="shop_member">
			<div class="login_box">
				<h3>로그인</h3>
				<div class="row">
					<div class="col-md-6 col-sm-12">
						<div class="shop_input_wrap">
							<input type="text" placeholder="ID" name="id" value="${id}" id="id">
							 <form:errors cssClass="err" path="id" /><br>
						</div>
					</div>
					<div class="col-md-6 col-sm-12">
						<div class="shop_input_wrap">
							<input type="password" placeholder="PASSWORD" name="pass" value="${pass}">
						    <form:errors cssClass="err" path="pass" /><br>
							<input type="checkbox" name="rememberId" value="checked" id="rememberId">아이디 기억하기
						</div>
					</div>
					<div class="col-md-12">
						<!-- <a href="" class="login_btn">로그인</a> -->
						<input type="submit" value="로그인" onclick="sendit()" >
					</div>
					<div class="col-md-12">
						<div class="btn_wrap">
							<a href="SearchId.ulist">아이디 찾기</a>
							<a href="SearchPass.ulist">비밀번호 찾기</a>
							<a href="InsertUser.ulist">회원가입</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- content E -->
	</div>
</form:form>
</section>


<!-- footer -->
<%@ include file="../inc/footer.jsp" %>
  <script type="text/javascript">  
    window.onload = function() {
    	 
        if (getCookie("id")) { 
            document.getElementById("id").value = getCookie("id"); 
            document.getElementById("rememberId").checked = true; 
        }//쿠키가 있다면 아이디 값 넣고 체크여부 체크되게 하기 
     /*  if(!getCookie("popup")){
    	 window.open('pop/pop1.jsp','pop1','width=200, height=300,resizable=no, status=no, scrollbars= 0, toolbar=0, menubar=no');
      } //팝업창띄우기*/
        
    }
  
function setCookie(name, value, expiredays) 
{
var todayDate = new Date();
todayDate.setDate(todayDate.getDate() + expiredays);
document.cookie = name + "=" + escape(value) + "; path=/; expires="
        + todayDate.toGMTString() + ";"
}

function getCookie(Name) { 
var search = Name + "=";
if (document.cookie.length > 0) { 
    offset = document.cookie.indexOf(search);
    if (offset != -1) { 
        offset += search.length;
        end = document.cookie.indexOf(";", offset); 
        if (end == -1)
            end = document.cookie.length;
        return unescape(document.cookie.substring(offset, end));
    }
}
}

function sendit() {



if (document.getElementById("rememberId").checked == true) { // 아이디 기억하기가 체크되었을때
    setCookie("id", document.getElementById("id").value, 7); //쿠키생성
} else { 
    setCookie("id", document.getElementById("id").value, 0); //쿠키삭제
}



}
</script>