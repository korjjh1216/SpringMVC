<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sp01 index</title>
</head>
<body style="text-align:center">
	<h1> Sp01 Index </h1>
	
	<p>
		<a href="/test/">m01</a> <br/>
		<a href="/test/base1">m02</a> <br/>
		<a href="/test/base2">m03</a> <br/>
		<a href="/test/base3">m04</a> <br/>
		<a href="/test/form">form</a> <br/>
	</p>
	
	<p>
		<a href="/test/param1?name=홍길동&age=20">m05</a> <br/>
		<a href="/test/param2?name=슬기&age=24">m06</a> <br/>
		<a href="/test/param3?names=슬기&names=정현&names=다은">m07</a> <br/>
		<a href="/test/param4?ns=슬기2&ns=정현2&ns=다은2">m08</a> <br/>
		<a href="/test/param5?names=슬기3&names=정현3&names=다은3">m09</a> <br/>
	</p>
	
	<p> 
	    <!-- 
	    <a href="/test/param6?list[0].name=홍길동&list[0].age=20&list[1].name=이순신&list[1].age=30">m10</a> <br/>
	    [ -> %5B
	    ] -> %5D
	    -->
	    <a href="/test/param6?list%5B0%5D.name=홍길동&list%5B0%5D.age=20&list%5B1%5D.name=이순신&list%5B1%5D.age=30">m10</a> <br/>
	    <a href="/test/param7?name=슬기&age=24&page=3">m11</a> <br/>
	</p>
	
	<p>
	    <a href="/test/json1">m12</a> <br/>
	    <a href="/test/json2">m13</a> <br/>
	    <a href="/test/txt">m14</a> <br/>
	</p>
	
</body>
</html>