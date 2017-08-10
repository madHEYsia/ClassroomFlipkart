package com.ClassroomFlipkart.database.cart;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class updateItemQuantity {

    public static String update(String emailId, String productId, int quantity){

        Connection con = null;
        PreparedStatement stmt = null;

        String query = DBUtils.prepareUpdateQuery(
                "classroomflipkart.cartdetails",
                "quantity = '"+quantity+"'",
                "( emailId = ? AND productId = ? )");

        String status = "Ongoing";
        try{
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, emailId);
            stmt.setString(2, productId);
            stmt.executeUpdate();
            status = "success";
        }
        catch(Exception e){
            e.printStackTrace();
            status = e.getMessage();
        }
        finally{
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(con);
            return status;
        }
    }

}
