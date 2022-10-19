<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<center>
    <form action="cmtList.blist">
	    <h2>${totalCmtCount}개의 댓글</h2>
	    
	    <table border="1">
	   		<c:forEach var="cmtlist" items="${lists}">	<!-- BpcmtListController에서 mav.addObject로 넘겨받은 lists를 여기 넣어줌 -->
	    	<tr>
	    		<td>${cmtlist.npreplynum }</td>
	    		<td>${cmtlist.id }</td>
	    		<td>
	    			<img src="<%=request.getContextPath() %>/resources/${cmtlist.image }" width="200px" height="200px"/><br>
	    			<pre>${cmtlist.content }</pre>
	    		</td>
	    		<td>${cmtlist.regdate }</td>
	    		<td>
	    			<a href="cmtDelete.blist?num=${cmtlist.num}">삭제</a>
				</td>
	    	</tr>
	    	</c:forEach>
	    </table>
	    <br>
    </form>
    
    <br>
    
    <jsp:include page="commentInsertForm.jsp"/>
</center>
