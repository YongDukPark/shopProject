<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%if(session.getAttribute("loginInfo")==null){    	
out.print("로그인전 <a href='login.ulist'>로그인</a> | <a href='InsertUser.ulist'>회원가입</a>" 
		);
    } 
    else{
    	out.print("로그인후 <a href='logout.ulist'>로그아웃</a> | <a href='SelectUser.ulist'>내 정보</a>");
    }
    %>
    
    	
     <br>
 테스트 로그인 <a href='login.ulist'>로그인</a>