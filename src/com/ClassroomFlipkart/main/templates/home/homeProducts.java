package com.ClassroomFlipkart.main.templates.home;

import com.ClassroomFlipkart.database.homeProducts.fetchProducts;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class homeProducts {

    public static BorderPane homeProducts(){

        VBox products = new VBox(20);
        products.getChildren().addAll(
                fetchProducts.productbyType("Discounts for You"),
                fetchProducts.productbyType("Featured Product"),
                fetchProducts.productbyType("New Arrival"),
                fetchProducts.productbyType("Trending"));

        ScrollPane proScroller = new ScrollPane(products);
        proScroller.setPrefHeight(400);
        proScroller.setFitToWidth(true);

        BorderPane home = new BorderPane(proScroller);
        return home;

    }


}
