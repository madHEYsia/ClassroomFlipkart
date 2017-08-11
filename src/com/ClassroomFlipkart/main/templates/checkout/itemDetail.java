package com.ClassroomFlipkart.main.templates.checkout;

import com.ClassroomFlipkart.database.cart.fetchItemQuantity;
import com.ClassroomFlipkart.database.cart.updateItemQuantity;
import com.ClassroomFlipkart.database.logIn.userLoggedIn;
import com.ClassroomFlipkart.main.functions.getMotherboardSN;
import com.ClassroomFlipkart.main.templates.home.homeProducts;
import com.ClassroomFlipkart.main.templates.home.profile;
import com.ClassroomFlipkart.main.templates.product.products;
import com.ClassroomFlipkart.main.windows.home.main;
import com.ClassroomFlipkart.database.cart.removeItem;

import static com.ClassroomFlipkart.database.checkout.fetchitems.cartProduct;
import static com.ClassroomFlipkart.database.checkout.fetchitems.size;
import static com.ClassroomFlipkart.database.checkout.fetchitems.title;
import static com.ClassroomFlipkart.main.templates.home.profile.centerPane;
import static com.ClassroomFlipkart.main.templates.home.profile.itemsInCart;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class itemDetail {

    public static BorderPane view(String productId, String productName, String newPrice, String oldPrice, String category, String subcategory, String imageName, String productAvailability){

        final BorderPane[] pro = {new BorderPane()};

        Label availablity = new Label(productAvailability);
        availablity.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 10));
        availablity.setTextFill(Color.web("#fff"));
        availablity.setPadding(new Insets(2));
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
        imgView.setFitWidth(0.12* main.window.getWidth());
        main.window.widthProperty().addListener(e-> {
            if (main.window.getWidth() > 1000)          //this is kind of playing with media screen
            {
                imgView.setFitWidth(0.09 * main.window.getWidth());
            }
            else
                imgView.setFitWidth(0.12 * main.window.getWidth());
        });

        StackPane image = new StackPane(imgView, availabilityPane);
        image.setAlignment(Pos.TOP_LEFT);
        image.setCursor(Cursor.HAND);
        image.setOnMouseClicked(e->
                centerPane.setCenter(products.productDetail(productId, productName, newPrice, oldPrice, category, subcategory, imageName, productAvailability))
        );

        Label name = new Label(productName);
        name.setFont(Font.font("Open Sans", 15));
        name.setCursor(Cursor.HAND);
        name.setWrapText(true);
        name.setOnMouseClicked(e->
                centerPane.setCenter(products.productDetail(productId, productName, newPrice, oldPrice, category, subcategory, imageName, productAvailability))
        );

        Label newP = new Label("₹ "+newPrice);
        newP.setFont(Font.font("Open Sans",FontWeight.BOLD ,20));

        Label off = new Label((int)(100*(1.0 - Double.parseDouble(newPrice)/Double.parseDouble(oldPrice)))+"% off");
        off.setFont(Font.font("Open Sans", 14));
        off.setPadding(new Insets(5,0,0,0));
        off.setTextFill(Color.web("#388e3c"));

        String userID = getMotherboardSN.getMotherboardSN();
        String[] response = userLoggedIn.userLoggedIn(userID);
        final int[] currentQuantity = {fetchItemQuantity.getItems(response[2], productId)};

        Button decrement = GlyphsDude.createIconButton(
                FontAwesomeIcon.MINUS_CIRCLE,
                "",
                "20",
                "0",
                ContentDisplay.CENTER);
        decrement.setStyle("-fx-background-color: transparent");
        decrement.setCursor(Cursor.HAND);
        if (currentQuantity[0]==1)
            decrement.setDisable(true);

        TextField quantity = new TextField(currentQuantity[0]+"");
        quantity.setStyle("-fx-background-color: white; -fx-border-color: #f0f0f0; -fx-border-width: 1 1 1 1");
        quantity.setPrefColumnCount(5);
        quantity.setAlignment(Pos.CENTER);

        Button increment = GlyphsDude.createIconButton(
                FontAwesomeIcon.PLUS_CIRCLE,
                "",
                "20",
                "0",
                ContentDisplay.CENTER);
        increment.setStyle("-fx-background-color: transparent");
        increment.setCursor(Cursor.HAND);

        increment.setOnAction(event -> {
            if (currentQuantity[0]==1)
                decrement.setDisable(false);

            currentQuantity[0] = currentQuantity[0] + 1;
            updateItemQuantity.update(response[2], productId, currentQuantity[0]);
            quantity.setText(currentQuantity[0] + "");
        });

        decrement.setOnAction(event -> {
            currentQuantity[0] = currentQuantity[0] - 1;
            updateItemQuantity.update(response[2],productId, currentQuantity[0]);
            quantity.setText(currentQuantity[0]+"");
            if (currentQuantity[0]==1)
                decrement.setDisable(true);
        });
        quantity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                quantity.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        HBox hbquantity = new HBox(10,decrement,quantity,increment);

        Label remove = new Label("REMOVE");
        remove.setFont(Font.font("Open Sans", 16));
        remove.setAlignment(Pos.TOP_CENTER);
        remove.setCursor(Cursor.HAND);
        remove.setTextFill(Paint.valueOf("#222"));
        remove.setOnMouseEntered(e-> remove.setTextFill(Color.RED));
        remove.setOnMouseExited(e-> remove.setTextFill(Paint.valueOf("#222")));
        remove.setOnMouseClicked(e -> {
            pro[0].getChildren().clear();
            pro[0].setPadding(new Insets(0));
            size = size-1;
            title.setText("MY CART ( "+ size+" )");
            itemsInCart.setText(size+"");
            removeItem.remove(response[2],productId);
            if (size==0){

                Label noResult = new Label("Your Shopping Cart is empty");
                noResult.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
                noResult.setPadding(new Insets(10));

                Button continueShopping = GlyphsDude.createIconButton(
                        FontAwesomeIcon.STEP_BACKWARD,
                        "CONTINUE SHOPPING",
                        "18",
                        "16",
                        ContentDisplay.LEFT);
                continueShopping.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD,16));
                continueShopping.setAlignment(Pos.CENTER);
                continueShopping.setStyle("-fx-background-color: grey");
                continueShopping.setPadding(new Insets(10));
                continueShopping.setCursor(Cursor.HAND);
                continueShopping.setPrefWidth(200);
                continueShopping.setOnAction(event-> centerPane.setCenter(homeProducts.homeProducts()));

                cartProduct.getChildren().clear();
                cartProduct.setCenter(new VBox(30,noResult,continueShopping));
            }
        });

        VBox rightVB = new VBox(7,
                name,
                new HBox(15,newP,off),
                new HBox(20,hbquantity,remove));
        rightVB.setPadding(new Insets(0,0,0,15));

        StackPane item= new StackPane(new HBox(image,rightVB));
        item.setStyle("-fx-border-color: #c2c2c2; -fx-border-width: 0 0 1 0");
        item.setPadding(new Insets(10,15,10,0));

        HBox cartItem = new HBox(item);
        cartItem.setAlignment(Pos.TOP_CENTER);

        pro[0].setTop(cartItem);

        return pro[0];
    }

}
