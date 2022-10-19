<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<h2 align="center">NOTICE</h2>
<form:form commandName="noticeBean" action="insert.nt" method="post" enctype="multipart/form-data">
	
	<p>
		<label>글번호</label>
			<input type="hidden" name="num" value="${noticeBean.num }" />
			<input type="hidden" name="pageNumber" value="${pageNumber }">
			<br><br>	
	</p> 
	<p>
		<label>제목</label>
			<input type="text" name="subject" value="${noticeBean.subject }" />
			<form:errors cssClass="err" path="subject"/>	
			<br><br>	
	</p> 
	<p>
		<label>작성자</label>
			<input type="text" name="writer" value="${noticeBean.writer }" />
			<form:errors cssClass="err" path="writer"/>	
			<br><br>	
	</p> 
	<p>
		<label>이미지</label>
		<input type="file" name="upload" value="파일선택">
	</p>
	<p>
		<label>내용</label>
			<input type="text" name="content" value="${noticeBean.content }" />
			<form:errors cssClass="err" path="content"/>	
			<br><br>	
	</p> 
	
	<input type="submit" value="추가하기">
	<input type="reset" value="다시쓰기">
	<a href="list.nt?pageNumber=${pageNumber}"><input type="button" value="목록보기"></a>
	<a href="javascript:history.go(-1)"><input type="button" value="되돌아가기"></a>
	 
</form:form>  