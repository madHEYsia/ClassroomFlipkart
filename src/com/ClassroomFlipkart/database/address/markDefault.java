package com.ClassroomFlipkart.database.address;

import com.ClassroomFlipkart.database.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class markDefault {

    public static String update(String emailId, String userAddress){

        Connection con = null;
        PreparedStatement stmt = null;

        String markFalseQuery = DBUtils.prepareUpdateQuery(
                "classroomflipkart.useraddress",
                " isDefault = 'false' ",
                "");

        String markDefaultquery = DBUtils.prepareUpdateQuery(
                "classroomflipkart.useraddress",
                " isDefault = 'true' ",
                "( emailId = '"+emailId+"' AND userAddress = '"+userAddress+"' ) ");

        String status = "Ongoing";
        try{
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(markFalseQuery);
            stmt.executeUpdate();
            stmt = con.prepareStatement(markDefaultquery);
            stmt.executeUpdate();
            status = "success";
        }
        catch(Exception e){
            e.printStackTrace();
            status = e.getMessage();
        }
        finally{
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(con);
            return status;
        }
    }


}
