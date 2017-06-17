<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Product Maintenance</title>
    </head>
    <body>
       <form method="post">      
           <h3><font color="00bfff" size="5">Are you sure you want to delete this product?</font></h3>
        <c:forEach items="${productList}" var="listLoop">
       <c:set var="compare" value="${param.delete}"/>
       <c:choose>
           <c:when test="${listLoop.code.equals(compare)}">
                <c:set var="code" value="${listLoop}"/>
           </c:when>
       </c:choose>
       </c:forEach>
        <table>
           <tr>
               <td>
                   <label><strong> Code: </strong></label>
               </td> 
               <td>  <input type="text" style="border:none" name="code" value="${code.code}"> 
               </td>
           </tr>
           <tr>
               <td>
                   <label> <strong> Description: </strong></label>
               </td>
               <td> <input type="text" style="border:none" size="70" name="description" value="${code.description}"> 
               </td>
           </tr>
           <tr>
               <td>
                   <label> <strong> Price: </strong> </label>
               </td>
               <td>   <input type="text" style="border:none" name="price" value="${code.price}">  
               </td>
           </tr>
           <tr>
               <td></td>
               <td>
                   <input type="submit" value="Yes" name="button">
                   <input type="button" onclick="location.href='productMaint.jsp'" value="No">
               </td>
           </tr>
           </table>
        </form>
    </body>
</html>
