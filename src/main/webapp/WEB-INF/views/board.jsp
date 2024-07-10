<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<%
	request.setCharacterEncoding("UTF-8");
	int cnt = 0;
%>
<head>

<meta charset="UTF-8">
<title>게시판 서비스</title>
<link href="Bootstrap/css/bootstrap.css" rel="stylesheet" />
<style>
.table-hover tbody tr:hover td,.table-hover tbody tr:hover th {
	background-color: yellow;
}

select {
	width: 100px;
	background-color: #ffffff;
	border: 1px solid #cccccc;
}
</style>
</head>
<body>

	<div class="span12">
		<c:if
			test="${sessionScope.customer ne null || sessionScope.employee ne null}">
			<hr />

			<table
				class="table table-bordered table-hover table-condensed table-striped">
				<caption>손님 게시판</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${boardList}">

						<tr>
							<td>${list.no}</td>

							<td><a href="detail/${list.no}">
									${list.title}[${list.reply}] </a></td>
							<td>${list.id}</td>
							<td>${list.count}</td>
							<td>${list.wdate}</td>
						</tr>
					</c:forEach>

					<tr>
						<td colspan="5" align="center" valign="middle"><a href="1"><button
									class="btn">첫페이지로</button></a> <a href="${(page>1)?page-1:page }">
								<button class="btn">[<<]</button>
						</a> <a href="${(list.no==1)?page:page+1 }">
								<button class="btn">[>>]</button>
						</a></td>
					</tr>

				</tbody>
			</table>

			<form action="searchBoard">
				<select name="column">
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
					<option value="WRITER">글쓴이</option>
				</select>
				<div class="input-append">
					<input class="span2" id="appendedInputButtons" type="text"
						name="target"> <input class="btn" type="submit"
						value="검색하기">


				</div>

			</form>

			<a href="regBoard"><button id="appendedInputButtons" class="btn">글쓰기</button></a>
		</c:if>
		<a href="/emcdonald/main.jsp"><button class="btn"
				id="appendedInputButtons">메인으로 돌아가기</button></a>
	</div>




</body>
</html>