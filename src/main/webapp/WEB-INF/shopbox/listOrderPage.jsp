<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    



<script type="text/javascript">

function allCheck(acheck){
	//alert(1);
	
	var rowcheckArr = document.getElementsByName("rowcheck");	//rowcheck에 체크된애들 가져와라
	var allstock = document.getElementsByName("stock");
	
	//alert(rowcheckArr);
	
	check = acheck.checked;
	
	//alert(check);	true 나온다.  체크되면 true
	
	if(check){ // allcheck 체크했으면
		for(var i=0;i<rowcheckArr.length;i++){
			rowcheckArr[i].checked = true;
		}
	}
	else{ // allcheck 해제 했으면
		for(var i=0;i<rowcheckArr.length;i++){
			rowcheckArr[i].checked = false;
		}
	}
}

function multiOrder(){
	//alert(5);
	
	var rowcheckArr = document.getElementsByName("rowcheck");
	
	flag = false;
	
	for(var i=0;i<rowcheckArr.length;i++){
		if(rowcheckArr[i].checked==true){
			flag=true;
		}
	}
	if(flag==false){
		alert("최소 하나는 선택해주세요 :D");
		return;
	}
	
	
	document.myform.submit();
}



</script>

	<form action="finalListOrder.sbox" name="myform">
		<table border="1">
   			<tr>
   				<td>
  					<input type="checkbox" name="rowcheck" onClick="allCheck(this)">
				</td>
		   		<td>번호</td>	
		   		<td>상품번호</td>	
		  		<td>이미지</td>
  				<td>상품명</td>	
		 		<td>주문수량</td>	
		 		<td>쇼핑몰 잔여수</td>
   				<td>주문옵션</td>
		   		<td>가격</td>
		   		<td>상품 총가격</td>
		   		<td>주문 가능상태</td>
			</tr>
			
			
			<c:forEach var = "i" begin="0" end="${fn:length(lists)-1 }" step="1">
				<tr>
					<td>
						<input type="checkbox" name="rowcheck" value="${lists[i].num}" checked>
						<input type="hidden" name="totalPrice" value="${lists[i].price*lists[i].stock }">
					</td>
					<td>${1+i}</td>
					<td>${lists[i].num}</td>
					<td>
						<img src="<%=request.getContextPath() %>/resources/${lists[i].img}" width="50px" height="50px"/>
					</td>
					<td>${lists[i].pname }</td>
					<td>${lists[i].stock}</td>
					<td>${stockCheck[i] }</td>
					<td>${lists[i].poption}</td>
					<td>${lists[i].price}</td>
					<td>${lists[i].price*lists[i].stock }</td>
					<td>
						<c:if test="${(stockCheck[i]-lists[i].stock)<0 }"><font color="red"><b>주문불가</b></font></c:if>
						<c:if test="${(stockCheck[i]-lists[i].stock)>-1 }"><b>주문가능</b></c:if>
					</td>
				</tr>
			</c:forEach>
				<tr>	
					<td>
						<div id="totalPrice">모든상품 결제 가격:${totalPrice }</div>
					</td>
					<td>
						<input type="button" value = "결제" onClick = "multiOrder()">
					</td>
				</tr>
				
   		</table>
	</form> 












