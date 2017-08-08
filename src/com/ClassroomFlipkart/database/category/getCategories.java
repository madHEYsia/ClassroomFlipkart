package com.ClassroomFlipkart.database.category;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getCategories {

    public static String[] getCategories() {
        String[] category = {"ongoing"};

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ",
                "classroomflipkart.category",
                "",
                "GROUP BY category");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();

            if (size>0){
                rs.beforeFirst();

                int count = 0;
                category = new String[size];

                while (rs.next())
                    category[count++] = rs.getString("category");
            }

        } catch (Exception e) {
            category[0] = e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return category;
        }
    }
}
