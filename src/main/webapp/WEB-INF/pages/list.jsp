<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CurrencyFair Message Processor | Currency Transactions</title>
<link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/list.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />"></script>
<script type='text/javascript' src='https://www.google.com/jsapi'></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>

	<h1>CurrencyFair Message Processor</h1>

	<c:if test="${!empty transactionList}">
		<table class="rwd-table">
			<tr>
				<th>User ID</th>
				<th>From</th>
				<th>To</th>
				<th>Amount Sell</th>
				<th>Amount Buy</th>
				<th>Rate</th>
				<th>Time</th>
				<th>Country</>
			</tr>
			<c:forEach items="${transactionList}" var="transaction">
				<tr>
					<td data-th="User ID"><c:out value="${transaction.userId}" /></td>
					<td data-th="From"><c:out value="${transaction.currencyFrom}" /></td>
					<td data-th="To"><c:out value="${transaction.currencyTo}" /></td>
					<td data-th="Amount Sell"><c:out value="${transaction.amountSell}" /></td>
					<td data-th="Amount Buy"><c:out value="${transaction.amountBuy}" /></td>
					<td data-th="Rate"><c:out value="${transaction.rate}" /></td>
					<td data-th="Time"><c:out value="${transaction.timePlaced}" /></td>
					<td data-th="Country"><c:out value="${transaction.originatingCountry}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	 <div id="chart_div"></div>
</body>
</html>
