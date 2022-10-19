<%@page import="cmunity.model.cmunityBean"%>
<%@page import="org.springframework.context.annotation.Bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp" %>

<%
	cmunityBean bean = (cmunityBean)request.getAttribute("bean");
%>
	
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	
	//alert(1);
	
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
		alert(1);
		
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
		}
	}
	
	
	
	
	
	
	
	
	$.fn.setPreview = function(opt){
	    "use strict"
	    var defaultOpt = {
	        inputFile: $(this),
	        img: null,
	        w: 250,
	        h: 250
	    };
	    $.extend(defaultOpt, opt);
	
	    var previewImage = function(){
	        if (!defaultOpt.inputFile || !defaultOpt.img) return;
	
	        var inputFile = defaultOpt.inputFile.get(0);
	        var img       = defaultOpt.img.get(0);
	
	        // FileReader
	        if (window.FileReader) {
	            // image 파일만
	            if (!inputFile.files[0].type.match(/image\//)) return;
	
	            // preview
	            try {
	                var reader = new FileReader();
	                reader.onload = function(e){
	                    img.src = e.target.result;
	                    img.style.width  = defaultOpt.w+'px';
	                    img.style.height = defaultOpt.h+'px';
	                    img.style.display = '';
	                }
	                reader.readAsDataURL(inputFile.files[0]);
	            } catch (e) {
	                // exception...
	            }
	        // img.filters (MSIE)
	        } else if (img.filters) {
	            inputFile.select();
	            inputFile.blur();
	            var imgSrc = document.selection.createRange().text;
	
	            img.style.width  = defaultOpt.w+'px';
	            img.style.height = defaultOpt.h+'px';
	            img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";            
	            img.style.display = '';
	        // no support
	        } else {
	            // Safari5, ...
	        }
	    };
	
	    // onchange
	    $(this).change(function(){
	        previewImage();
	    });
	};
	
	
	$(document).ready(function(){
	    var opt = {
	        img: $('#img_preview'),
	        w: 250,
	        h: 250
	    };
	
	    $('#imges').setPreview(opt);
	});
	
	$(document).ready(function() {
	
		$('#plus').click(function(){
			//alert(1);
			$('#table').show(300);
		});
			
		
		$('#cancel').click(function(){
			//alert(1);
			$('#table').hide(300);
		});
	});
	
	
	function insert() {
		
		if(document.myform.upload.value.length==0){
			alert("이미지 넣어주세요");
			return false;
		}
		
		
		if(document.myform.subject.value.length==0){
			alert("제목을 입력하세요");
			document.myform.subject.select();
			return false;
		}
		
		if(document.myform.content.value.length==0){
			alert("내용은 한글자라도 입력하세요");
			document.myform.content.select();
			return false;
		}
		
		if(document.myform.pname.value.length==0){
			alert("상품명을 입력하세요");
			document.myform.pname.select();
			return false;
		}
		
		if(document.myform.gender.value.length==0){
			alert("성별을 선택해주세요");
			return false;
		}
		
		if(document.myform.category.value.length==0){
			alert("카테고리를 선택해주세요");
			return false;
		}
		
		if(document.myform.poption.value.length==0){
			alert("사이즈를 선택하세요");
			return false;
		}
		
		if(document.myform.price.value.length==0){
			alert("가격을 입력해주세요.");
			document.myform.price.select();
			return false;
		}
		
		if(isNaN(document.myform.price.value)){ //abc => true, 123 => false
			alert('가격에는 숫자만 입력해주세요 (ex 5000,8000)');
			document.myform.price.select();
			return false;
		}
		
		if(document.myform.stock.value.length==0){
			alert("수량을 입력하세요");
			document.myform.stock.select();
			return false;
		}
		
		if(isNaN(document.myform.stock.value)){ //abc => true, 123 => false
			alert('재고는 숫자만 입력해주세요 (ex 500,800)');
			document.myform.stock.select();
			return false;
		}
		
		document.myform.submit();
	}
	
	
	</script>
<body onLoad="init(f)">
	<form action="cmunityUpdate.cmu" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td rowspan="5" width="220" height="220">
					<img src="<%=request.getContextPath() %>/resources/${bean.img}" width="300px" height="300px" /><br>
					<input type="file" name="upload" value=""/> <!-- 새로운 이미지 -->
					<input type="text" name="img" value="${bean.img }">	
					<input type="hidden" name="num" value="${bean.num }">	
				</td>
			</tr>
			<tr>
				<th>
					작성자
				</th>
				<td>
					<%=session.getAttribute("id") %>
				</td>
			</tr>
			<tr>
				<th>
					제목
				</th>
				<td>
					<input type="text" name="subject" placeholder="제목입력" value="${bean.subject }">	
				</td>
			</tr>
			<tr>
				<th>
					내용
				</th>
				<td>
					<textarea name="content" rows="8" cols="30" style="resize: none;">${bean.content }</textarea>
				</td>
			</tr>
			
		</table>
		
		<table id="table">
			<tr>
				<td>상품명:</td>
				<td><input type="text" name="pname" placeholder="상품명을 입력하세요" value="${bean.pname }"></td>
			</tr>
			<tr>
				<td>카테고리:</td>
				<td>
					<select name="gender" id="first"  style="width:100px;" onChange="firstChange(this.form)">
						<option value="">선택</option>
						<option value="남자">남자</option>
						<option value="여자">여자</option>
					</select>
		
					<select name="category" id="second" style="width:100px;" onChange="secondChange(this.form)">
						<option value="">선택</option>
					</select>
					
					<select name="poption" id="third" style="width:100px;">
						<option value="">선택</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>가격:</td>
				<td>
					<input type="text" name="price" placeholder="가격을 입력하세요" value="${bean.price }">
				</td>
			</tr>
			<tr>
				<td>재고:</td>
				<td>
					<input type="text" name="stock" placeholder="재고량을 입력하세요" value="${bean.stock }">
				</td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td>
					<input type="button" value="수정하기" onclick="insert()">
				</td>
			</tr>
		</table>
	</form>
</body>