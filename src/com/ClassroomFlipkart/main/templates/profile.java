package com.ClassroomFlipkart.main.templates;

import com.ClassroomFlipkart.main.windows.home.main;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class profile {

    public static Scene scene;
    public static BorderPane topPane ;
    public static BorderPane centerPane ;
    public static BorderPane bottomPane ;
    public static final Pattern VALID_STRING_REGEX = Pattern.compile("^\\s*$", Pattern.CASE_INSENSITIVE);

    final static BooleanProperty firstTime = new SimpleBooleanProperty(true); // Variable to store the focus on stage load

    public static Scene main(String completeName, String emailId){

        topPane = new BorderPane();
        centerPane = new BorderPane();

        topPane.setMaxHeight(100);
        topPane.setPadding(new Insets(10,30,10,30));

        topPane.setStyle("-fx-background-color: #2874f0; -fx-border-color: grey; -fx-border-width: 0 0 1 0; -fx-text-color: #fafafa;");

        //===================================TOP PANE STARTS===================================

        Label title = new Label("Classroom Flipkart");
        title.setFont(new Font("Open Sans", 22));
        title.setTextFill(Color.web("#ededed"));
        title.setPadding(new Insets(5,20,0,0));

        String imageURL = profile.class.getResource("../resources/images/ClassroomFlipkart.png").toExternalForm();
        Image img = new Image(imageURL);
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(20);
        imgView.setPreserveRatio(true);

        HBox leftTitle = new HBox(5,title,imgView);
        leftTitle.setPadding(new Insets(0,20,0,0));

        TextField mailSearch = new TextField();
        mailSearch.setPromptText("Search by keyword, mail Ids, Subject, etc");
        mailSearch.setFont(new Font("Open Sans", 15));
        mailSearch.setPrefHeight(25);
        mailSearch.setStyle("-fx-background-color: #ededed; -fx-border-color: #ededed; -fx-border-width: 2,2,2,2; -fx-border-radius: 2");
        mailSearch.setPadding(new Insets(5,10,5,10));
        mailSearch.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
            if(newValue && firstTime.get()){
                centerPane.requestFocus(); // Delegate the focus to container
                firstTime.setValue(false); // Variable value changed for future references
            }
        });

        mailSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!whitespacevalidate(newValue)) {
//                if (myComboBox.getValue().equals("Sort by Latest"))
//                    centerPane.setCenter(searchForThread.search(newValue, emailId, "ORDER BY messageTimestamp desc"));
//                else if (myComboBox.getValue().equals("Sort by Oldest"))
//                    centerPane.setCenter(searchForThread.search(newValue, emailId, "ORDER BY messageTimestamp asc"));
            }
        });

        Label name = new Label(completeName);
        name.setFont(new Font("Open Sans", 15));
        name.setTextFill(Color.web("#ededed"));
        name.setPadding(new Insets(3,20,0,0));

        Button orders = new Button("Your Orders");
        orders.setFont(new Font("Open Sans", 15));
        orders.setTextFill(Color.web("#ededed"));
//        orders.setPadding(new Insets(5,20,0,0));

        int cartItem = 0;
        Button cart = new Button("Cart "+cartItem);
        cart.setFont(new Font("Open Sans", 15));
        cart.setTextFill(Color.web("#ededed"));
//        cart.setPadding(new Insets(5,20,0,20));

        topPane.setLeft(leftTitle);
        topPane.setCenter(new HBox(mailSearch));
        topPane.setRight(new VBox(5,name,new HBox(0,orders,cart)));

        //===================================TOP PANE ENDS===================================

        //===================================CENTER PANE STARTS=====================================

//        centerPane.setCenter(centerPanel.centerPanel("Inbox", emailId,"ORDER BY messageTimestamp desc"));

        //===================================CENTER PANE ENDS=====================================


        BorderPane profilePane = new BorderPane(centerPane,topPane,null,bottomPane,null);
        profilePane.setStyle("-fx-background-color: lightgrey");


        scene = new Scene(profilePane,850,550);
        scene.getStylesheets().add(main.class.getResource("../../resources/css/main.css").toExternalForm());

        return scene;
    }

    public static boolean whitespacevalidate(String Str) {
        Matcher matcher = VALID_STRING_REGEX .matcher(Str);
        return matcher.find();
    }
}
