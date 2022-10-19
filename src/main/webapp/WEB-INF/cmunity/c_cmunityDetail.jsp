<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<style>
   a{
      text-decoration-line: none;
      color: black;
   }
</style>


    <%
    	String id = (String)session.getAttribute("id");
    %>
    <c:set var="id" value="<%=id %>"></c:set>
    
    <script type="text/javascript">
		function deletePage(){
			var answer = confirm("정말 삭제하시겠습니까?")
			
			if(answer == true){
				location.href = "cmuDelete.cmu?num="+${bean.num};
			}
			
			else{
				
			}
		}
		
		function update(){
			location.href="cmunityUpdate.cmu?num="+${bean.num};
		}
		
		function uplikecount(){
			var answer = confirm("추천하시겠습니까?")
			
			if(answer == true){
				location.href = "upLikeCount.cmu?num="+${bean.num};
			}
			
			else{
				
			}
			
		}
		
		
	</script>
    
    
    
    <table width="60%">
    	<tr>
    		<th>
    			${bean.id }
    		</th>
    		<th style="text-align: center;">${bean.regdate }</th>
    		<th style="text-align: right">
    			조회 : ${bean.readcount } 추천 : ${bean.likecount }
    		</th>
    	</tr>
    	<tr>
    		<td>
    			
    		</td>
    		<td style="text-align: right" colspan="2">
    			<c:if test="${id == bean.id || id == 'admin'}">
    				<input type="button" value="삭제" onclick="deletePage()">
    				<input type="button" value="수정" onclick="update()">
    			</c:if>
    			<input type="button" value="글목록" onclick="history.go(-1)">
    		</td>
    	</tr>
    	<tr bordercolor="red">
    		<td>
    			글제목
    		</td>
    		<td>
    			[${bean.gender }][${bean.category }]${bean.subject }
    		</td>
    	</tr>
    	<tr>
    		<td style="text-align: center;" colspan="1">
    			<img src="<%=request.getContextPath() %>/resources/${bean.img}" width="300px" height="300px" onclick="location.href='detail.blist?num=${bean.num}&pageNumber=0'"/>
    		</td>
    		<td colspan="2">
    			상품정보<br>
    			상품명 : ${bean.pname }<br>
    			가격 : ${bean.price }<br>
    			잔여수량 : ${bean.stock }<br>
    			옵션 : ${bean.poption }<br>
    		</td>
    	</tr>
    	<tr>
    		<td style="text-align: center;" colspan="3"><a href='detail.blist?num=${bean.num}&pageNumber=0'>[여기를 클릭하거나 상품 이미지 클릭시 쇼핑몰 상품정보로]</a></td>
    	</tr>
    	<tr>
    		<td><br></td>
    	</tr>
    	<tr>
    		<td>
    			${bean.content }
    		</td>
    	</tr>
    	<tr>
    		<td style="text-align: center;" colspan="3"><input type="button" value="추천 ${bean.likecount }" onclick="uplikecount()"></td>
    	</tr>
    </table>
    
<center>
		<c:forEach var="replylist" items="${replylist}">

	<table>
	<tr>
		<td><img src="<%=request.getContextPath() %>/resources/${replylist.img}" width="50px" height="50px"/></td>		
		<td>${replylist.id}</td>	
		<td width="500">${replylist.content}</td>		
		<td width="300">${replylist.insertdate}</td>	
		<td>
			<c:if test="${id==bean.id || id=='admin' }">
				<input type="button"  value="수정" onclick="location.href='updatereply.cmu?num=${bean.num }&replenum=${replylist.replenum}'">
				<input type="button" value="삭제" onclick="location.href='deletereply.cmu?num=${bean.num }&replenum=${replylist.replenum}'">
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
	
    <form action="insertreply.cmu" enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td>
				댓글작성<br>
		    	이미지 <input type="file" name="upload" id="ifile"><br>
		    	<input type="text" hidden="hidden" value=" ${bean.num}" name="num">
		    	<input type="text" hidden="hidden" value="cmu" name="type">
		    	<textarea name ="content" cols="80" rows="3"></textarea><input type="submit" value="댓글쓰기">
		    </td>
	    </tr>
    </table>
    </form>
</center>    
    
    
    