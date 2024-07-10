<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글</title>
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" />
<style>
.table-hover tbody tr:hover td,.table-hover tbody tr:hover th {
	background-color: yellow;
}
fieldset{
	padding-left: 15%;
	padding-right: 15%; 
}
</style>
</head>
<body>
	<div class="span12" align="center">
<c:if test="${sessionScope.customer ne null || sessionScope.employee ne null}"> 
		<hr/>
		<c:choose>
			<c:when test="${board.content ne ' ' }">
<h1 align="center" > 게시물 내용</h1>
<table width="413">
     <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">글번호</td>
      <td width="319">${board.no}</td>
      <td width="0">&nbsp;</td>
     </tr>
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">조회수</td>
      <td width="319">${board.count}</td>
      <td width="0">&nbsp;</td>
     </tr>
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">이름</td>
      <td width="319">${board.id}</td>
      <td width="0">&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">작성일</td>
      <td width="319">${board.wdate}</td>
      <td width="0">&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">제목</td>
      <td width="319">${board.title}</td>
      <td width="0">&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
                <tr>
      <td width="0"></td>
      <td align="center" width="76">내용</td>
                   <td width="399" colspan="2" height="200">${board.content}
                </tr>
            <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
					</table>
					







				<table class="table table-bordered table-hover table-condensed table-striped">
				<thead>
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
			</thead>
					<c:forEach var="comm" items="${ commList}">
		<tbody>
						<tr>
							<th>${comm.mid }</th>
							<td>${comm.content }</td>
							<td>${comm.wdate }</td>
							<c:if test="${customer.getId() eq comm.mid }">
							<td><a href="../deleteComm/${comm.rno }"><button>[x]</button></a>
							</td>
							</c:if>
						</tr>
					</c:forEach>
					</tbody>
				</table>

				<form action="../comment/${board.no}">
					<table>
						<tr>
							<th>작성자</th>
							<td>
							<input type="text" value="${customer.getId()}" disabled="disabled" />
							<input type="hidden" value="${customer.getId()}" name ="id"  />
							</td>
							
							<th>뎃글 내용</th>
							<td><input type="text" name="content" required="required" /></td>
							<td><input type="submit" value="뎃글쓰기"></td>
						</tr>

					</table>
				</form>
				<c:if test="${customer.getId() eq board.id }">
				<a href="delete/${board.no}"><button class="btn">글 삭제하기</button></a>
				<a href="update/${board.no}"><button class="btn">글 수정하기</button></a>
				</c:if>
			</c:when>
			<c:otherwise>
				<h1 align="center">삭제된 게시글입니다.</h1>
			</c:otherwise>
		</c:choose>
		<a href="../1"><button class="btn">게시판으로</button></a>
		</c:if>
		<a href="/emcdonald/main.jsp"><button class="btn">메인으로 돌아가기</button></a>
		
	</div>
	
</body>
</html>