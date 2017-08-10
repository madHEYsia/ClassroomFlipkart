package com.ClassroomFlipkart.database.cart;

import com.ClassroomFlipkart.database.utils.DBUtils;

public class removeItem {

    public static void remove(String emailId, String productId) {

        try {

            DBUtils.performAction("DELETE FROM `classroomflipkart`.`cartdetails` " +
                    "WHERE `emailId`='"+emailId+"' AND `productId`='"+productId+"' ;");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
