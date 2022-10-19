<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
	<tr>
		<td>
			<table border="1">
				<tr>
					<td colspan="4">특가 상품</td> <!-- price가 10000 이하인 상품 -->
				</tr>
				<tr>
					<td>번호</td>
					<td>상품명</td>
					<td>가격</td>
				</tr>
				<tr>
					<td>${saleProd[0].num }</td>
					<td>
						<a href="detail.blist?num=${saleProd[0].num }">
						${saleProd[0].pname }
						</a>
					</td>
					<td>${saleProd[0].price }</td>
				</tr>
				<tr>
					<td>${saleProd[1].num }</td>
					<td>
						<a href="detail.blist?num=${saleProd[1].num }">
						${saleProd[1].pname }
						</a>
					</td>
					<td>${saleProd[1].price }</td>
				</tr>
			</table>
		<td>
		
		<td>
			<table border="1">		
				<tr>
					<td colspan="3">품절임박 상품</td>	 <!-- stock 100 이하 -->
				</tr>
				<tr>
					<td>번호</td>
					<td>상품명</td>
					<td>가격</td>
				</tr>
				<tr>
						<td>${soldoutProd[0].num }</td>
						<td>
						<a href="detail.blist?num=${soldoutProd[0].num }">
						${soldoutProd[0].pname }
						</a>
						</td>
						<td>${soldoutProd[0].price }</td>
				</tr>
				<tr>
						<td>${soldoutProd[1].num }</td>
						<td>
						<a href="detail.blist?num=${soldoutProd[1].num }">
						${soldoutProd[1].pname }
						</a>
						</td>
						<td>${soldoutProd[1].price }</td>
				</tr>
			</table>
		<td>
	</tr>
	
	<tr>
		<td>
			<table border="1">		
				<tr>
					<td colspan="3">남성 의류</td>	 <!-- gender=남성 -->
				</tr>
				<tr>
					<td>번호</td>
					<td>상품명</td>
					<td>가격</td>
				</tr>
				<tr>
					<td>${menProd[0].num }</td>
					<td>
						<a href="detail.blist?num=${menProd[0].num }">
						${menProd[0].pname }
						</a>
					</td>
					<td>${menProd[0].price }</td>
				</tr>
				<tr>
					<td>${menProd[1].num }</td>
					<td>
						<a href="detail.blist?num=${menProd[1].num }">
						${menProd[1].pname }
						</a>
					</td>
					<td>${menProd[1].price }</td>
				</tr>
			</table>
		<td>
		
		<td>
			<table border="1">		
				<tr>
					<td colspan="3">여성 의류</td>	
				</tr>
				<tr>
					<td>번호</td>
					<td>상품명</td>
					<td>가격</td>
				</tr>
				<tr>
					<td>${wemenProd[0].num }</td>
					<td>
						<a href="detail.blist?num=${wemenProd[0].num }">
						${wemenProd[0].pname }
						</a>
					</td>
					<td>${wemenProd[0].price }</td>
				</tr>
				<tr>
					<td>${wemenProd[1].num }</td>
					<td>
						<a href="detail.blist?num=${wemenProd[1].num }">
						${wemenProd[1].pname }
						</a>
					</td>
					<td>${wemenProd[1].price }</td>
				</tr>
			</table>
		<td>
	</tr>	
</table>

<!-- <a href="">전체 상품 보기</a> -->