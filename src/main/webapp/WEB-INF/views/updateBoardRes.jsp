<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.customer ne null || sessionScope.employee ne null}"> 
<h1>업데이트 성공</h1>
<a href = "/emcdonald/main.jsp">돌아가기</a>
</c:if>
<a href="/emcdonald/main.jsp"><button>메인으로 돌아가기</button></a>
</body>
</html>