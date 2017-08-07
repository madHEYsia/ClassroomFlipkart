package com.ClassroomFlipkart.database.signIn;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.functions.getMotherboardSN;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class dbSignUp {

    public static String userSignUp(String name, String emailId, String password){
        Connection con = null;
        PreparedStatement stmt = null;

        String userID = getMotherboardSN.getMotherboardSN();

        String query = DBUtils.prepareInsertQuery("classroomflipkart.userdetail", "name, emailId ,password","?,?,?");

        String updateCurrentUserQuery = DBUtils.prepareInsertQuery("classroomflipkart.currentuser", "id, name, emailId", "?,?,?");

        String status = "ongoing";

        try{
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, emailId);
            stmt.setString(3, password);
            stmt.executeUpdate();
            status="success";

            stmt = con.prepareStatement(updateCurrentUserQuery);
            stmt.setString(1, userID);
            stmt.setString(2, name);
            stmt.setString(3, emailId);
            stmt.executeUpdate();
        }
        catch(Exception e){
            status = e.getMessage();
        }
        finally{
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(con);
            return status;
        }
    }
}
