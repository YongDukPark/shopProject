<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <table border="1">
    	<tr>
    		<td>
    			<table>
    				<tr><th colspan="5">추천 글</th></tr>
    				<tr>
    					<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
    				</tr>
    					<!-- if 경우에 따라 넣어야함 -->
	    				<tr>
	    					<td>${like[0].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${like[0].num }"><font style="color: gray;">[${like[0].gender }][${like[0].category }]</font>${like[0].subject }<font style="color: red;">[${like[0].likecount }]</font></a>
	    					</td>
	    					<td>${like[0].id }</td>
	    					<td>${like[0].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${like[1].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${like[1].num }"><font style="color: gray;">[${like[1].gender }][${like[1].category }]</font>${like[1].subject }<font style="color: red;">[${like[1].likecount }]</font></a>
	    					</td>
	    					<td>${like[1].id }</td>
	    					<td>${like[1].readcount }</td>
	    				</tr>
	    				<c:if test="${like[2].num != '' }">
		    				<tr>
		    					<td>${like[2].num }</td>
		    					<td>
		    						<a href="detail.cmu?num=${like[2].num }"><font style="color: gray;">[${like[2].gender }][${like[2].category }]</font>${like[2].subject }<font style="color: red;">[${like[2].likecount }]</font></a>
		    					</td>
		    					<td>${like[2].id }</td>
		    					<td>${like[2].readcount }</td>
		    				</tr>
		    			</c:if>
	    				<tr>
	    					<td>${like[3].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${like[3].num }"><font style="color: gray;">[${like[3].gender }][${like[3].category }]</font>${like[3].subject }<font style="color: red;">[${like[3].likecount }]</font></a>
	    					</td>
	    					<td>${like[3].id }</td>
	    					<td>${like[3].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${like[4].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${like[4].num }"><font style="color: gray;">[${like[4].gender }][${like[4].category }]</font>${like[4].subject }<font style="color: red;">[${like[4].likecount }]</font></a>
	    					</td>
	    					<td>${like[4].id }</td>
	    					<td>${like[4].readcount }</td>
	    				</tr>
    				
    			</table>
    		</td>
    	
    		<td>
    			<table>
    				<tr><th>쇼핑몰으로</th></tr>
    				<tr>
    					<th><img src="${pageContext.request.contextPath}/resources/샘플2.png" onclick="location.href=''" width="200" height="200"> </th>
    				</tr>
    				
    			</table>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<table>
    				<tr><th colspan="5">여성 화제의 글</th></tr>
    				<tr>
    					<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
    				</tr>
    				
    					<tr>
	    					<td>${girl[0].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${girl[0].num }"><font style="color: gray;">[${girl[0].gender }][${girl[0].category }]</font>${girl[0].subject }<font style="color: red;">[${girl[0].likecount }]</font></a>
	    					</td>
	    					<td>${girl[0].id }</td>
	    					<td>${girl[0].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${girl[1].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${girl[1].num }"><font style="color: gray;">[${girl[1].gender }][${girl[1].category }]</font>${girl[1].subject }<font style="color: red;">[${girl[1].likecount }]</font></a>
	    					</td>
	    					<td>${girl[1].id }</td>
	    					<td>${girl[1].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${girl[2].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${girl[2].num }"><font style="color: gray;">[${girl[2].gender }][${girl[2].category }]</font>${girl[2].subject }<font style="color: red;">[${girl[2].likecount }]</font></a>
	    					</td>
	    					<td>${girl[2].id }</td>
	    					<td>${girl[2].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${girl[3].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${girl[3].num }"><font style="color: gray;">[${girl[3].gender }][${girl[3].category }]</font>${girl[3].subject }<font style="color: red;">[${girl[3].likecount }]</font></a>
	    					</td>
	    					<td>${girl[3].id }</td>
	    					<td>${girl[3].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${girl[4].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${girl[4].num }"><font style="color: gray;">[${girl[4].gender }][${girl[4].category }]</font>${girl[4].subject }<font style="color: red;">[${girl[4].likecount }]</font></a>
	    					</td>
	    					<td>${girl[4].id }</td>
	    					<td>${girl[4].readcount }</td>
	    				</tr>
    				
    			</table>
    		</td>
    		
    		<td>
    			<table>
    				<tr><th colspan="5">남성 화제의 글</th></tr>
    				<tr>
    					<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>추천수</th>
						<th>조회수</th>
    				</tr>
    				
    					<tr>
	    					<td>${men[0].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${men[0].num }"><font style="color: gray;">[${men[0].gender }][${men[0].category }]</font>${men[0].subject }<font style="color: red;">[${men[0].mencount }]</font></a>
	    					</td>
	    					<td>${men[0].id }</td>
	    					<td>${men[0].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${men[1].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${men[1].num }"><font style="color: gray;">[${men[1].gender }][${men[1].category }]</font>${men[1].subject }<font style="color: red;">[${men[1].mencount }]</font></a>
	    					</td>
	    					<td>${men[1].id }</td>
	    					<td>${men[1].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${men[2].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${men[2].num }"><font style="color: gray;">[${men[2].gender }][${men[2].category }]</font>${men[2].subject }<font style="color: red;">[${men[2].mencount }]</font></a>
	    					</td>
	    					<td>${men[2].id }</td>
	    					<td>${men[2].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${men[3].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${men[3].num }"><font style="color: gray;">[${men[3].gender }][${men[3].category }]</font>${men[3].subject }<font style="color: red;">[${men[3].mencount }]</font></a>
	    					</td>
	    					<td>${men[3].id }</td>
	    					<td>${men[3].readcount }</td>
	    				</tr>
	    				<tr>
	    					<td>${men[4].num }</td>
	    					<td>
	    						<a href="detail.cmu?num=${men[4].num }"><font style="color: gray;">[${men[4].gender }][${men[4].category }]</font>${men[4].subject }<font style="color: red;">[${men[4].mencount }]</font></a>
	    					</td>
	    					<td>${men[4].id }</td>
	    					<td>${men[4].readcount }</td>
	    				</tr>
    				
    			</table>
    		</td>
    	</tr>
    	
    	
    </table>
    