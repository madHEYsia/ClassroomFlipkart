package com.ClassroomFlipkart.database.cart;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getItemsInCart {

    public static int getItems(int cartId) {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" SUM(quantity) ",
                " classroomflipkart.cartdetails ",
                "cartId='"+cartId+"'");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            return rs.getRow();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return 0;
        }
    }


}
