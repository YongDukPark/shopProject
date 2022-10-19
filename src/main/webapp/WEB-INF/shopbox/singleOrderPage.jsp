<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">


</script>


<!-- 단일상품일경우 -->
	<form name="myform" action="finalSingleOrder.sbox?price=${bean.price }&num=${bean.num }">
		<input type = "hidden" name = "num" value = "${bean.num}">
		<input type = "hidden" name = "totalprice" value = "${bean.price*bean.stock}">
	   	<table border="1">
	   		<tr>
	   			<td>번호</td>	
	   			<td>이미지</td>	
	   			<td>상품명</td>	
	   			<td>주문수량</td>	
	   			<td>쇼핑몰 잔여수</td>
	   			<td>주문옵션</td>
	   			<td>가격</td>
		   		<td>상품 총가격</td>
		   		<td>주문 가능상태</td>
			</tr>
				
			<tr>
				<td>${bean.num}</td>
				<td>
					<img src="<%=request.getContextPath() %>/resources/${bean.img}" width="50px" height="50px"/>
				</td>
				<td>${bean.pname }</td>
				<td>${bean.stock}</td>
				<td>${stock }</td>
				<td>${bean.poption}</td>
				<td>${bean.price}</td>
				<td>${bean.price*bean.stock }</td>
				<td>
					<c:if test="${(stock-bean.stock)<0 }"><font color="red"><b>주문불가</b></font></c:if>
					<c:if test="${(stock-bean.stock)>-1 }"><b>주문가능</b></c:if>
				</td>
			</tr>
			<tr>
				<td>
					총가격:${bean.price }
				</td>
				<td>
					<input type="submit" value = "결제" onclick="goOrder()">
				</td>	
			</tr>
		</table>
	</form> 


    