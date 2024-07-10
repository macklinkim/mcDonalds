<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.customer ne null || sessionScope.employee ne null}"> 
<form action = "regBoardProc" method="post">
<table border="1">
<tr><th>글쓴이</th><td>${customer.getId() }<input type = "hidden" name = "writer" value = "${customer.getId() }" ></td></tr>
<tr><th>제목</th><td><input type = "text" name = "title"></td></tr>
<tr><th>내용</th><td><textarea rows="5" cols="30" name = "content"></textarea></td></tr>
<tr><td colspan="2" align="right"><input type = "submit" value = "글작성하기"><input type = "reset" value = "취소하기"></td></tr>
</table>

</form>
</c:if>
<a href="/emcdonald/main.jsp"><button>메인으로 돌아가기</button></a>
</body>
</html>