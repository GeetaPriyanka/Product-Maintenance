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
@WebServlet(name = "EditProductServlet", urlPatterns = {"/Edit"})
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String requestURI = request.getRequestURI();
            if (requestURI.contains("/ProductMaintenance_prjct1/Edit")) {
            String url="/addProduct.jsp";
            ArrayList<Product> products = ProductDB.selectProducts();
            HttpSession session = request.getSession();

            session.setAttribute("productList",products);
            getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
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
    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
            String action = request.getParameter("button");
            String url,message;
            String productCode = null,productDesc = null;
            double productPrice = 0;
            
            if (action.equals("Update Product")) {            
            HttpSession session = request.getSession();
            try {

            productCode = request.getParameter("code");
            productDesc = request.getParameter("description");
            productPrice = Double.parseDouble(request.getParameter("price"));
            message = "";
            url = "/productMaint.jsp";   
            if(productCode.isEmpty()||productDesc.isEmpty()||request.getParameter("price").isEmpty())
            {
            message = "Please enter a valid value in all three text boxes.";
            request.setAttribute("message",message);
            url = "/addProduct.jsp";            
            }
            else
            {
            request.setAttribute("message",message);
            Product product=new Product();
            product.setCode(productCode);
            product.setDescription(productDesc);
            product.setPrice(productPrice);
            ProductDB.update(product);
            ArrayList<Product> products = ProductDB.selectProducts();
            session.setAttribute("productList",products);
            }
            }
            catch(NumberFormatException e ) {
            message = "Please enter a valid value in all three text boxes";
            request.setAttribute("message",message);
            url = "/addProduct.jsp";
            }            
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        } 
        if (action.equals("View Products")) {
            url = "/productMaint.jsp";   
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }           
    }
}

