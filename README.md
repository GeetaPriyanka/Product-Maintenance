# Product-Maintenance

Created a series of pages that allows to add, update, or delete a product that’s available to the application. 
I have used a text file (products.txt) file as a starting point for the products that are available to the application.
Server-side validation has been done to validate all user entries. Made sure that the user enters a code, description, 
and price for each product. In addition, made sure the product’s price is a valid double value.

I have enhanced the application by modifying it so it uses a database instead of a text file to store the product data. 
I have used JDBC to work with the data.

I have converted the application so it uses JPA(EclipseLink JPA) instead of JDBC to work with a database. Also enhanced the application 
by modifying it so it uses a secure connection and only allows authorized users to view/ edit the products.
