package com.ClassroomFlipkart.database.userDetail;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getUserName {

        public static String getUserName(String mailId) {
            String name="";

            Connection con = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            String query = DBUtils.prepareSelectQuery(" fullName ",
                    "classroomflipkart.userdetail",
                    " emailId = '"+mailId+"' ",
                    "" );

            try {
                con = DBUtils.getConnection();
                stmt = con.prepareStatement(query);
                rs = stmt.executeQuery();

                rs.last();
                int size = rs.getRow();

                if (size>0){
                    rs.beforeFirst();
                    rs.next();
                    name = rs.getString("name");
                }
                else
                    name ="";

            } catch (Exception e) {
                name = e.getMessage();
                e.printStackTrace();
            } finally {
                DBUtils.closeAll(rs, stmt, con);
                return name;
            }
        }

}
