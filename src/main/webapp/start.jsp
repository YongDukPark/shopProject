<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

	<script type="text/javascript">
		function go(){
			location.href="single.sbox"
		}
		function togo(){
			location.href="order.sbox"
		}
		
		function idDelete(){
			location.href="idDelete.sbox"
		}
		
		function userList(){
			location.href="userList.ulist"
		}
		
		function shopList(){
			location.href="list.blist"
		}
		
		function gocum(){
			location.href="list.nt"
		}
		
		function OrderList(){
			location.href="Ordlist.sbox"
		}
		
		function login(){
			location.href="login.ulist"
		}
		
		function report(){
			var num = document.getElementById("num").value;
			var id = document.getElementById("id").value;
			
			//alert(num);
			//alert(id);
			
			location.href="benList.ben?num="+num+"&id="+id
			
			
		}
		
		function test99(){
			location.href="test99.ben";
		}
		
		
	</script>
	
    <%
    	//response.sendRedirect("goshopbox.sbox");
    %>
    
   <!--  박용<input type="button" value="test" onclick="go()"><br>
    박용<input type="button" value="testlist" onclick="togo()"><br> -->
    박용<input type="button" value="orderList" onclick="OrderList()"><br>
    
    현재 세션값 : ${id }
    <%-- ${loginInfo.id 	} --%>
    <form action="id.sbox" method="post">
    	<input type="text" name="id">
    	<input type="submit" value="id세션값 만들기">
    </form>
    
    <input type="button" value="iddelete" onclick="idDelete()"><br>
    대련님<input type="button" value="id" onclick="userList()"><br>
    시현님<input type="button" value="shopList" onclick="shopList()"><br>
    세미님<input type="button" value="notice" onclick="gocum()"><br>
    성찬님<input type="button" value="login" onclick="login()"><br>
    
    
    <form action="benList.ben">
    	num : <input type = "text" id = "num"> <br>
    	id : <input type = "text" id="id"> <br>
    	<input type="button" value="신고해보기" onclick="report()"> <br> 
    </form>
    
    
    <input type="button" value="범죄자리스트" onclick="location.href='benLists.ben'"><br>
    
    <input type="button" value="커뮤니티" onclick="location.href='List.cmu'"><br>
    
    <input type="button" value="커뮤글쓰기" onclick="location.href='insertForm.cmu'"><br>
    
    <input type="button" value="장바구니" onclick="location.href='shopboxlist.sbox'"><br>
    
    <input type="button" value="qna" onclick="location.href='shopboxlist.sbox'"><br>
    
    