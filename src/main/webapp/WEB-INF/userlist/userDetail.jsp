<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>상품상세 ${user.num }</h1>
<table border="1" style="float:left;">
	<tr>
		<td>num</td>
		<td>${user.num }</td>
	</tr>
	<tr>
		<td>id</td>
		<td>${user.id }</td>
	</tr>
	<tr>
		<td>password</td>
		<td>${user.pass }</td>
	</tr>
	<tr>
		<td>name</td>
		<td>${user.name }</td>
	</tr>
	<tr>
		<td>gender</td>
		<td>${user.gender }</td>
	</tr>
	<tr>
		<td>birth</td>
		<td>${user.birth }</td>
	</tr>
	<tr>
		<td>pnum</td>
		<td>${user.pnum }</td>
	</tr>
	<tr>
		<td>address</td>
		<td>${user.address1} ${user.address2 }</td>
	</tr>
	<tr>
		<td>insertdate</td>
		<td>${user.insertdate }</td>
	</tr>
	<tr>
		<td>benpoint</td>
		<td>${user.benpoint }</td>
	</tr>
	<tr>
		<td>grade</td>
		<td>${user.grade }</td>
	</tr>
	<tr>
		<td colspan="3" align="right"><a href="userList.ulist?pageNumber=${pageNumber}">리스트</a></td>
	</tr>
</table>
<table border='1' style="float:left;">
	<tr>
		<td>id</td>
		<td>pname</td>
		<td>img</td>
		<td>regdate</td>
		<td>status</td>
		<td>stock</td>
		<td>options</td>
		<td>price</td>
		<td>total</td>
	</tr>
	<c:if test="${fn:length(payments)-1>=0}">
	<c:forEach var="i" begin="0" end="${fn:length(payments)-1}">
		<tr>
			<td>${payments[i].id}</td>
			<td>${payments[i].pname}</td>
		<c:if test="${payments[i].img!=null}">
			<td><img src="<%=request.getContextPath() %>/resources/${payments[i].img}" width="50px" height="50px"/></td>
			
		</c:if>
		<c:if test="${payments[i].img==null}">
			<td>이미지 없음</td>
		</c:if>
			<td>${payments[i].regdate}</td>
			<td>${payments[i].status}</td>
			<td>${payments[i].stock}</td>
			<td>${payments[i].poption}</td>
			<td>${payments[i].price}</td>
			<td>${payments[i].stock*payments[i].price }</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${fn:length(payments)-1<0}">
		<td colspan="9" align="center">주문 내역 없음</td>
	</c:if>
	<%-- <c:forEach var='payment' items="${payments }">
		<tr>
			<td>${payment.id}</td>
		<c:if test="${payment.img!=null}">
			<td><img src='<%=request.getRealPath("resources")%>${payment.img}'/></td>
		</c:if>
		<c:if test="${payment.img==null}">
			<td>이미지 없음</td>
		</c:if>
			<td>${payment.regdate}</td>
			<td>${payment.status}</td>
			<td>${payment.stock}</td>
			<td>${payment.options}</td>
		</tr>
	</c:forEach> --%>
</table>
