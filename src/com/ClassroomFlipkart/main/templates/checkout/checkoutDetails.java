package com.ClassroomFlipkart.main.templates.checkout;

import com.ClassroomFlipkart.database.checkout.fetchitems;

import javafx.scene.layout.BorderPane;

public class checkoutDetails {

    public static BorderPane checkout(String emailId){

        BorderPane items = new BorderPane();

        items.setLeft(fetchitems.itemList(emailId));


        return items;
    }
}
