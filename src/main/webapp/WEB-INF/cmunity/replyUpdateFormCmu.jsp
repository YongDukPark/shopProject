<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<form action="updatereply.cmu" method="post" enctype="multipart/form-data">
 	<input type="text" hidden="hidden" value="${replyBean.num}" name="num">  
 	<input type="text" hidden="hidden" value="${replenum}" name="replenum">
    <input type="file" name="upload" id="ifile" ><br>
    <textarea  name ="content">${replyBean.content}</textarea><br>
    <input type="submit" value="수정하기" onclick="filecheck()">
</form>