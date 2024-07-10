<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>  $(function() {    $( "#dialog" ).dialog();  });  </script>
</head>
<body><center>
<h1>회원가입</h1><hr>
<form:form method="post" action="customerRegResult" modelAttribute="customer" >
<label>아이디: </label><form:input path="id" required="required"/><br>
<div id="dialog" title="Basic dialog">
  <p>이미 등록된 아이디 입니다.</p>
</div>
<label>비밀번호: </label><form:input type="password" path="password" required="required"/><br>
<label>이름: </label><form:input path="name" required="required"/><br>
<label>연락처: </label><form:input path="phone" required="required"/><br>
<label>주소: </label><form:input path="address" required="required"/><br>
<form:button type="submit">등록</form:button><button type="reset">다시작성</button>
</form:form>
</center>
</body>
</html>