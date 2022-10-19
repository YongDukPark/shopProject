<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>

<center>
<h2>게시판</h2>
<form action="list.bd" method="post">
<select name="whatColumn">
	<option value="subject">제목
	<option value="writer">작성자
</select>
<input type="text" name="keyword">
<input type="submit" value="검색">
</form>
<table width="700" border="1">
	<tr>
		<th colspan="6" align="right"><a href="write.bd">글쓰기</a></th>
	</tr>
	<tr>
		<td align="center">번호</td>
		<td align="center">제목</td>
		<td align="center">작성자</td>
		<td align="center">작성일</td>
		<td align="center">조회</td>
		<td align="center">IP</td>
	</tr>
	<c:set var="article" value="${list}"/>
	<c:if test="${fn:length(list)-1>=0 }">
	<c:forEach var="i" begin="0" end="${fn:length(list)-1}">
		<tr>
			<td align="center">${number-i }</td>
			<td>
			<c:if test="${article[i].re_level>0}">
				<img src="${pageContext.request.contextPath}/resources/images/level.gif" width="${article[i].getRe_level()*20}" height="15" >
				<img src="${pageContext.request.contextPath}/resources/images/re.gif" >
			</c:if>
			<a href="content.bd?num=${article[i].getNum()}&pageNumber=${pageNumber}">${article[i].getSubject()}</a>
			<c:if test="${article[i].readcount>10}">
				<img src="${pageContext.request.contextPath}/resources/images/hot.gif" >
			</c:if>
			</td>
			<td align="center">${article[i].getWriter()}</td>
			<td align="center">${article[i].reg_date }</td>
			<td align="center">${article[i].getReadcount()}</td>
			<td align="center">${article[i].getIp()}</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${fn:length(list)-1<0 }">
		<tr><td colspan="6" align="center">글없음</td></tr>
	</c:if>
<%-- 	<c:forEach var="article" items="${list}">
		<tr>
			<td align="center">${number }</td>
			<td>
			<c:if test="${article.re_level>0}">
				<img src="../../images/level.gif" width="${article.getRe_level()*20}" height="15" >
				<img src="../../images/re.gif" >
			</c:if>
			<a href="content.bd?num=${article.getNum()}&pageNumber=${pageNumber}">${article.getSubject()}</a>
			<c:if test="${article.readcount>10}">
				<img src="./images/hot.gif" >
			</c:if>
			</td>
			<td align="center">${article.getWriter()}</td>
			<td align="center">${article.reg_date }</td>
			<td align="center">${article.getReadcount()}</td>
			<td align="center">${article.getIp()}</td>
		</tr>
		</c:forEach> --%>
</table>
${pageInfo.pagingHtml }
</center>