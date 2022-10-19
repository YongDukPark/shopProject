<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!--  noticeView.jsp -->

<script type="text/javascript">
	function goUpdatenv() {
		location.href="update.nt?num="+${nvbean.num }+"&pageNumber="+${pageNumber };
	}
	function goDeletenv(){
		location.href="delete.nt?num="+${nvbean.num }+"&pageNumber="+${pageNumber };
	}
	function goReplynv(){
		//alert(3);
		location.href="reply.nt?ref="+${nvbean.ref }+"&restep="+${nvbean.restep }+"&relevel="+${nvbean.relevel };
	}			
</script>
<center>
<form method="post" action="view.nt">
<p>
	<a href="javascript:history.go(-1)"><input type="button" value="되돌아가기"></a>
</p>	
	<table border = "1" width = "500" align="center">
		<tr>
			<td align="center">글번호</td>
			<td align="center">${nvbean.num }</td>
			<td align="center">조회수</td>
			<td align="center">${nvbean.readcount}</td>
		</tr>
		<tr>
			<td align="center">작성자</td>
			<td align="center">${nvbean.writer}</td>
			<td align="center">작성일</td>
			<td align="center"><fmt:formatDate value="${nvbean.regdate}" pattern="yyyy/MM/dd HH:mm" type="both"/>
			<%-- 선택사항
				<fmt:parseDate var="parseDateDay" value="${nvbean.regdate}" pattern="yyyy-MM-dd hh:mm" />
				<fmt:formatDate var="formatDateDay" value="${parseDateDay}" pattern="yyyy-MM-dd hh:mm"/>
				${formatDateDay } 
			--%>
			</td>	
		</tr>
		
		<tr>
			<td align="center">이미지</td>
			<td colspan="3">
				<img src="<%=request.getContextPath() %>/resources/${nvbean.image}" width="300px" height="300px" /><br>
			</td>
		</tr>
		
		<tr>
			<td align="center">글제목</td>
			<td colspan="3">${nvbean.subject}</td>
		</tr>
		
		<tr height = "50">
			<td align="center">글내용</td>
			<td colspan="3">${nvbean.content}</td>
		</tr>
		<tr align="center" height = "50">
			<td colspan="4">
			 	<c:if test="${id == 'admin' }">
					<input type="button" value="수정" 	onclick="goUpdatenv()">
					<input type="button" value="삭제" 	onclick="goDeletenv()">
					<input type="button" value="답글"		onclick="goReplynv()">
				</c:if>
				<input type="button" value="글 목록" 	onclick="location.href='list.nt?pageNumber=${pageNumber }'">		
			
			</td>																
		</tr>
	</table>
</form>

<!-- 페이지코드 설정 작업 -->
	${pageInfo.pagingHtml }
</center>
