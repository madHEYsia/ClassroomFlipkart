package com.ClassroomFlipkart.database.comments;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class getAvgRating {

    public static String[] getAvgRating(String productId) {

        String[] avg = {"ongoing","0","0"};

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
            avg[0] = "success";
            avg[2] = rs.getString("count");
            if (!Objects.equals(avg[2], "0"))
                avg[1] = rs.getString("avg").substring(0,4);
            else
                avg[0] = "failed";

        } catch (Exception e) {
            avg[0] = e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return avg;
        }
    }

}
