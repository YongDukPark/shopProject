<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>


<script type="text/javascript">

	function changeStock(num,pname){
		
		location.href="shopboxupdate.sbox?num="+num+"&pname="+pname;
		
	}
	
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
	
	/* $(function() {
		$('#menu1').click(function(){
			$.ajax({	//load와 같은건데 이게 제일 많이 사용된다고 한다.
						//일부분만 변화할수 있게끔 만들때 이걸 사용한다 시간을 아끼기위해 주로 사용한다.
						
					url : 'menu.html',		//요청 url : 가져올 화일의 이름		이것도 ./../ 이런식으로 움직여도 된다. 
					dataType : 'html',		//응답 결과의 타입   어떤타입으로 갖고싶냐? html 형태로
					success : function(data){	//콜백함수		위에서 호출한 값을 data에 넣는거다. 호출이 성공하면 위에 실패하면 밑에
						$('#message1').append("성공:" + data);
						//위에 append 는 단점이 새로운걸 뽑을때 지워주는 작업을 진행해야한다.
						//$('#message1').html("성공:" + data);	이건 하나의 데이터만 출력한다.
					},
					error : function(data){		//만약 실패했을때 하고싶은일이 없으면 안써도 된다.
						alert('실패' + data);		//data에 [object Object]로 나온다.
					}
			});		//ajax
		}); */
	
</script>
	
	<c:if test="${fn:length(lists) <1 }">
		장바구니에 상품이 없습니다<br>
		<a href="list.blist">상품 주문하러 가기</a>
	</c:if>
	
	<c:if test="${fn:length(lists) >0 }">
		<form action="order.sbox" name="myform">
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
			   		<td>삭제</td>
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
						<td>
							${lists[i].stock}
							<input type="button" value="교체" onclick="changeStock('${lists[i].num}','${lists[i].pname }')">
						</td>
						<td>${stockCheck[i] }</td>
						<td>${lists[i].poption}</td>
						<td>${lists[i].price}</td>
						<td>${lists[i].price*lists[i].stock }</td>
						<td>
							<c:if test="${(stockCheck[i]-lists[i].stock)<0 }"><font color="red"><b>주문불가</b></font></c:if>
							<c:if test="${(stockCheck[i]-lists[i].stock)>-1 }"><b>주문가능</b></c:if>
						</td>
						<td><input type="button" value="취소" onclick="location.href='shopboxdelete.sbox?num=${lists[i].num}'"></td>
					</tr>
				</c:forEach>
					<tr>	
						<td>
							<div id="totalPrice">모든상품 결제 가격:${totalPrice }</div>
						</td>
						<td>
							<input type="button" value = "결제하러가기" onClick = "multiOrder()">
						</td>
					</tr>
					
	   		</table>
		</form> 
    </c:if>
    
    