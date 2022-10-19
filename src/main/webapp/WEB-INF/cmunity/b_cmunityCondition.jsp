<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
	
<style>
	a{
		text-decoration-line: none;
		color: black;
	}
</style>
	
	<c:if test="${fn:length(lists)<1 }">
		관련된 글이 없습니다.
	</c:if>
	
	
	<c:if test="${fn:length(lists)>0 }">
	
	<input type="button" value = "글작성" onclick="location.href='insertForm.cmu'">
	
	<table width="60%">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach  var = "i" begin="0" end="${fn:length(lists)-1 }" step="1">
			<tr>
				<td style="text-align: center;">${lists[i].num }</td>
				<td>
					<a href="detail.cmu?num=${lists[i].num }&type=cmu"><font style="color: gray;">[${lists[i].gender }][${lists[i].category }]</font>${lists[i].subject }<font style="color: red;">[${lists[i].likecount }]</font></a>
				</td>
				<td style="text-align: center;">${lists[i].id }</td>
				<td style="text-align: center;">${lists[i].readcount }</td>
				<td style="text-align: center;">${lists[i].regdate }</td>
			</tr>
		</c:forEach>
	</table>
    
    ${pageInfo.getPagingHtml()}
    
	</c:if>
    
    
    
    
    