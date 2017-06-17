<%@ taglib prefix="mma" uri="/WEB-INF/requireMark.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
    </head>
    <body>
       <p> <font color="00bfff" size="5"><b> Product ${param.edit}</b></font></p>
       <p><mma:ifEmptyMark field=""/> marks required fields</p>
       <c:forEach items="${productList}" var="listLoop">
       <c:set var="compare" value="${param.edit}"/>
       <c:choose>
           <c:when test="${listLoop.code.equals(compare)}">
                <c:set var="code" value="${listLoop}"/>
                <c:set var="formType" value="update"/>
           </c:when>
           <c:otherwise>
                <c:set var="formType" value="add"/>
           </c:otherwise>
       </c:choose>
       
       </c:forEach>
       <form name="${formType}" method="post">
           
           <p><i>${message}</i></p>

           <table>
           <tr>
               <td>
                    <label> Code: </label>
               </td>
               <td>   <input type="text" name="code" value="${code.code}"> 
                   <mma:ifEmptyMark field="${code.code}"/>
               </td>
           </tr>
           <tr>
               <td>
                   <label> Description: </label>
               </td>
               <td>    <input type="text" size="70" name="description" value="${code.description}">
                   <mma:ifEmptyMark field="${code.description}"/>
               </td>
           </tr>
           <tr>
               <td>
                   <label> Price: </label>
               </td>
               <td>    <input type="text" name="price" value="${code.price}">
                   <mma:ifEmptyMark field="${code.price}"/>
               </td>
           </tr>
           
           <tr>
               <td></td>
               <td>
                   <input type="submit" value="Update Product" name="button">
                   <input type="button" onclick="location.href='productMaint.jsp'" value="View Products" >
               </td>
           </tr>
           
           </table>
        </form>
    </body>
</html>
