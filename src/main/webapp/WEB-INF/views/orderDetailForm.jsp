<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>MC_DONALD 메뉴선택 창입니다.</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#menu" ).selectmenu();
 
    $( "#amount" ).selectmenu();
 
    $( "#option" )
      .selectmenu()
      .selectmenu( "menuWidget" )
        .addClass( "overflow" );
  });
  </script>
  <style>
    fieldset {
      border: 0;
    }
    label {
      display: block;
      margin: 30px 0 0 0;
    }
    select {
      width: 200px;
    }
    .overflow {
      height: 200px;
    }
  </style>
</head>
<body>
 
<div class="demo">
<img src="image/cheese.PNG">
<img src="image/bigmac.PNG">
<img src="image/btd.PNG">
<img src="image/bgg.PNG">
<img src="image/ck.PNG">
 <form:form action="orderdetailform" method="post" modelAttribute="orderdetail">

  <fieldset>
    <label for="menu">버거 세트</label>
    <select name="menu" id="menu">
      <option selected="selected">1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
    </select>
 
    <label for="option">추가 메뉴</label>
    <select name="option" id="option">
      <optgroup label="음료">
        <option value="jquery">jQuery.js</option>
        <option value="jqueryui">ui.jQuery.js</option>
      </optgroup>
      <optgroup label="디저트">
        <option value="somefile">Some unknown file</option>
        <option value="someotherfile">Some other file with a very long option text</option>
      </optgroup>
    </select>
 
    <label for="amount">수량</label>
    <select name="amount" id="amount">
      <option selected="selected">1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
      <option>6</option>
      <option>7</option>
      <option>8</option>
      <option>9</option>
      <option>10</option>
    </select>
  </fieldset>
 <input type="text" name="order_code" value="${order.code}">
 <br>
 <input type="submit" value="주문하기">
</form:form>
 
</div>
 
 
</body>
</html>