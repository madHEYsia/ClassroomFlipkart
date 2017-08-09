package com.ClassroomFlipkart.database.seller;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getPincodeStatus {

    public static String getStatus(String sellerId, String pincode) {

        String message = null;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ",
                " classroomflipkart.sellerpincodes ",
                "sellerId = '"+sellerId+"' AND pincode = '"+pincode+"'");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();

            if (size==1){
                String deliveryDays = rs.getString("deliveryDays");
                String deliveryCharges = rs.getString("deliveryCharges");
                message = "Delivery in "+deliveryDays+" days  | "+deliveryCharges;
            }
            else
                message = "Sorry, delivery not available here ";

        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return message;
        }
    }


}
