/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.business.Product;
import product.data.*;


@WebServlet(name = "productMaint", urlPatterns = {"/productMaint"})
public class productMaintServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String requestURI = request.getRequestURI();
        String url = "/productMaint.jsp";
        if (requestURI.endsWith("/productMaint")) {

        HttpSession sessions = request.getSession();
        ArrayList<Product> productList = ProductDB.selectProducts();            
            request.setAttribute("productList", productList);
            System.out.println("Hi");
//        if (requestURI.endsWith("/productMaint")) {
//            HttpSession session = request.getSession();
//            String path = getServletContext().getRealPath("/WEB-INF/product.txt");
//            ArrayList<Product> products = ProductIO.getProducts(path);
//            session.setAttribute("productlist",products);
//            
//        }
       
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);  
        }
        }
}
    
      /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   



