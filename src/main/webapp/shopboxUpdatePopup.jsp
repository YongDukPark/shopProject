<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String num = request.getParameter("num");
	String id = request.getParameter("id");
	String pname = request.getParameter("pname");
	
%>

<form action="updateAction.sbox">
	<input type="hidden" name="id" value="<%=id%>">
	<input type="hidden" name="num" value="<%=num%>">
	<table>
    	<tr>
    		<td>상품번호</td>
    		<td>상품명</td>
    		<td>교체할 수량</td>
    	</tr>
    	<tr>
    		<td><%=num %></td>
    		<td><%=pname %></td>
    		<td><input type="text" name="stock"></td>
    	</tr>
    	<tr>
    		<td>
    			<input type = "submit" value="수정">
    			<input type = "button" value="닫기" onclick="window.close()">
    		</td>
    	</tr>
    </table>
</form>
    