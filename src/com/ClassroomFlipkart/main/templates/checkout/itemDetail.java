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

import static com.ClassroomFlipkart.database.checkout.fetchitems.*;
import static com.ClassroomFlipkart.database.checkout.fetchitems.pay;
import static com.ClassroomFlipkart.database.checkout.fetchitems.price;
import static com.ClassroomFlipkart.main.templates.home.profile.*;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class itemDetail {

    public static final Pattern VALID_STRING_REGEX = Pattern.compile("^\\s*$", Pattern.CASE_INSENSITIVE);

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

        priceOfItem = priceOfItem + currentQuantity[0]*Integer.parseInt(newPrice);
        amountToPay = amountToPay + currentQuantity[0]*Integer.parseInt(newPrice);
        savingAmount = savingAmount + currentQuantity[0]*(Integer.parseInt(oldPrice)-Integer.parseInt(newPrice));
        updateCharges(priceOfItem,amountToPay,savingAmount);

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

        Label quantity = new Label(currentQuantity[0]+"");
        quantity.setStyle("-fx-background-color: white; -fx-border-color: #f0f0f0; -fx-border-width: 1 1 1 1");
        quantity.setPrefSize(50,25);
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

            priceOfItem = priceOfItem + Integer.parseInt(newPrice);
            amountToPay = amountToPay + Integer.parseInt(newPrice);
            savingAmount = savingAmount + Integer.parseInt(oldPrice)-Integer.parseInt(newPrice);
            updateCharges(priceOfItem,amountToPay,savingAmount);

            if (currentQuantity[0]==9)
                increment.setDisable(true);
        });

        decrement.setOnAction(event -> {
            if (currentQuantity[0]==9)
                increment.setDisable(false);

            currentQuantity[0] = currentQuantity[0] - 1;
            updateItemQuantity.update(response[2],productId, currentQuantity[0]);
            quantity.setText(currentQuantity[0]+"");

            priceOfItem = priceOfItem - Integer.parseInt(newPrice);
            amountToPay = amountToPay - Integer.parseInt(newPrice);
            savingAmount = savingAmount - (Integer.parseInt(oldPrice)-Integer.parseInt(newPrice));
            updateCharges(priceOfItem,amountToPay,savingAmount);

            if (currentQuantity[0]==1)
                decrement.setDisable(true);
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

            if(size==1)
                priceItem.setText("Price ( "+size+" item ) : ");
            else
                priceItem.setText("Price ( "+size+" items ) : ");

            removeItem.remove(response[2],productId);

            priceOfItem = priceOfItem - currentQuantity[0]*Integer.parseInt(newPrice);
            amountToPay = amountToPay - currentQuantity[0]*Integer.parseInt(newPrice);
            savingAmount = savingAmount - currentQuantity[0]*(Integer.parseInt(oldPrice)-Integer.parseInt(newPrice));
            updateCharges(priceOfItem,amountToPay,savingAmount);

            if (size==0){

                Label noResult = new Label("Your Shopping Cart is empty");
                noResult.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
                noResult.setPadding(new Insets(10));

                Button continueShopping = GlyphsDude.createIconButton(
                        FontAwesomeIcon.BACKWARD,
                        "CONTINUE SHOPPING",
                        "18",
                        "16",
                        ContentDisplay.LEFT);
                continueShopping.setFont(Font.font("Open Sans", FontWeight.BOLD,15));
                continueShopping.setAlignment(Pos.CENTER);
                continueShopping.setTextFill(Paint.valueOf("#fff"));
                continueShopping.setStyle("-fx-background-color: grey;");
                continueShopping.setPadding(new Insets(10));
                continueShopping.setCursor(Cursor.HAND);
                continueShopping.setPrefWidth(200);
                continueShopping.setOnAction(event-> centerPane.setCenter(homeProducts.homeProducts()));

                String emptyCart = profile.class.getResource("../../resources/images/emptyCart.png").toExternalForm();
                Image emptyCartimg = new Image(emptyCart);
                ImageView emptyCartimgView = new ImageView(emptyCartimg);
                emptyCartimgView.setPreserveRatio(true);
                emptyCartimgView.setFitWidth(0.4* main.window.getWidth());
                main.window.widthProperty().addListener(event-> emptyCartimgView.setFitWidth(0.4 * main.window.getWidth()));

                cartProduct.getChildren().clear();
                VBox emptyCartVB = new VBox(20,emptyCartimgView,noResult,continueShopping);
                emptyCartVB.setPadding(new Insets(20,0,0,0));
                emptyCartVB.setAlignment(Pos.TOP_CENTER);
                cartProduct.setCenter(emptyCartVB);
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

    public static void updateCharges(int priceItem, int payAmount, int save){
        price.setText("₹ "+priceItem);
        pay.setText("₹ "+payAmount);
        saving.setText("Your Total Savings on this order ₹ "+save);

    }

    public static boolean whitespacevalidate(String Str) {
        Matcher matcher = VALID_STRING_REGEX .matcher(Str);
        return matcher.find();
    }

}
