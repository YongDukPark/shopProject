<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<form:form commandName="noticeBean" method="post" action="reply.nt" enctype="multipart/form-data">
<input type="hidden" name="ref" value="${ref }">
<input type="hidden" name="restep" value="${restep }">
<input type="hidden" name="relevel" value="${relevel }">

<table border = "1">
  	
   	<tr>
  		<th align="right" colspan="2"><a href="list.nt?pageNum=${pageNumber}">본문</a></th>	
	</tr> 
	<tr>
		<td align="center">제목</td>
		<td>
			<input type="text" name="subject" value="[답글]${nrbean.subject }">
			<form:errors path="subject" cssClass="err"></form:errors>
		</td>
	</tr>
	<tr>
		<td align="center">작성자</td>
		<td>
			<input type="text" name="writer" value="${nrbean.writer }">
			<form:errors path="writer" cssClass="err"></form:errors>
		</td>
	</tr>
	<tr>
		<td align="center">이미지 첨부</td>
		<td>
			<input type="file" name="upload" value="파일선택">
		</td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td>
			<input type="text" name="content" value="${nrbean.content }">
			<form:errors path="content" cssClass="err"></form:errors>
		</td>
	</tr>
  	<tr>
  		<td colspan="2" align="center">
  			<input type="submit" value="답글쓰기" >
  			<input type="reset" value="다시작성">
  			<input type="button" value="목록보기" onClick="location.href='list.nt?pageNum=${pageNumber}'">
  		</td>	
  	</tr>
</table>
</form:form>
    
    
    