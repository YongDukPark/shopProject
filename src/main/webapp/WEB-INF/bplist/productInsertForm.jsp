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

	var f_selbox = new Array('남자', '여자');

	var s_selbox = new Array();
	s_selbox[0] = new Array('상의', '하의', '신발');
	s_selbox[1] = new Array('상의', '하의', '신발');
	
	var t_selbox = new Array();
	//남자 상의,하의,신발
	t_selbox[0] = new Array('L', 'XL', '2XL');
	t_selbox[1] = new Array('29', '30', '31');
	t_selbox[2] = new Array('250', '260', '270');
	//여자 상의,하의,신발,원피스
	t_selbox[3] = new Array('S', 'M', 'L');
	t_selbox[4] = new Array('26', '27', '28');
	t_selbox[5] = new Array('220', '230', '240');
	

	function init(f){
		// body 로드되자마자 호출해서 gender에 옵션 value값이 들어가도록 해야 함(category는 아직 ㄴㄴ)
		for(var i=0; i<f_selbox.length; i++){
			document.forms[0].gender.options[i+1] = 	
						new Option(f_selbox[i], f_selbox[i]);	
			// form의 0번방(여기서 form은 하나뿐이므로 0번방!)에 있는 gender에 0+1, 1+1, 2+1..(i+1)번 방에 옵션을 추가해라(text, value)
				// myform을 f로 받았으므로 f.gender.options[i+1] 해도 됨
		}
	}
	
	function firstChange(f){ 
		
		var index = f.first.selectedIndex;	
		var text = f.first.options[index].value;
		
		for(var i=f.category.length; i>0; i--){	
			f.second.options[i]=null;	
		}
		
		for(var i=0; i<s_selbox[index-1].length; i++) {
			f.second.options[i+1] = new Option(s_selbox[index-1][i]); 
			}
		
	}
		
	
	function secondChange(f){ 
		
		var index = f.category.selectedIndex;	// 선택한 category의 번호
		var index_gender = f.gender.selectedIndex;	// 선택한 gender의 번호
		var text = f.category.options[index].value;	// 선택한 항목의 이름
		
		for(var i=f.poption.length; i>0; i--){	
			// 기존에 추가된 옵션 지우기(0번째에는 '선택'이 들어있으므로 0 제외한 나머지만 지우기)
			f.poption.options[i] = null;	
		}
		
		for(var i=0; i<t_selbox[index-1].length; i++) {
			if(index_gender == 1){
				f.poption.options[i+1] = new Option(t_selbox[index-1][i]); 
			}
			else if(index_gender == 2){
				f.poption.options[i+1] = new Option(t_selbox[index+2][i]); 
				if(f.poption.options[i+1] == "undefined"){
					var value_poption = document.getElementById('poption');
					value_poption.options.remove(value_poption.length-1);
				}
			}
			// 해결못한 것 : 옵션에 공백까지 나오는거 어떻게 해결해야 하는지?
		}
	}
	
</script>


bplist\productInsertForm.jsp
<br>
<!-- BplistInsertController에서 처리함 -->

<br>

<body onLoad="init(myform)">

<h2>상품 등록</h2>
<form:form action="insert.blist" method="post" commandName="bplistBean"	
	enctype="multipart/form-data" name="myform" >
	
	<!-- 파일 업로드 시 : 1. 파일 업로드용 dependency 가져다놓기 v
	<!-- 파일 업로드 시 : 2. form에서 enctype="multipart/form-data" 추가 v -->
	<!-- 파일 업로드 시 : 3. post방식으로 요청할 것 v -->
	
	<p>
		상품 사진 
		<input type="file" name="upload" value="파일 선택"><br>
	</p>
	
	<p>
		상품명
		<input type="text" name="pname">
		<form:errors path="pname" cssClass="err"/>
		<br>
	</p>
	
	<p>
		카테고리
		<select name="gender" id="first"  style="width:100px;" onChange="firstChange(this.form)">
			<option value="">선택</option>
		</select>
		
		<select name="category" id="second" style="width:100px;" onChange="secondChange(this.form)">
			<option value="">선택</option>
		</select>
		<form:errors path="gender" cssClass="err"/>
		<form:errors path="category" cssClass="err"/>
	</p>
	
	<p>	
		옵션
		<select name="poption" id="third" style="width:100px;">
			<option value="">선택</option>
		</select>
		<form:errors path="poption" cssClass="err"/>
	</p>
	
	<p>
		가격 
		<input type="text" name="price">원 <br>
		</p>
	
	<p>
		재고 수량 
		<input type="text" name="stock">개 <br>
	</p>
	
	<!-- <p>
		상품 노출 여부 <br>
		<input type="radio" name="display" value="on">on<br>
		<input type="radio" name="display" value="off">off<br>
	</p> -->
	<input type="submit" value="추가하기"><br>


</form:form>
</body>