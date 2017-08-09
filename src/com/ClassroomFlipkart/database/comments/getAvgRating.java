package com.ClassroomFlipkart.database.comments;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getAvgRating {

    public static String[] getAvgRating(String productId) {

        String[] avg = {"",""};

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" AVG(productRating) AS avg, COUNT(timestamp) AS count ",
                " classroomflipkart.productcoment ",
                "productId = '"+productId+"' ",
                "");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();
            avg[0] = rs.getString("avg").substring(0,4);
            avg[1] = rs.getString("count");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return avg;
        }
    }

}
