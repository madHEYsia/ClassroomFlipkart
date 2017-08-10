package com.ClassroomFlipkart.database.cart;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.templates.home.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class addItem {

    public static String add(String emailId, String productId){

        Connection con = null;
        PreparedStatement stmt = null;

        String query = DBUtils.prepareInsertQuery("classroomflipkart.cartdetails", " emailId, productId", "?,?");

        String status = "Ongoing";
        try{
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, emailId);
            stmt.setString(2, productId);               //default qunatity added is 1. CHECK .sql file for deatils
            stmt.executeUpdate();
            status ="success";
            int itemInCart = Integer.parseInt(profile.itemsInCart.getText());
            profile.itemsInCart.setText((itemInCart+1)+"");
        }
        catch(Exception e){
            status = e.getMessage();
            e.printStackTrace();
        }
        finally{
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(con);
            return status;
        }
    }

}
