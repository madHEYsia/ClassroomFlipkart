package com.ClassroomFlipkart.database.orders;

import com.ClassroomFlipkart.database.cart.removeItem;
import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.templates.home.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addOrders {

    public static String add(String emailId){

        Connection con = null;
        PreparedStatement stmt = null;

        String cartQuery = DBUtils.prepareSelectQuery("*","classroomflipkart.cartdetails","emailId = '"+emailId+"'");

        String query = DBUtils.prepareInsertQuery("classroomflipkart.userorders", " timestamp, emailId, productId, quantity", "?,?,?,?");

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        String status = "Ongoing";
        try{
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(cartQuery);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                stmt = con.prepareStatement(query);
                stmt.setString(1, timestamp);
                stmt.setString(2, emailId);
                stmt.setString(3, rs.getString("productId"));
                stmt.setString(4, rs.getString("quantity"));
                stmt.executeUpdate();
                removeItem.remove(emailId,rs.getString("productId"));
            }

            status ="success";
            profile.itemsInCart.setText("0");
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
