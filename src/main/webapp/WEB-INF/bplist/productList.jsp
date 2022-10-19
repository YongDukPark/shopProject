<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function insert() {
		location.href = "insert.blist";
	}
</script>

    bplist\productList.jsp<br><br>  
  
    <center>
    <h2>상품 리스트</h2>
    
    <form action="list.blist">
    
    	<select name="whatColumn">
    		<option value="all">전체선택
    		<option value="pname">상품명
    		<option value="category">카테고리
    	</select>
    	<input type="text" name="keyword">
    	<input type="submit" value="검색">
    </form>
    
    <table border="1">
    	<tr>
    		<td align="right" colspan="6">
    			<input type="button" value="추가하기" onClick="insert()">
    		</td>	
    	</tr>
    	<tr>
    		<th>번호</th>
    		<th>사진</th>
    		<th>상품명</th>
    		<th>카테고리</th>
    		<th>옵션</th>
    		<th>가격</th>
    		<!-- <th>수정</th>
    		<th>삭제</th> -->
    	</tr>
    	<c:forEach var="bplist" items="${list }">	<!-- ListController에서 mav.addObject로 넘겨받은 list를 여기 넣어줌 -->
    	<tr>
    		<td>${bplist.num }</td>
    		<td>
    			<!-- 이미지 누르면 상세보기 페이지로 이동하기 -->
    			<a href="detail.blist?num=${bplist.num }&pageNumber=${pageInfo.pageNumber}">
    			<img src="<%=request.getContextPath() %>/resources/${bplist.img}" width="50px" height="50px"/>
    			</a>
    		</td>
    		<td>${bplist.pname }</td>
    		<td>${bplist.gender } ${bplist.category }</td>
    		<td>${bplist.poption }</td>
    		<td>${bplist.price }원</td>
    		<%-- <td>
    			<a href="update.blist?num=${bplist.num}&pageNumber=${pageInfo.pageNumber}">수정</a>
    		</td>
    		<td>
    			<a href="delete.blist?num=${bplist.num}&pageNumber=${pageInfo.pageNumber}">삭제</a>
    		</td> --%>
    	</tr>
    	</c:forEach>
    </table>
    <br>
    ${pageInfo.pagingHtml }	
    </center>