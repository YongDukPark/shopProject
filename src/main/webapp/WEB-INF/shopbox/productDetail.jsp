<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <center>
    <h2>상품 상세보기</h2>
    
    
    <!-- 미사용 -->
    
    
<form action="update.sbox">
    <table border="1">
    	<tr>
    		<td rowspan="7">
    			<img src="<%=request.getContextPath() %>/resources/${bean.img}" width="200px" height="200px"/>
    		</td>
    	</tr>
    	
    	<tr>
    		<td>상품명</td>
    		<td>${bean.pname }</td>
    	</tr>
    	
    	<tr>
    		<td>옵션</td>
    		<td>
    			기존옵션 : ${bean.poption } <br>
    			변경옵션 : 
    		</td>
    	</tr>
    	
    	<tr>
    		<td>가격</td>
    		<td>${bean.price }원</td>
    	</tr>
    	
    	<tr>
    		<td>재고수량</td>
    		<td>${bean.stock }개</td>
    	</tr>
    	
    	<tr>
    		<td>주문수량</td>
    		<td><input type="text"><input type="submit" value="옵션 변경하기"></td>
    	</tr>
    	
    	<tr>
    		<td colspan="7">
    		</td>
    	</tr>
    </table>
    </form>
</center>
    
    
    
    
    
    
    