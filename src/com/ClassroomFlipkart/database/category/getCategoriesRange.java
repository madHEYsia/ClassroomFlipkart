package com.ClassroomFlipkart.database.category;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class getCategoriesRange {

    public static String[] getRange(String category, String subcategory) {

        String[] categoryRange = {"0","0"};

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" minPrice, maxPrice ",
                " classroomflipkart.category ",
                "category = '"+category+"' AND subcategory = '"+subcategory+"' ",
                "");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();
            categoryRange[0] = rs.getString("minPrice");
            categoryRange[1] = rs.getString("maxPrice");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return categoryRange;
        }
    }

}
