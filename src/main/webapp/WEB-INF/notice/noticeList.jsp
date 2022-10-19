<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
   a{
      text-decoration-line: none;
      color: black;
   }
</style>

<script  type="text/javascript">
 	function insert() {
		 location.href="insert.nt";
 	}
	function goUpdate(num,pageNumber){
		location.href="update.nt?num="+num+"&pageNumber="+pageNumber;
	}
</script>

<!-- WEB-INF/noticeList.jsp -->
<center>
<h2 align="center">NOTICE<br>(레코드 갯수:${totalCount})</h2>
<form action="list.nt" method="get">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="writer">작성자
		<option value="content">내용
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색">
</form> 
</center>

<center>
<table border="2" >
	<tr>
		<td colspan="8" align="right">
			<c:if test="${id=='admin' }">
				<input type="button" value="글쓰기" onClick="insert()">
			</c:if>
		</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="ntf" items="${list}">
		<tr>
			<td>${ntf.num }</td>
			<td><a href="view.nt?num=${ntf.num }&pageNumber=${pageInfo.pageNumber }">${ntf.subject}</a></td> 
			<%-- <td>${ntf.subject}</td> --%>
			<td>${ntf.writer }</td>
			<td>
				<fmt:formatDate value="${ntf.regdate }" pattern="yyyy/MM/dd HH:mm" type="both"/>
			</td>
			<td>${ntf.readcount }</td>
			<td>
				<input type="button" value="수정" onclick="goUpdate('${ntf.num}','${pageInfo.pageNumber}')">
			</td>
			<td>
				<a href="delete.nt?num=${ntf.num }&pageNumber=${pageInfo.pageNumber }">삭제</a>
			</td>
		</tr>
	</c:forEach>
</table>
	
${pageInfo.pagingHtml}
</center>
<br><br><br><br>    