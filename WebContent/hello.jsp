<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="controller.TransactionDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body style="background-color: #D6EAF8;">

	<%
		ArrayList<Integer> res = (ArrayList<Integer>) request.getAttribute("TransactionDAO");
	%>
	<h3 id="head" align="center">
		Current Account Balance :
		<%
		out.print(res.get(0));
	%>
	</h3>

	<h3 id="head" align="center" style="margin-top: 4%;">Your Last 5
		transactions are:</h3>

	<%
		for (int i = 0; i <= res.size() - 1; i++) {
	%>
	<h5 id="head" align="center">
		<%
			out.println((i + 1 ) +". Amount has been transferred successfully." + " Remaining balance : " + res.get(i));
		%>
		<br>
		<%
			}
		%>
	</h5>
</body>
</html>
