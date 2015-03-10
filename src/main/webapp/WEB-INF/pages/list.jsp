<%@ page language="java" contentType="text/html; charset=UTF-8"  
 pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>CurrencyFair Message Processor | Currency Transactions</title>  
</head>  
<body>  
 <center>  
  
  <div style="color: teal; font-size: 30px">CurrencyFair Message Processor </div>  
  
  <c:if test="${!empty transactionList}">  
   <table border="1" bgcolor="black" width="600px">  
    <tr  
     style="background-color: teal; color: white; text-align: center;"  
     height="40px">  
       
     <td>User ID</td>  
     <td>From</td>  
     <td>To</td>  
     <td>Amount Sell</td>  
     <td>Amount Buy</td>  
     <td>Rate</td>
     <td>Time</td>
     <td>Country</>  
    </tr>  
    <c:forEach items="${transactionList}" var="transaction">  
     <tr  
      style="background-color: white; color: black; text-align: center;"  
      height="30px">  
        
      <td><c:out value="${transaction.userId}" />  
      </td>  
      <td><c:out value="${transaction.currencyFrom}" />  
      </td>  
      <td><c:out value="${transaction.currencyTo}" />  
      </td>  
      <td><c:out value="${transaction.amountSell}" />  
      </td>
      <td><c:out value="${transaction.amountBuy}" />  
      </td>
      <td><c:out value="${transaction.rate}" />  
      </td> 
      <td><c:out value="${transaction.timePlaced}"/>  
      </td> 
      <td><c:out value="${transaction.originatingCountry}" />  
      </td>  
     </tr>  
    </c:forEach>  
   </table>  
  </c:if>  
 </center>  
</body>  
</html>  