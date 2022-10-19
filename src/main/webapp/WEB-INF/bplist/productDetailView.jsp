<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
	
	function singleOrder(){
		
		var stock = document.myform.stock.value;
		
		if(document.myform.stock.value.length==0){
			alert("수량을 입력하세요");
			return false;
		}
		
		
		if(isNaN(document.myform.stock.value)){ //abc => true, 123 => false
			alert('숫자를 입력해주세요.');
			document.myform.stock.select();
			return false;
		}
		
		
		location.href="single.sbox?num="+${bb.num}+"&stock="+stock+"&poption="+${bb.poption };
		
		
	}
	
	function goShopBox(){
		
		var stock = document.myform.stock.value;
		
		if(document.myform.stock.value.length==0){
			alert("수량을 입력하세요");
			return false;
		}
		
		
		if(isNaN(document.myform.stock.value)){ //abc => true, 123 => false
			alert('숫자를 입력해주세요.');
			document.myform.stock.select();
			return false;
		}
		
		
		location.href="shopboxinsert.sbox?num="+${bb.num}+"&stock="+stock;
		
	}
</script>
	
	
     bplist\productDetailView.jsp<br><br>
    
<center>
    <h2>상품 상세보기</h2>
    
    <form action="single.sbox" name="myform">
    <table border="1">
    	<tr>
    		<td rowspan="7">
    			<img src="<%=request.getContextPath() %>/resources/${bb.img}" width="200px" height="200px"/>
    		</td>
    	</tr>
    	
    	<tr>
    		<td>상품명</td>
    		<td>${bb.pname }</td>
    	</tr>
    	
    	<tr>
    		<td>카테고리</td>
    		<td>${bb.category }</td>
    	</tr>
    	
    	<tr>
    		<td>옵션</td>
    		<td>${bb.poption }</td>
    	</tr>
    	
    	<tr>
    		<td>가격</td>
    		<td>${bb.price }원</td>
    	</tr>
    	
    	<tr>
    		<td>재고수량</td>
    		<td>${bb.stock }개</td>
    	</tr>
    	
    	<tr>
    		<td>주문수량</td>
    		<td>
    			<input type="text" name="stock" id="stock">
    			<input type="hidden" name="num" value="${bb.num }">
    			<input type="hidden" name="option" value="${bb.poption }">
    			<input type="button" value="주문하기" onclick="singleOrder()">
    			<input type="button" value="장바구니" onclick="goShopBox()">
    		</td>
    	</tr>
    	
    	<tr>
    		<td colspan="7">
    			<a href="list.blist?pageNumber=${pageNumber }">돌아가기</a>
    			<input type="button" value="수정" onclick="location.href='update.blist?num=${bb.num}&pageNumber=${pageNumber}'">
    			<input type="button" value="삭제" onclick="location.href='delete.blist?num=${bb.num}&pageNumber=${pageNumber}'">
    			<%-- a href="update.blist?num=${bb.num}&pageNumber=${pageInfo.pageNumber}">수정</a>
    			<a href="delete.blist?num=${bb.num}&pageNumber=${pageInfo.pageNumber}">삭제</a> --%>
    		</td>
    	</tr>
    </table>
    </form>
</center>

<center>
		<c:forEach var="replylist" items="${replylist}">

	<table>
	<tr>
		<td><img src="<%=request.getContextPath() %>/resources/${replylist.img}" width="50px" height="50px"/></td>		
		<td>${replylist.id}</td>	
		<td width="500">${replylist.content}</td>		
		<td width="300">${replylist.insertdate}</td>	
		<td>
			<c:if test="${id==bb.id || id=='admin' }">
				<input type="button"  value="수정" onclick="location.href='updatereply.blist?num=${replylist.replenum }&replenum=${replylist.replenum}'">
				<input type="button" value="삭제" onclick="location.href='deletereply.blist?num=${replylist.replenum }&replenum=${replylist.replenum}'">
			</c:if>
			<input type="button" value="신고" onclick="location.href='benList.ben?id=${replylist.id }&num=${replylist.replenum}'">	<!-- 수정해야하지만 그냥한다. -->
		</td>	
	</tr>
	
	
	
	<%-- </c:if> --%>
	</table>
	
	</c:forEach>
		</center>
	<center>
	<!--댓글 입력  -->
	
    <form action="insertreply.blist" enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td>
				댓글작성<br>
		    	이미지 <input type="file" name="upload" id="ifile"><br>
		    	<input type="text" hidden="hidden" value=" ${productinfo.num}" name="num">
		    	<input type="text" hidden="hidden" value="pro" name="type">
		    	<textarea name ="content" cols="80" rows="3"></textarea><input type="submit" value="댓글쓰기">
		    </td>
	    </tr>
    </table>
    </form>
</center>


