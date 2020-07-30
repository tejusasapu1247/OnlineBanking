<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.TransactionDAO"%>
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
	<h3 id="head" align="center" style="margin-top: 4%;">
		<U>Your Last 5 transactions are: 
	</h3>
	</U>

	<%
		int j = 1;
		for (int i = res.size() - 1; i >= 0; i--) {
	%>
	<h5 id="head" style="margin-left: 31%;">
		<%
			out.println(j++ + ". 1000/- transferred successfully." + " Remaining balance : " + res.get(i));
		%>
		<br>
		<%
			}
		%>
		<body>

		</body>
</html>