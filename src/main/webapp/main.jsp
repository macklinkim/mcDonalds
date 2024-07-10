<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {	background-image: url("image/mcdonaldMain.jpg");}
span {color: white;}
</style>
<title>E-맥도날드에 오신 것을 환영합니다.</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
</head>
<body>
	<div align="right">
	<c:if test="${sessionScope.customer eq null && sessionScope.employee eq null}">
		<
		<form action="login" method="POST">
			<label for="id"><span>아이디:</span></label><input type="text" name="id"/>
			<label for="password"><span>비밀번호:</span></label><input type="password" name="password"/> 
			<input type="submit" value="LOGIN">
		<span><a href="customerRegForm">회원가입</a></span>
		</form></c:if>
		<!--*******************고객용***************************************************  -->
		<c:if test="${sessionScope.customer ne null}"><span>로그인 된거가 
		<H1>${sessionScope.customer.name}님 로그인 성공.
		<div id="tabs">
						<ul>
							<li><a href="orderform">[주문하기]</a></li>
							<li><a href="1">[게시판]</a></li>
							<li><a href="logout">[로그아웃]</a></li>
						</ul>
					</div>
		</H1></span></c:if>
			<!--**********************************************************************  -->
		
			<!--*******************관리자용***********************************************  -->
		<c:if test="${sessionScope.employee ne null}"><span>관리자도 로그인 된거가 
		<H2>${sessionScope.employee.name}님 로그인 성공.
					<div id="tabs">
						<ul>
							<li><a href="employeeList">[직원목록]</a></li>
							<li><a href="employeeRegForm">[관리자등록]</a></li>
							<li><a href="emcdonaldOrderlist">[매출통계]</a></li>
							<li><a href="orderList">[주문보기]</a></li>
							<li><a href="menu">[메뉴보기]</a></li>
							<li><a href="logout">[로그아웃]</a></li>
						</ul>
					</div>
		</H2></span></c:if>
			<!--**************************************************************************  -->
	</div>
</body>
</html>