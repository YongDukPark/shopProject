<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<style type="text/css">
	.err{
	color: red;
	font-weight:bold;
	}
</style>

<script type="text/javascript">

	// gender
	var f_selbox = new Array('남자', '여자');

	// category	
	var s_selbox = new Array();
		s_selbox[0] = new Array('상의', '하의', '신발');
		s_selbox[1] = new Array('상의', '하의', '신발', '원피스');
	
	// poption
	var t_selbox = new Array();
		t_selbox[0] = new Array('M', 'L', 'XL', '2XL');
		t_selbox[1] = new Array('29', '30', '31');
		t_selbox[2] = new Array('250', '260', '270');
	
		t_selbox[3] = new Array('S', 'M', 'L');
		t_selbox[4] = new Array('26', '27', '28');
		t_selbox[5] = new Array('220', '230', '240');
		t_selbox[6] = new Array('FREE'); 

	////////////////////
	
	function init(f){
		
		genderValue = "${bpBean.gender}"; 

		for(var i=0; i<f_selbox.length; i++) {
 			f.gender.options[i+1] = new Option(f_selbox[i], f_selbox[i]);
 			
 			if(f_selbox[i] == genderValue){ // 넘어온 값(genderValue)과 i번째 방의 값이 같으면 i+1번째 옵션을 selected 하기 
 				document.forms[0].gender.options[i+1].selected = true;
 			}
		}
		firstChange(f);
	} // init
	
	////////////////////
	
	function firstChange(f){

		cateValue = "${bpBean.category}"; 
		
		var index = f.gender.selectedIndex;	
		var text = f.gender.options[index].value;

		for(var i=f.category.length; i>0; i--){
			f.category.options[i] = null;
		}
		
		for(var i=0; i<s_selbox[index-1].length; i++){
			f.category.options[i+1] = new Option(s_selbox[index-1][i]);
			if(s_selbox[index-1][i] == cateValue ){
				f.category.options[i+1].selected = true;
			}
		}
		secondChange(f);
	}//firstChange
	
	////////////////////
	
	function secondChange(f){

		optionValue = "${bpBean.poption}"; 
		
		var index = f.category.selectedIndex;	// 선택한 category의 번호
		var index_gender = f.gender.selectedIndex;	// 선택한 gender의 번호
		var text = f.category.options[index].value;	// 선택한 항목의 이름
		
		for(var i=f.poption.length; i>0; i--){	
			f.poption.options[i] = null;	
		}
		
		for(var i=0; i<t_selbox[index-1].length; i++) {
			
			if(index_gender == 1){
				f.poption.options[i+1] = new Option(t_selbox[index-1][i]); 
				if(t_selbox[index-1][i] == optionValue ){
					f.poption.options[i+1].selected = true;
				}
			}
			else if(index_gender == 2){
				f.poption.options[i+1] = new Option(t_selbox[index+2][i]); 
				if(t_selbox[index+2][i] == optionValue ){
					f.poption.options[i+1].selected = true;
				}
			}
		}
		
	} // firstChange	
	
</script>
	
<%  
	String[] displayArr = {"on", "off"};
%>    

productUpdateForm.jsp<br><br>

<body onLoad="init(myform)">
<h2>상품 수정</h2>

<form:form action="update.blist" method="post" commandName="bpBean" name="myform"
	enctype="multipart/form-data">
	
	<input type="hidden" name="num" value="${bpBean.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber }">
	
	<p>
		상품 사진 
		<input type="file" name="upload" value="${bpBean.upload}"><br>
	</p>
	
	
	<p>
		상품명 
		<input type="text" name="pname" value="${bpBean.pname}"><br>
		<form:errors path="pname" cssClass="err"/>	
	</p>
	
	
	<p>
		카테고리
	    <select name="gender" id="first" style="width:100px" onChange="firstChange(this.form)">
	    	<option value="">선택</option>
	    </select>
	    <select name="category" id="second" style="width:100px" onChange="secondChange(this.form)">
	    	<option value="">선택</option>
	    </select>
	    
	    <form:errors path="gender" cssClass="err"/>
		<form:errors path="category" cssClass="err"/>
		<br>
	</p>

	
	<p>
		옵션
	    <select name="poption" id="third" style="width:100px">
	    	<option value="">선택</option>
	    </select>
	    <form:errors path="poption" cssClass="err"/>
	    
		<br>
	</p>
	 
	 
	<p>
		가격
		<input type="text" name="price" value="${bpBean.price}"><br> 
	</p>
	
	
	<p>
		재고 수량
		<input type="text" name="stock" value="${bpBean.stock}">
		<br> 
	</p>
	
	<%-- <p>
		상품 노출 여부
		<c:forEach var="display" items="<%=displayArr %>">
			<input type="radio" name="display" value="${display }" <c:if test="${display eq bpBean.display }">checked</c:if> >${display }
		</c:forEach>
		<br>
	</p> --%>
	
	<p>
	<input type="submit" value="수정하기">
	</p>
	
</form:form>
</body>