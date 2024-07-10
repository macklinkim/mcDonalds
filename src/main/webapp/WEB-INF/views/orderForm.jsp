<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="order" method="post" modelAttribute="orderform">
<label>상품번호<form:input path="code"/></label>
<br>
<label>고객명<form:input path="customer_id"/></label>
<br>
<label>주문날짜<input type="text" name="order_date"></label>
<br>
<label>가격<form:input path="total_price"/></label>
<br>
<label>배달유무<form:input path="delevery"/></label>
<br>
<input type="submit" value="주문">
</form:form>

</body>
</html>