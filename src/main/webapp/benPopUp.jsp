<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./WEB-INF/common/common.jsp" %>

<% 
	String num = request.getParameter("num");
	String id = request.getParameter("id");
	String userId = (String)session.getAttribute("id");
	
	String[] category = {"불쾌감을 주는글", "부적절한 글", "혼란을 주는 글", "목적에 맞지않는글", "선정적"};
	
%>

<h3><b>신고하기</b></h3>
	<form:form commandName="report" action="report.ben" method="post">
	
		<input type = "hidden" name="num" value = "<%=num%>">
		<input type = "hidden" name="id" value = "<%=id%>">
		<!-- <input type = "hidden" name="type" value = ""> -->
		
		<!-- type 글에서 넘기기 shop인지 cmu인지 -->
	
		<table border=1>
			<tr>
				<td width="15%">신고자</td>
				<td width="35%"><%=userId %></td>
				<td width="15%">작성자</td>
				<td width="35%"><%=id %></td>
			</tr>
			<tr>	
				<td width="15%">
					사유선택
				</td>
				<td colspan="3" width="85%" align="left">
					<select name="bencategory">
							<option value = "">선택</option>
						<%for(int i=0;i<category.length;i++){ %>
							<option value = "<%=category[i]%>"><%=category[i]%></option>
						<%} %>
					</select>
					<form:errors cssClass="err" path="bencategory" />
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea rows="8" cols="60" name="reason" style="resize: none;"></textarea>
					<form:errors cssClass="err" path="reason" />
				</td>
			</tr>
			<tr align="center">
				<td colspan="4">
					<input type = "submit" value="신고">
					<input type = "reset" value="다시쓰기">
					<input type = "button" value="닫기" onclick="window.close()">
				</td>
			</tr>
		</table>
	</form:form>

