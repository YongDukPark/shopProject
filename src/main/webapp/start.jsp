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
    
   <!--  �ڿ�<input type="button" value="test" onclick="go()"><br>
    �ڿ�<input type="button" value="testlist" onclick="togo()"><br> -->
    �ڿ�<input type="button" value="orderList" onclick="OrderList()"><br>
    
    ���� ���ǰ� : ${id }
    <%-- ${loginInfo.id 	} --%>
    <form action="id.sbox" method="post">
    	<input type="text" name="id">
    	<input type="submit" value="id���ǰ� �����">
    </form>
    
    <input type="button" value="iddelete" onclick="idDelete()"><br>
    ��ô�<input type="button" value="id" onclick="userList()"><br>
    ������<input type="button" value="shopList" onclick="shopList()"><br>
    ���̴�<input type="button" value="notice" onclick="gocum()"><br>
    ������<input type="button" value="login" onclick="login()"><br>
    
    
    <form action="benList.ben">
    	num : <input type = "text" id = "num"> <br>
    	id : <input type = "text" id="id"> <br>
    	<input type="button" value="�Ű��غ���" onclick="report()"> <br> 
    </form>
    
    
    <input type="button" value="�����ڸ���Ʈ" onclick="location.href='benLists.ben'"><br>
    
    <input type="button" value="Ŀ�´�Ƽ" onclick="location.href='List.cmu'"><br>
    
    <input type="button" value="Ŀ�±۾���" onclick="location.href='insertForm.cmu'"><br>
    
    <input type="button" value="��ٱ���" onclick="location.href='shopboxlist.sbox'"><br>
    
    <input type="button" value="qna" onclick="location.href='shopboxlist.sbox'"><br>
    
    