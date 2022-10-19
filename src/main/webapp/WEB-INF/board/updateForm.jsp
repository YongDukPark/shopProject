<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<style type="text/css">
.err{
color:red;
}
</style>
<form:form commandName="bean" method="post" action="update.bd">
<input type="hidden" name="num" value=${bean.num }>
<input type="hidden" name="pageNumber" value=${pageNumber }>
<table border="1">
	<tr>
		<td colspan="2" align="right"><a href="list.bd">글목록</a></td>
	</tr>
	<tr>
		<td align="center">이름</td>
		<td><input type="text" name="writer" value="${bean.writer }"><form:errors path="writer" cssClass="err"/></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="subject" value="${bean.subject }"><form:errors path="subject" cssClass="err"/></td>
	</tr>
	<tr>
		<td align="center">Email</td>
		<td><input type="text" name="email" value="${bean.email }"><form:errors path="email" cssClass="err"/></td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td><textarea cols="50" rows="20" name="content">${bean.content }</textarea><form:errors path="content" cssClass="err"/></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="passwd" value="${bean.passwd}"><form:errors path="passwd" cssClass="err"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="글쓰기">
		<input type="reset" value="다시작성">
		<input type="button" value="목록보기" onclick="location.href='list.bd?pageNumber=${pageNumber}'">		
		</td>
	</tr>
</table>
</form:form>