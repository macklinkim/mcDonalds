<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주문리스트</title>
</head>
<body>
	<h1>주문리스트</h1><hr>
	<table border="1" style="text-align: center">
		<tr>
			<th>주문메뉴</th><th>주문량</th><th>가격</th><th>주문가격</th><th>세금</th><th>수입</th><th>날짜</th>
		</tr>
		<c:forEach var="emcdonald" items="${emcdonaldOrderlist}">
			<tr>
				<td><a href="emcdonaldDetail/${emcdonald.menu_name}">${emcdonald.menu_name}</a></td><td>${emcdonald.amount}</td>
				<td>${emcdonald.price}</td><td>${emcdonald.allprice}</td><td> ${emcdonald.tax}</td><td> ${emcdonald.revenue}</td>
				<td>${emcdonald.wdate}</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="2"></th><th>총가격</th><th>총주문가격</th><th>총세금</th><th>총수입</th><th>날짜</th>
		</tr>
		<tr>
		<td colspan="2">총합계</td>
		<c:set var ="price" value="0"/>
		<c:forEach var="emcdonald" items="${emcdonaldOrderlist}">
				<c:set var="price" value="${price + emcdonald.price}"/>	
		</c:forEach>
			<td><c:out value="${price}"></c:out></td>
		
		<c:set var ="allprice" value="0"/>
		<c:forEach var="emcdonald" items="${emcdonaldOrderlist}">
				<c:set var="allprice" value="${allprice + emcdonald.allprice}"/>	
		</c:forEach>
			<td><c:out value="${allprice}"></c:out></td>
			
		<c:set var ="tax" value="0"/>
		<c:forEach var="emcdonald" items="${emcdonaldOrderlist}">
				<c:set var="tax" value="${tax + emcdonald.tax}"/>	
		</c:forEach>
			<td><c:out value="${tax}"></c:out></td>
			
		<c:set var ="revenue" value="0"/>
		<c:forEach var="emcdonald" items="${emcdonaldOrderlist}">
				<c:set var="revenue" value="${revenue + emcdonald.revenue}"/>	
		</c:forEach>
			<td><c:out value="${revenue}"></c:out></td>
		</tr>	
	</table>
	<a href="emcdonaldOrder">[주문하기]</a>
</body>
</html>
