package com.ClassroomFlipkart.database.cart;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getItemsInCart {

    public static int getItems(String emailId) {

        int items = 0;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" COUNT(productId) as items ",
                " classroomflipkart.cartdetails ",
                " emailId = '"+emailId+"' ");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            rs.next();
            items = Integer.parseInt(rs.getString("items"));
        } catch (Exception e) {
            items = 0;
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return items;
        }
    }


}
