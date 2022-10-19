<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center>

    <form action="cmtInsert.blist" method="post" commandName="BpcmtBean"
   	 enctype="multipart/form-data" name="myform" >
    	
    	<table border="1">
    	<tr>
	    	<td align="center">작성자</td>
	    	<td><input type="text" name="id"></td>
			<td align="center" rowspan="4">
   				<input type="submit" value="등록하기">
			</td>
    	</tr>
		<tr>
	    	<td align="center">내용</td>
		    <td>
			   	<textarea rows="5" name="content"></textarea>
			</td>
		</tr>	    	
		<tr>
	    	<td align="center">첨부파일</td>
		    <td>
		   		<input type="file" name="upload" value="파일 선택"><br>
			</td>
		</tr>

    	</table>
    	
    </form>

</center>
