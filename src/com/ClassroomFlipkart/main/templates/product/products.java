package com.ClassroomFlipkart.main.templates.product;

import com.ClassroomFlipkart.database.comments.fetchComments;
import com.ClassroomFlipkart.main.templates.category.itemsByCategory;
import com.ClassroomFlipkart.main.templates.home.profile;
import com.ClassroomFlipkart.main.windows.home.main;
import com.ClassroomFlipkart.database.seller.getPincodeStatus;
import com.ClassroomFlipkart.database.seller.getSellerId;
import com.ClassroomFlipkart.database.seller.getSellerDetails;
import com.ClassroomFlipkart.database.comments.getAvgRating;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class products {

    public static ScrollPane productDetail(String productId, String productName, String newPrice, String oldPrice, String category, String subcategory, String imageName, String productAvailability){

        Label availablity = new Label(productAvailability);
        availablity.setFont(Font.font("Open Sans",FontWeight.SEMI_BOLD, 14));
        availablity.setTextFill(Color.web("#fff"));
        availablity.setPadding(new Insets(5));
        StackPane availabilityPane = new StackPane(availablity);
        availabilityPane.setPadding(new Insets(5));
        availabilityPane.setAlignment(Pos.TOP_LEFT);
        if (productAvailability.equals("AVAILABLE"))
            availablity.setStyle("-fx-background-color: #388e3c");
        else if (productAvailability.equals("ON SALE"))
            availablity.setStyle("-fx-background-color: #2874f0");
        else
            availablity.setStyle("-fx-background-color: #ff4040");


        String imageURL = profile.class.getResource("../../resources/images/large/"+imageName).toExternalForm();
        Image img = new Image(imageURL);
        ImageView imgView = new ImageView(img);
        imgView.setPreserveRatio(true);
        imgView.setFitWidth(0.30* main.window.getWidth());
        main.window.widthProperty().addListener(e-> imgView.setFitWidth(0.30*main.window.getWidth()));

        StackPane image = new StackPane(imgView, availabilityPane);
        image.setAlignment(Pos.TOP_LEFT);

        Button addToCart = GlyphsDude.createIconButton(
                FontAwesomeIcon.SHOPPING_CART,
                " ADD TO CART",
                "15",
                "15",
                ContentDisplay.LEFT);
        addToCart.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 15));
        addToCart.setStyle("-fx-background-color: #ff9f00");
        addToCart.setAlignment(Pos.CENTER);
        addToCart.setPadding(new Insets(8));
        addToCart.setCursor(Cursor.HAND);
        addToCart.setPrefWidth(0.14* main.window.getWidth());
        main.window.widthProperty().addListener(e-> addToCart.setPrefWidth(0.14*main.window.getWidth()));

        Button buyNow = GlyphsDude.createIconButton(
                FontAwesomeIcon.FORWARD,
                " BUY NOW",
                "15",
                "15",
                ContentDisplay.LEFT);new Button("");
        buyNow.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 15));
        buyNow.setStyle("-fx-background-color: #fb641b");
        buyNow.setAlignment(Pos.CENTER);
        buyNow.setPadding(new Insets(8));
        buyNow.setCursor(Cursor.HAND);
        buyNow.setPrefWidth(0.14* main.window.getWidth());
        main.window.widthProperty().addListener(e-> buyNow.setPrefWidth(0.14*main.window.getWidth()));

        BorderPane cartOption = new BorderPane(null,null,buyNow,null,addToCart);
        cartOption.setPadding(new Insets(10,5,5,5));
        BorderPane leftPane = new BorderPane(
                cartOption,
                image,
                null,
                null,
                null);
        leftPane.setPadding(new Insets(10));

        VBox rightVB = new VBox(5);

        Label categoryLabel = new Label(category);
        categoryLabel.setFont(new Font("Open Sans", 14));
        categoryLabel.setTextFill(Color.web("#666"));
        categoryLabel.setPadding(new Insets(5));
        categoryLabel.setMaxWidth(200);

        Label arrow = GlyphsDude.createIconLabel(FontAwesomeIcon.CARET_RIGHT,"","12","0",ContentDisplay.CENTER);
        arrow.setPadding(new Insets(6));

        Label subcategoryLabel = new Label(subcategory);
        subcategoryLabel.setFont(new Font("Open Sans", 14));
        subcategoryLabel.setTextFill(Color.web("#666"));
        subcategoryLabel.setPadding(new Insets(4,0,6,5));
        subcategoryLabel.setMaxWidth(200);
        subcategoryLabel.setCursor(Cursor.HAND);
        subcategoryLabel.setOnMouseClicked(e-> profile.centerPane.setCenter(itemsByCategory.category(category, subcategory)));

        Label productNameLabel = new Label(productName);
        productNameLabel.setFont(new Font("Open Sans", 15));
        productNameLabel.setTextFill(Color.web("#191919"));
        productNameLabel.setPadding(new Insets(2,0,0,5));
        productNameLabel.setPrefWidth(0.55* main.window.getWidth());
        main.window.widthProperty().addListener(e-> productNameLabel.setPrefWidth(0.55*main.window.getWidth()));

        String[] rateDetail = getAvgRating.getAvgRating(productId);

        Label rating = GlyphsDude.createIconLabel(
                FontAwesomeIcon.STAR,
                rateDetail[1]+"",
                "14",
                "14",
                ContentDisplay.RIGHT
        );
        rating.setFont(Font.font("Open Sans",FontWeight.THIN, 14));
        rating.setTextFill(Color.web("#000"));
        rating.setStyle("-fx-background-color: #388e3c");
        rating.setPadding(new Insets(0,10,0,10));

        Label ratedBy = new Label(rateDetail[2]+" Ratings");
        ratedBy.setFont(Font.font("Open Sans",FontWeight.NORMAL, 14));
        ratedBy.setTextFill(Color.web("#666"));

        HBox rate = new HBox();
        if (rateDetail[0].equals("success"))
            rate = new HBox(10,rating, ratedBy);
        rate.setAlignment(Pos.CENTER_LEFT);
        rate.setPadding(new Insets(0,10,0,0));

        Label newP = new Label("₹"+newPrice);
        newP.setFont(Font.font("Open Sans",FontWeight.BOLD, 20));
        newP.setTextFill(Color.web("#191919"));
        newP.setPadding(new Insets(5,0,5,5));

        Label discount = new Label((int)(100*(1.0 - Double.parseDouble(newPrice)/Double.parseDouble(oldPrice)))+"% off");
        discount.setFont(Font.font("Open Sans",FontWeight.NORMAL, 15));
        discount.setTextFill(Color.web("#388e3c"));
        discount.setPadding(new Insets(10,0,3,3));

        Label delivery = GlyphsDude.createIconLabel(
                FontAwesomeIcon.MAP_PIN,
                "Delivery  ",
                "14",
                "15",
                ContentDisplay.RIGHT
        );
        delivery.setFont(Font.font("Open Sans",FontWeight.NORMAL, 15));
        delivery.setTextFill(Color.web("#474747"));
        delivery.setPadding(new Insets(10,10,0,0));

        TextField pincode = new TextField();
        pincode.setFont(Font.font("Open Sans",FontWeight.SEMI_BOLD, 14));
        pincode.setPromptText("Enter the Delivery Ccde");
        pincode.setStyle("-fx-background-color: transparent; -fx-text-fill-color: #222");

        Label sellerDeliveryCheck = new Label("CHECK");
        sellerDeliveryCheck.setFont(Font.font("Open Sans",FontWeight.SEMI_BOLD, 14));
        sellerDeliveryCheck.setTextFill(Color.web("#2874f0"));
        sellerDeliveryCheck.setCursor(Cursor.HAND);
        sellerDeliveryCheck.setPadding(new Insets(5,0,0,0));

        HBox pinHb = new HBox(10,pincode,sellerDeliveryCheck);
        pinHb.setStyle("-fx-background-color: transparent; -fx-border-color: #2874f0; -fx-border-width: 0 0 3 0");

        Label message = new Label("");
        message.setFont(Font.font("Open Sans",FontWeight.NORMAL, 13));

        String sellerId = getSellerId.getStatus(productId);

        sellerDeliveryCheck.setOnMouseClicked(e-> {
            if (pincode.getText().length()!=6){
                message.setText("Incorrect Pin Code");
                message.setTextFill(Color.web("red"));
            }
            else {
                String status = getPincodeStatus.getStatus(sellerId,pincode.getText());
                if (status.substring(0,8).equals("Delivery"))
                    message.setTextFill(Color.web("green"));
                else
                    message.setTextFill(Color.web("red"));
                message.setText(status);
            }
        });

        String[] sellerDetail = getSellerDetails.getDetails(sellerId);

        Label sellerNameLabel = new Label("Seller : \t");
        sellerNameLabel.setFont(new Font("Open Sans", 15));
        sellerNameLabel.setTextFill(Color.web("#2f2f2f"));
        sellerNameLabel.setPadding(new Insets(5,0,0,0));

        Label sellerName = new Label(sellerDetail[1]);
        sellerName.setFont(new Font("Open Sans", 15));
        sellerName.setTextFill(Color.web("#191919"));
        sellerName.setPadding(new Insets(2,0,0,5));

        Label sellerDescriptionLabel = new Label("Description : ");
        sellerDescriptionLabel.setFont(new Font("Open Sans", 14));
        sellerDescriptionLabel.setTextFill(Color.web("#2f2f2f"));
        sellerDescriptionLabel.setPadding(new Insets(5,0,0,0));

        Label sellerDescription = new Label(sellerDetail[2]);
        sellerDescription.setFont(new Font("Open Sans", 15));
        sellerDescription.setTextFill(Color.web("#191919"));
        sellerDescription.setPadding(new Insets(2,0,0,5));
        sellerDescription.setWrapText(true);
        sellerDescription.setPrefWidth(0.50* main.window.getWidth());
        main.window.widthProperty().addListener(e-> sellerDescription.setPrefWidth(0.50*main.window.getWidth()));

        VBox commentsVb = fetchComments.fetchComments(productId);

        rightVB.getChildren().addAll(
                new HBox(5,categoryLabel, arrow, subcategoryLabel),
                productNameLabel,
                rate,
                new HBox(5,newP,discount),
                new HBox(15,delivery,new VBox(5,pinHb,message)),
                new HBox(5,sellerNameLabel,sellerName),
                new HBox(5,sellerDescriptionLabel,sellerDescription),
                commentsVb
        );
        rightVB.setPadding(new Insets(10));

        BorderPane items = new BorderPane(rightVB,null,null,null,leftPane);

        ScrollPane productScroller = new ScrollPane(items);
        productScroller.setFitToWidth(true);

        return productScroller;
    }

}
