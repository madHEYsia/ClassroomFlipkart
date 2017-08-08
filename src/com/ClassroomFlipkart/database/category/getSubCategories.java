package com.ClassroomFlipkart.database.category;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getSubCategories {

    public static String[] getSubCategories(String category) {
        String[] subcategory ={"ongoing"};

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" subcategory ",
                "classroomflipkart.category",
                " category = '"+category+"' ",
                "" );

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();

            if (size>0){
                rs.beforeFirst();

                int count = 0;
                subcategory = new String[size];

                while (rs.next())
                    subcategory[count++] = rs.getString("subcategory");
            }

        } catch (Exception e) {
            subcategory[0] = e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return subcategory;
        }
    }

}
