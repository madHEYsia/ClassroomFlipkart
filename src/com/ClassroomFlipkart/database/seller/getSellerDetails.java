package com.ClassroomFlipkart.database.seller;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getSellerDetails {

    public static String[] getDetails(String sellerId) {

        String[] seller = {"ongoing","",""};

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ",
                " classroomflipkart.sellerdetails ",
                "sellerId = '"+sellerId+"' ");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();
            seller[0] = "success";
            seller[1] = rs.getString("sellerName");
            seller[2] = rs.getString("sellerDescription");

        } catch (Exception e) {
            seller[0] = e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return seller;
        }
    }

}
