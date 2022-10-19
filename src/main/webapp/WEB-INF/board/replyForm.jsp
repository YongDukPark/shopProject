<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<b>답글쓰기</b>
<form method="post" action="reply.bd">
<input type="hidden" name="pageNumber" value=${pageNumber }>
<input type="hidden" name="ref" value=${ref }>
<input type="hidden" name="re_step" value=${re_step }>
<input type="hidden" name="re_level" value=${re_level }>
<table border="1">
	<tr>
		<td colspan="2" align="right"><a href="list.bd">글목록</a></td>
	</tr>
	<tr>
		<td align="center">아이디</td>
		<td><input type="text" name="writer" value="홍길동"></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="subject" value="[답글]"></td>
	</tr>
	<tr>
		<td align="center">Email</td>
		<td><input type="text" name="email" value="abc@xx.com"></td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td><textarea cols="50" rows="20" name="content">호호호</textarea></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="passwd" value="1234"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="글쓰기">
		<input type="reset" value="다시작성">
		<input type="button" value="목록보기" onclick="location.href='list.bd?pageNumber=${pageNumber}'">		
		</td>
	</tr>
</table>
</form>