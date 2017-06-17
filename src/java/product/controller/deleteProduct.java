/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.business.Product;
import product.data.ProductDB;
import product.data.ProductIO;

/**
 *
 * @author Manikanth
 */
@WebServlet(name = "deleteProduct", urlPatterns = {"/Delete"})
public class deleteProduct extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            String requestURI = request.getRequestURI();
            if (requestURI.contains("/ProductMaintenance_prjct1/Delete")) {
            String url="/deleteProduct.jsp";
            ArrayList<Product> products = ProductDB.selectProducts();
            HttpSession session = request.getSession();

            session.setAttribute("productList",products);
            getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
            }
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String action = request.getParameter("button");
            String url;
            if (action.equals("Yes")) {            
            url = "/productMaint.jsp";   
            HttpSession session = request.getSession();
            String productCode = request.getParameter("code");
            String productDesc = request.getParameter("description");
            double productPrice =  Double.parseDouble(request.getParameter("price"));

//              System.out.println(productCode);
//               System.out.println(productDesc);
//                 System.out.println(productPrice);
//             
            Product product=new Product();
            product.setCode(productCode);
            product.setDescription(productDesc);
            product.setPrice(productPrice);
            ProductDB.delete(product);

            ArrayList<Product> products = ProductDB.selectProducts();
            session.setAttribute("productList",products);
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        } 
                
    }
}
