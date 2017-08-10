package com.ClassroomFlipkart.database.cart;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fetchItemQuantity {

    public static int getItems(String emailId, String productId) {

        int items = 0;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" quantity ",
                " classroomflipkart.cartdetails ",
                " emailId = '"+emailId+"' AND productId = '"+productId+"'");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();
            if (rs.getRow()>0)
                items = Integer.parseInt(rs.getString("quantity"));
            else
                items = 0;
        } catch (Exception e) {
            items = 0;
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return items;
        }
    }


}
