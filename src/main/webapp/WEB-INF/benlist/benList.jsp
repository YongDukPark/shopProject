<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>
	

<script type="text/javascript">

function allCheck(acheck){
	//alert(1);
	
	var rowcheckArr = document.getElementsByName("rowcheck");	//rowcheck에 체크된애들 가져와라
	
	check = acheck.checked;
	
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

function multiAction(){
	
	var rowcheckArr = document.getElementsByName("rowcheck");
	
	if(document.myform.option.value==""){
		alert("진행이나 삭제를 선택해주세요");
		return false;
	}
	
	flag = false;
	
	for(var i=0;i<rowcheckArr.length;i++){
		if(rowcheckArr[i].checked==true){
			flag=true;
		}
	}
	if(flag==false){
		alert("하나는 선택하세요.");
		return;
	}
	
	document.myform.submit();
}

</script>
	
	
	
	<form action="benListsChange.ben" name="myform" method="get">
		<c:if test="${fn:length(lists)<1 }">
			<h2> 신고받은 유저가 없습니다.</h2>
		</c:if>
		
		<c:if test="${fn:length(lists)>0 }">
			<table border="1">
				<tr>
					<td colspan="6">
						<select name="option">
							<option value="">선택</option>
							<option value="report">진행</option>
							<option value="cancel">삭제</option>
						</select>
						<input type="button" value="실행" onclick="multiAction()">
						
					</td>
				</tr>
				<tr>
					<td>						<!-- name 똑같이하면 on이 따라와서 이상한 값이 더생김 -->
						<input type="checkbox" name="rowchecks" onClick="allCheck(this)">
					</td>
					<td>댓글번호</td>
					<td>아이디</td>
					<td>내용</td>
					<td>카테고리</td>
					<td>타입(몰,커뮤니티)</td>
				</tr>
				
				<c:forEach var = "i" begin="0" end="${fn:length(lists)-1 }" step="1">
					<tr>
						<td>
							<input type="checkbox" name="rowcheck" value="${lists[i].num}">
						</td>
						<td>${lists[i].num }</td>
						<td>${lists[i].id }</td>
						<td>${lists[i].reason }</td>
						<td>${lists[i].bencategory }</td>
						<td>${lists[i].type }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
	</form>

