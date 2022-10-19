<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
userList
<a href="start.jsp">시작페이지</a>
<%@ include file="../common/adminbar.jsp" %><br>
<%@ include file="../common/admininfo.jsp" %><br>
<center>
productList.jsp<br>
레코드:${totalCount}
<br>
<form action="userList.ulist" method="get">
<select name="whatColumn">
<option value="name">이름</option>
<option value="id">아이디</option>
<option value="gender">성별</option>
</select>
<input type="text" name="keyword">
<input type="submit" value="검색">
</form>
<table border="1">
	<tr>
		<th>num</th>
		<th>id</th>
		<th>password</th>
		<th>name</th>
		<th>gender</th>
		<th>birth</th>
		<th>pnum</th>
		<th>address</th>
		<th>insertdate</th>
		<th>benpoint</th>
		<th>grade</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.num }</td>
			<td><a href="userDetail.ulist?num=${user.num}&pageNumber=${pageInfo.pageNumber}&id=${user.id}">${user.id }</a></td>
			<td>${user.pass }</td>
			<td>${user.name }</td>
			<td>${user.gender }</td>
			<td>${user.birth }</td>
			<td>${user.pnum }</td>
			<td>${user.address1} ${user.address2 }</td>
			<td>${user.insertdate }</td>
			<td>${user.benpoint }</td>
			<td>${user.grade }</td>
			<td><a href="userDelete.ulist?num=${user.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
${pageInfo.getPagingHtml()}
</center>
