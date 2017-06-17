<%-- 
    Document   : productMaint
    Created on : Jun 7, 2017, 7:22:15 PM
    Author     : Manikanth
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Product Maintenance </title>
        <style>
        table, td, th {
            border: 1px solid black;
        }
        table {
            border-collapse: collapse;
            width: 50%;
        }
        

        th {
              text-align: left;
        }
        </style>
    </head>
    <body>
        
        <p> <font color="00bfff" size="5"><strong> Products </strong></font></p>
        <table>
              <tr>
                <th> Code </th>
                <th> Description </th>
                <th> Price </th>
                <th></th>
                <th></th>
            </tr>
        
<!--        <c:forEach var="productlist" items="${productlist}">
        <tr>
            <td><c:out value="${productlist.code}" /></td>
            <td><c:out value="${productlist.description}" /></td>
            <td>$<c:out value="${productlist.price}" /></td>
            <td> <a href="Edit?edit=${productlist.code}"> Edit </a></td>
            <td> <a href="Delete?delete=${productlist.code}"> Delete </a> </td>
        </tr>
        </c:forEach>      
        </table> <br>
        <form action="addProduct" method="get">
        <input type="submit" value="Add Product">
        </form>
        <br>
        <br>
        <table>
         <tr>
         <th>Code</th>
         <th>Description</th>
         <th>Price</th>
         <th></th>
         <th></th>
         </tr>-->
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.code}</td>
            <td>${product.description}</td>
            <td>${product.getPriceCurrencyFormat()}</td>
            <td><a href="Edit?edit=${product.code}"> Edit </a></td>
            <td><a href="Delete?delete=${product.code}"> Delete </a></td>
        </tr>
        </c:forEach>
        </table>
        <br>
        <form action="addProduct" method="get">
        <input type="submit" value="Add Product">
    </body>
</html>


    
