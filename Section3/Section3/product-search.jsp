<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="bean.*,java.util.*"
  %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<% List<Product> list=(List<Product>)request.getAttribute("list");%>

<!DOCTYPE html>
<html>
<meta charset="charset=UTF-8">
<style>
td, th {
	border: 1px solid #000000;
}

table {
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
	margin-top: auto;
}
</style>
<head>
</head>
<body style="border: solid 1px;">
	<h1>商品検索</h1>
	<div style="text-align: center;">
		<form method="POST" action="./productServlet"
			style="margin-bottom: 100px">
			<label style="padding-right: 30px;">商品名</label> <input type="text"
				name="message" style="width: 200px">
			<button type="submit">検索</button>
		</form>
	</div>
	<%

	%>
	<table>
		<tr>
			<th>商品コード</th>
			<th style="width: 200px">商品名</th>
			<th>単価</th>
			<th>操作</th>
		</tr>

		<%for (Product product : list) {%>

		<tr>
			<td><%=product.getProduct_code()%></td>
			<td><%=product.getProduct_name()%></td>
			<td><%=product.getprice()%></td>
			<td><a href="#">編集</a></td>
		</tr>

		<%}%>
	</table>

</body>
</html>