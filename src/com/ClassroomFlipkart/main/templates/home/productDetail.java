package com.ClassroomFlipkart.main.templates.home;

import com.ClassroomFlipkart.database.cart.addItem;
import com.ClassroomFlipkart.database.cart.fetchItemQuantity;
import com.ClassroomFlipkart.database.cart.updateItemQuantity;
import com.ClassroomFlipkart.database.logIn.userLoggedIn;
import com.ClassroomFlipkart.main.functions.getMotherboardSN;
import com.ClassroomFlipkart.main.windows.home.main;
import com.ClassroomFlipkart.main.templates.product.products;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;

public class productDetail {

    public static BorderPane productByType(String productId, String productName, String newPrice, String oldPrice, String category, String subcategory, String imageName, String productAvailability){

        Label availablity = new Label(productAvailability);
        availablity.setFont(Font.font("Open Sans", FontWeight.BOLD, 12));
        availablity.setTextFill(Color.web("#fff"));
        availablity.setPadding(new Insets(3));
        StackPane availabilityPane = new StackPane(availablity);
        availabilityPane.setPadding(new Insets(5));
        availabilityPane.setAlignment(Pos.TOP_LEFT);
        if (productAvailability.equals("AVAILABLE"))
            availablity.setStyle("-fx-background-color: #388e3c");
        else if (productAvailability.equals("ON SALE"))
            availablity.setStyle("-fx-background-color: #2874f0");
        else
            availablity.setStyle("-fx-background-color: #ff4040");

        String imageURL = profile.class.getResource("../../resources/images/small/"+imageName).toExternalForm();
        Image img = new Image(imageURL);
        ImageView imgView = new ImageView(img);
        imgView.setPreserveRatio(true);
        imgView.setFitWidth(0.15*main.window.getWidth());
        main.window.widthProperty().addListener(e-> imgView.setFitWidth(0.15*main.window.getWidth()));

        StackPane image = new StackPane(imgView, availabilityPane);
        image.setAlignment(Pos.TOP_LEFT);

        Label name = new Label(productName);
        name.setPadding(new Insets(7,0,7,0));
        name.setFont(Font.font("Open Sans", 15));
        name.setAlignment(Pos.TOP_CENTER);
        name.setWrapText(true);
        name.setPrefWidth(0.15*main.window.getWidth());
        main.window.widthProperty().addListener(e-> name.setPrefWidth(0.15*main.window.getWidth()));

        Label newP = new Label("₹ "+newPrice);
        newP.setPadding(new Insets(0,5,0,5));
        newP.setFont(Font.font("Open Sans",FontWeight.SEMI_BOLD ,14.5));

        Label off = new Label((int)(100*(1.0 - Double.parseDouble(newPrice)/Double.parseDouble(oldPrice)))+"% off");
        off.setPadding(new Insets(2,5,0,5));
        off.setFont(Font.font("Open Sans", 13));
        off.setTextFill(Color.web("#388e3c"));

        Button addToCart = GlyphsDude.createIconButton(
                FontAwesomeIcon.CART_PLUS,
                "",
                "18",
                "0",
                ContentDisplay.LEFT);
        addToCart.setAlignment(Pos.CENTER);
        addToCart.setStyle("-fx-background-color: transparent");
        addToCart.setPadding(new Insets(0,8,0,0));
        addToCart.setCursor(Cursor.HAND);
        addToCart.setOnAction(e-> {

            String userID = getMotherboardSN.getMotherboardSN();
            String[] response = userLoggedIn.userLoggedIn(userID);
            int previousQuantity = fetchItemQuantity.getItems(response[2],productId);

            String status;
            if (previousQuantity==0)
                status = addItem.add(response[2],productId);
            else
                status = updateItemQuantity.update(response[2],productId,previousQuantity+1);

            Label statuslabel;
            if (status.equals("success"))
                statuslabel = new Label("ADDED TO CART SUCCESSFULLY !!");
            else
                statuslabel = new Label("FAILED TO ADD TO CART !!");

            statuslabel.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 14));
            statuslabel.setTextFill(Color.web("#fff"));

            BorderPane added = new BorderPane(statuslabel);
            added.setStyle("-fx-background-color: #222;");
            added.setPadding(new Insets(15));

            final Popup popup = new Popup();
            popup.setX(main.window.getX()+0.5*main.window.getWidth()-120);
            popup.setY(main.window.getY()+ main.window.getHeight() - 80);
            popup.getContent().add(added);
            popup.show(main.window);

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(event-> popup.hide());
            new Thread(sleeper).start();
        });

        BorderPane bottom = new BorderPane(null,null,addToCart,null,new HBox(0,newP,off));
        bottom.setPrefWidth(0.15*main.window.getWidth());
        main.window.widthProperty().addListener(e-> bottom.setPrefWidth(0.15*main.window.getWidth()));

        BorderPane pro =  new BorderPane(name,image,null,
                bottom,
                null);
        pro.setPadding(new Insets(5));
        pro.setCursor(Cursor.HAND);
        pro.setPrefHeight(250);
        pro.setOnMouseEntered(e-> imgView.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);") );
        pro.setOnMouseExited(e-> imgView.setStyle("") );
        pro.setOnMouseClicked(e->
            profile.centerPane.setCenter(products.productDetail(productId, productName, newPrice, oldPrice, category, subcategory, imageName, productAvailability))
        );

        return pro;
    }

}
