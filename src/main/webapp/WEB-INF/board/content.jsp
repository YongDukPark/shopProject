<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="text-align: center;"><b>글내용보기</b></div>
<form>
	<table border="1" width="600" style="margin: auto;">
		<tr>
			<td>글번호</td>
			<td>${bean.num }</td>
			<td>조회수</td>
			<td>${bean.readcount }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${bean.writer }</td>
			<td>작성일</td>
			<td>${bean.reg_date }</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td colspan="3">${bean.subject }</td>
		</tr>
		<tr height="400">
			<td>글내용</td>
			<td colspan="3">${bean.content }</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<c:if test="${id==bean.writer||id=='admin'}">
				<input type="button" value="글수정" onclick="location.href='update.bd?num=${bean.num }&pageNumber=${pageNumber }'">
				<input type="button" value="글삭제" onclick="location.href='delete.bd?num=${bean.num }&pageNumber=${pageNumber }'">
				</c:if>
				<input type="button" value="답글쓰기" onclick="location.href='reply.bd?num=${bean.num }&ref=${bean.ref }&re_step=${bean.re_step }&re_level=${bean.re_level }&pageNumber=${pageNumber }'">
				<input type="button" value="글목록" onclick="location.href='list.bd?pageNumber=${pageNumber }'">
			</td>
		</tr>		
	</table>
</form>