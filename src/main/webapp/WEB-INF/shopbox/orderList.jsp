<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>

<script type="text/javascript">

	/* function init(){
		window.open ("orderPopup","결제정보","width = 300, height = 350, left=200, top=100");
	} */
	
	
	function cancelOrder(num){
		//alert(num);
		
		var answer = confirm("정말로 삭제하실건가요..?ㅠㅠ");
			
		
		if(answer == true){
			answer2 = confirm("다시한번 생각해주세요...ㅠ");
				if(answer2 == true){
					alert("잘가요 이쁜옷이여..");
					location.href="cancelOrder.sbox?num="+num	
				}	
				else if (answer2 == false) {
					alert("즐거운 쇼핑되세요 :D");
				}
		}
		else if (answer == false) {
			alert("즐거운 쇼핑되세요 :D");
		}
		
	}
	
	function AdminCancel(id,num){
		
		//alert(num);
		//alert(id);	문자열 넘길때는 소괄호 쳐라 용덕아 ^^ 기본적인것도 못하네
		
		var answer = confirm("삭제할건가요?");
		
		if(answer = true){
			alert("삭제했어요");
			location.href="adminCancel.sbox?num="+num+"&id="+id
		}
		else if(answer = false){
			alert("그래요");
		}
	}
	
</script>
	
	<center>
	
	<h2>결제 리스트</h2><br>
	
	<c:if test="${fn:length(lists) <1 }">
		상품이 없습니다<br>
		<a href="list.blist">상품 주문하러 가기</a>
		
		
	</c:if>
	
	
	<c:if test="${fn:length(lists) >0 }">
		
		<!-- admin 아닐경우 -->
		<c:if test="${id != 'admin' }">
			
			<form action="Ordlist.sbox" method="get">
				
				<select name="whatColumn" >
					<option value="" >선택
					<option value="name" >상품명
				</select>
					<input type="text" name="keyword">
					<input type="submit" value="검색"> 
			
			<table>
					
				<tr>
					<td>번호</td>
					<td>사진</td>
					<td>상품명</td>
					<td>수량</td>
					<td>옵션</td>
					<td>주문일자</td>
					<td>현상태</td>
					<!-- <td>옵션변경</td> -->
					<td>취소</td>
				</tr>
				
				<c:forEach var = "i" begin="0" end="${fn:length(lists)-1 }" step="1">
					<tr>
						<td>${lists[i].num }</td>
						<td><img src="<%=request.getContextPath() %>/resources/${lists[i].img }" width="50px" height="50px"/></td>
						<td>
							<a href="detail.blist?num=${lists[i].num }&pageNumber=0">
								${lists[i].pname }
							</a>	
						</td>
						<td>${lists[i].stock }</td>
						<td>${lists[i].poption }</td>
						<td>${lists[i].regdate }</td>
						<td>${lists[i].status }</td>
						<%-- <td>
							<input type="button" value="옵션변경" onclick="location.href='viewProduct.sbox?num=${lists[i].num}'">
						</td> --%>
						<td>
							<input type="button" value="주문취소" onclick="cancelOrder(${lists[i].num })">
						</td>
					</tr>
				</c:forEach>
				
				<tr>
					<td colspan="8">${pageInfo.pagingHtml}</td>
				</tr>
				
			</table>
			
			</form>
		</c:if>
		
		
		
		
		
		<!-- admin 접속시 -->
		<c:if test="${id == 'admin' }">
			
			<form action="Ordlist.sbox" method="get">
			
				<select name="whatColumn" >
					<option value="" >선택
					<option value="name" >상품명
					<option value="id" >id
				</select>
					<input type="text" name="keyword">
					<input type="submit" value="검색"> 
			
			<table>
				
					
				<tr>
					<td>번호</td>
					<td>사진</td>
					<td>상품번호</td>
					<td>구매자</td>
					<td>상품명</td>
					<td>수량</td>
					<td>옵션</td>
					<td>주문일자</td>
					<td>현상태</td>
					<td>주문취소</td>
				</tr>
				
				<c:forEach var = "i" begin="0" end="${fn:length(lists)-1 }" step="1">
					<tr>
						<td>${totalCount=totalCount-1 }</td>
						<td>${lists[i].num }</td>
						<td><img src="<%=request.getContextPath() %>/resources/${lists[i].img }" width="50px" height="50px"/></td>
						<td>${lists[i].id }</td>
						<td>
							<a href="detail.blist?num=${lists[i].num }">
								${lists[i].pname }
							</a>
						</td>
						<td>${lists[i].stock }</td>
						<td>${lists[i].poption }</td>
						<td>${lists[i].regdate }</td>
						<td>${lists[i].status }</td>
						<td>
							<input type="button" value="주문취소" onclick="AdminCancel('${lists[i].id }',${lists[i].num } )">
						</td>
					</tr>
				</c:forEach>
				
				<tr>
					<td colspan="9">${pageInfo.pagingHtml}</td>
				</tr>
				
			</table>
		
		</form>
		
		
		</c:if>
	</c:if>
		</center>
	
	
	