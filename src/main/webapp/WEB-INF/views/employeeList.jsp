<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>아이디</th><th>비번</th><th>이름</th><th>포지션</th><th>부서</th><th>전화</th></tr>
<c:forEach var="employee" items="${employeeList}">
<tr><td>${employee.id}</td><td>${employee.password}</td><td>${employee.name}</td>
<td>${employee.position}</td><td>${employee.dept}</td><td>${employee.phone}</td></tr>
</c:forEach>
</table>
</body>
</html>