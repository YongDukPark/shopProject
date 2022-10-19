<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    


<h2 align="center">NOTICE<br></h2>
<form:form commandName="noticeBean" action="update.nt" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${nubean.num }" />
	<input type="hidden" name="pageNumber" value="${pageNumber }">
	
	<h1> 수정 </h1>
	<p>
		<label>제목</label>
			<input type="text" name="subject" value="${nubean.subject }" />
			<form:errors cssClass="err" path="subject"/>	
			<br><br>	
	</p> 
	<p>
		<label>작성자</label>
			<input type="text" name="writer" value="${nubean.writer }" />
			<form:errors cssClass="err" path="writer"/>	
			<br><br>	
	</p> 
	<p>
		<label>이미지첨부</label>
		<input type="file" name="upload" value=${nubean.upload } />
	</p>
	<p>
		<label>내용</label>
			<input type="text" name="content" value="${nubean.content }" />
			<form:errors cssClass="err" path="content"/>	
			<br><br>	
	</p> 
	<p>
		<input type="submit" value="수정하기">
		<input type="reset" value="다시쓰기">
		<a href="list.nt?pageNumber=${pageNumber}"><input type="button" value="목록보기"></a>
		<a href="javascript:history.go(-1)"><input type="button" value="되돌아가기"></a>
	</p> 
</form:form> 

    
    