package com.ClassroomFlipkart.main.templates.category;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class itemsByCategory {

    public static BorderPane category(String title){

        BorderPane items = new BorderPane(new Label(title));


        return items;
    }

}
