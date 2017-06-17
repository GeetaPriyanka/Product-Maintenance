/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.data;

import product.business.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author stephen
 */
public class ProductDB {
    public static ArrayList<Product> selectProducts() {
        // add code that returns an ArrayList<User> object of all users in the User table
        ArrayList<Product> productList = new ArrayList<Product>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM product ";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Product product = null;
            while (rs.next()) {
                product = new Product();
                product.setCode(rs.getString("ProductCode"));
                product.setDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("ProductPrice"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int insert(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO product (ProductID, ProductCode, ProductDescription, ProductPrice) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            Random rand = new Random();
            int n = rand.nextInt(50)+1; 
            ps.setInt(1, n);
            ps.setString(2, product.getCode());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     public static int delete(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM product "
                + "WHERE ProductCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "Update product set ProductDescription='"+product.getDescription()+"', ProductPrice='"+product.getPrice()+"' WHERE ProductCode = '"+product.getCode()+"'";
        try {
            ps = connection.prepareStatement(query);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
