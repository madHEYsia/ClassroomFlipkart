package com.ClassroomFlipkart.main.templates.category;

import com.ClassroomFlipkart.database.category.getItems;
import com.ClassroomFlipkart.database.category.getCategoriesRange;

import com.ClassroomFlipkart.main.windows.home.main;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class itemsByCategory {

    public static BorderPane category(String category, String subcategory){

        BorderPane items = new BorderPane();

        BorderPane leftPane = new BorderPane();
        leftPane.setPadding(new Insets(15,0,0,0));
        leftPane.setStyle("-fx-border-color: lightgrey; -fx-border-width: 0 1 0 0; ");
        leftPane.setPrefWidth(200);

        Label priceLabel = new Label("PRICE : ");
        priceLabel.setFont(Font.font("Open Sans", FontWeight.EXTRA_BOLD, 15));
        priceLabel.setTextFill(Color.web("#2f2f2f"));
        priceLabel.setPadding(new Insets(10,10,10,5));

        String[] categoryRange = getCategoriesRange.getRange(category, subcategory);
        double minmumPrice = Double.parseDouble(categoryRange[0]);
        double maximumPrice = Double.parseDouble(categoryRange[1]);
        double avg = 0.5*(maximumPrice + minmumPrice);

        Label minP = new Label("Min:");
        minP.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 13));
        minP.setTextFill(Color.web("#2f2f2f"));
        minP.setPadding(new Insets(0,5,10,5));

        Slider minslider = new Slider(
                minmumPrice,
                avg,
                minmumPrice);
        minslider.setShowTickMarks(true);
        minslider.setShowTickLabels(true);
        minslider.setMajorTickUnit((int)(0.25*(avg-minmumPrice)));
        minslider.setBlockIncrement((int)(0.1*(avg-minmumPrice)));

        Label maxP = new Label("Max:");
        maxP.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 13));
        maxP.setTextFill(Color.web("#2f2f2f"));
        maxP.setPadding(new Insets(0,5,10,5));

        Slider maxslider = new Slider(
                avg,
                maximumPrice,
                maximumPrice);
        maxslider.setShowTickMarks(true);
        maxslider.setShowTickLabels(true);
        maxslider.setMajorTickUnit((int)(0.25*(maximumPrice-avg)));
        maxslider.setBlockIncrement((int)(0.1*(maximumPrice-avg)));

        final int[] currentDiscount = {0};
        final int[] mincount = {0};
        minslider.pressedProperty().addListener(e-> {
            if (++mincount[0] % 2 ==0)
                items.setCenter(getItems.getItems(category,subcategory,minslider.getValue(),maxslider.getValue(), currentDiscount[0]));
        });

        final int[] maxcount = {0};
        maxslider.pressedProperty().addListener(e-> {
            if (++maxcount[0] % 2 ==0)
                items.setCenter(getItems.getItems(category,subcategory,minslider.getValue(),maxslider.getValue(), currentDiscount[0]));
        });

        VBox sliders = new VBox(5,
                new HBox(0,minP,minslider),
                new HBox(0,maxP,maxslider));

        Label discountLabel = new Label("DISCOUNT : ");
        discountLabel.setFont(Font.font("Open Sans", FontWeight.EXTRA_BOLD, 15));
        discountLabel.setTextFill(Color.web("#2f2f2f"));
        discountLabel.setPadding(new Insets(10,10,10,5));

        VBox discounts = new VBox(10);
        discounts.setPadding(new Insets(0,10,10,10));

        final ToggleGroup group = new ToggleGroup();
        for (int i=90; i >=0; i-=10) {
            RadioButton radio = new RadioButton(i+"% or More");
            radio.setToggleGroup(group);
            radio.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 14));
            radio.setSelected(true);
            int discount = i;
            radio.setOnAction(e-> {
                items.setCenter(getItems.getItems(category, subcategory, minslider.getValue(), maxslider.getValue(), discount));
                currentDiscount[0] = discount;
            });
            discounts.getChildren().add(radio);
        }

        VBox filterVB = new VBox(10,
                priceLabel,
                sliders,
                discountLabel,
                discounts);

        ScrollPane filters = new ScrollPane(filterVB);
        filters.setFitToHeight(true);
        filters.setFitToWidth(true);
        filters.setPannable(true);
        filters.setPrefHeight(main.window.getHeight()-150);
        main.window.heightProperty().addListener(e-> filters.setPrefHeight(main.window.getHeight()-150));

        leftPane.setTop(filters);

        items.setLeft(leftPane);
        items.setCenter(getItems.getItems(category,subcategory,minmumPrice,maximumPrice, currentDiscount[0]));

        return items;
    }

}
