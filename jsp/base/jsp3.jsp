<%@ page contentType="text/html;charset=utf-8" import="java.io.*"%>

<!DOCTYPE html>
<html>
	<head>
		<title>EL</title>
		<meta charset="utf-8">
	</head>
	<body style="text-align:center">

		<h2> EL </h2>
<%
        request.setAttribute("obj", new String("졸립죠?"));
        session.setAttribute("user", new String("홍길동")); //at Controller 
        session.setAttribute("obj", new String("괜찮아요")); //at Controller 
%>
        <!-- EL사용결과: ${requestScope.obj} 가 생략되고 obj만 있어도된다. -->
        <%
        String result =  (String)request.getAttribute("obj");
           //ut.println(result);
        %>
        Scripting Elements!!: <%=result%> <br/>
        EL사용결과1: ${obj} <br/>
		EL사용결과2: ${sessionScope.user}
	</body>
</html>