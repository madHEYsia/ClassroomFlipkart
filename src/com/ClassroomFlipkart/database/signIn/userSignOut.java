package com.ClassroomFlipkart.database.signIn;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.functions.getMotherboardSN;

public class userSignOut {

    public static void userSignOut() {

        String userID = getMotherboardSN.getMotherboardSN();

        try {

            DBUtils.performAction("DELETE FROM `classroomflipkart`.`currentuser` WHERE `id`='"+userID+"';");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}