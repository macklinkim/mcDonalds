<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회 원 가 입</h1><hr>
	<form:form method="post" action="employeeRegResult" modelAttribute="employee">
		<table>
			<tr><th>ID</th><td><form:input type="text" path="id" required="required"/></td></tr>
			<tr><th>PW</th><td><form:input type="password" path="password" required="required"/></td></tr>
			<tr><th>이름</th><td><form:input type="text" path="name" required="required"/></td></tr>
			<tr><th>직급</th><td><form:input type="text" path="position" required="required"/></td></tr>
			<tr><th>부서</th><td><form:input type="text" path="dept" required="required"/></td></tr>
			<tr><th>전화번호</th><td><form:input type="text" path="phone" required="required"/></td></tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록"><input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>