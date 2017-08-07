package com.ClassroomFlipkart.database.logIn;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.functions.getMotherboardSN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbLoginCheck {

    public static String[] dbLoginCheck(String emailId, String password) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String userID = getMotherboardSN.getMotherboardSN();

        String query = DBUtils.prepareSelectQuery(" * ", "classroommail.userdetail", "( emailId = ? AND password = ? )");

        String updateCurrentUserQuery = DBUtils.prepareInsertQuery("classroommail.currentuser", "id, fullName, emailId", "?,?,?");

        String[] status = {"ongoing",""};

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, emailId);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            rs.last();
            int size = rs.getRow();
            rs.beforeFirst();

            if (size>0){
                status[0]="success";
                rs.next();
                status[1]=rs.getString("fullName");

                stmt = con.prepareStatement(updateCurrentUserQuery);
                stmt.setString(1, userID);
                stmt.setString(2, status[1]);
                stmt.setString(3, emailId);
                stmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            status[0] = e.getMessage();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return status;
        }
    }
}
