package com.ClassroomFlipkart.main.templates.home;

import com.ClassroomFlipkart.database.category.getCategories;
import com.ClassroomFlipkart.database.category.getSubCategories;
import com.ClassroomFlipkart.main.templates.account.myAccount;
import com.ClassroomFlipkart.main.templates.category.itemsByCategory;
import com.ClassroomFlipkart.main.windows.home.main;
import com.ClassroomFlipkart.main.templates.checkout.checkoutDetails;
import com.ClassroomFlipkart.main.templates.orders.myOrders;
import com.ClassroomFlipkart.database.signIn.userSignOut;
import com.ClassroomFlipkart.database.cart.*;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class profile {

    public static Label itemsInCart;

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
        title.setFont(Font.font("Open Sans", FontWeight.BOLD, 25));
        title.setTextFill(Color.web("#ededed"));
        title.setAlignment(Pos.TOP_LEFT);
        title.setPadding(new Insets(-5,20,0,0));

        String imageURL = profile.class.getResource("../../resources/images/ClassroomFlipkart.png").toExternalForm();
        Image img = new Image(imageURL);
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(25);
        imgView.setPreserveRatio(true);

        HBox leftTitle = new HBox(title,imgView);
        leftTitle.setPadding(new Insets(10,20,0,0));
        leftTitle.setCursor(Cursor.HAND);
        leftTitle.setOnMouseClicked(e-> centerPane.setCenter(homeProducts.homeProducts()));

        TextField mailSearch = new TextField();
        mailSearch.setPromptText("Search by keyword, mail Ids, Subject, etc");
        mailSearch.setFont(new Font("Open Sans", 15));
        mailSearch.setPrefHeight(20);
        mailSearch.setStyle("-fx-background-color: #ededed; -fx-border-color: #ededed; -fx-border-width: 2,2,2,2; -fx-border-radius: 2");
        mailSearch.setPadding(new Insets(4,10,4,10));
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

        Label cart = GlyphsDude.createIconLabel(FontAwesomeIcon.SHOPPING_CART,"","30","0",ContentDisplay.CENTER);
        cart.setStyle("-fx-background-color: transparent");
        cart.setPadding(new Insets(8,0,0,30));

        Label notification = new Label("");
        notification.setFont(new Font("Open Sans", 0));
        notification.setStyle("-fx-border-color: red; -fx-border-width : 12; -fx-border-radius: 100");

        int cartNumber = getItemsInCart.getItems(getCartId.getId(emailId));
        itemsInCart = new Label(cartNumber+"");
        itemsInCart.setFont(Font.font("Open Sans", FontWeight.BOLD, 12));
        itemsInCart.setTextFill(Color.web("#fff"));
        itemsInCart.setPadding(new Insets(3));

        StackPane items = new StackPane();
        items.getChildren().addAll(notification,itemsInCart);
        items.setAlignment(Pos.TOP_CENTER);
        items.setPadding(new Insets(-2,0,0,-8));
        items.setCursor(Cursor.HAND);
        items.setOnMouseClicked(e-> centerPane.setCenter(checkoutDetails.checkout()) );

        Label name = new Label("Hi "+completeName);
        name.setFont(new Font("Open Sans", 15));
        name.setTextFill(Color.web("#ededed"));
        name.setPadding(new Insets(8,0,0,30));
        name.setMaxWidth(200);

        Menu option = new Menu();
        GlyphsDude.setIcon(option,FontAwesomeIcon.CARET_DOWN);

        MenuItem orders = new MenuItem( "Your Orders");
        orders.setOnAction(e-> centerPane.setCenter(myOrders.orders()));

        MenuItem account = new MenuItem( "Your Account");
        account.setOnAction(e-> centerPane.setCenter(myAccount.account()));

        MenuItem signOut = new MenuItem( "Log Out");
        signOut.setOnAction(e-> {
            userSignOut.userSignOut();
            main.window.setScene(loginHome.homeView());
        });

        MenuBar setting = new MenuBar(option);
        setting.setPadding(new Insets(10,10,0,0));

        option.getItems().addAll(orders,account,signOut);

        MenuBar menus = new MenuBar();
        String[] categories = getCategories.getCategories();

        for (String category : categories) {
            String[] subCategories = getSubCategories.getSubCategories(category);

            Menu categoryType = new Menu(category);

            for (String subCategory : subCategories) {
                MenuItem subcateory = new MenuItem( subCategory);
                subcateory.setOnAction(e->
                        profile.centerPane.setCenter(itemsByCategory.category(subCategory))
                );
                categoryType.getItems().add(subcateory);
            }

            menus.getMenus().add(categoryType);
        }

        topPane.setLeft(leftTitle);
        topPane.setCenter(mailSearch);
        topPane.setRight(new HBox(0,cart, items, name, setting));
        topPane.setBottom(menus);

        //===================================TOP PANE ENDS========================================

        //===================================CENTER PANE STARTS===================================

        centerPane.setCenter(homeProducts.homeProducts());

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
