package com.ClassroomFlipkart.database.checkout;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.templates.checkout.itemDetail;
import com.ClassroomFlipkart.main.templates.home.homeProducts;
import com.ClassroomFlipkart.main.templates.home.profile;
import com.ClassroomFlipkart.main.windows.home.main;
import com.ClassroomFlipkart.database.address.fetch;
import com.ClassroomFlipkart.database.orders.addOrders;

import static com.ClassroomFlipkart.main.templates.home.profile.centerPane;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import javafx.stage.Popup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fetchitems {

    public static int size;
    public static int priceOfItem;
    public static int amountToPay;
    public static int savingAmount;

    public static Label title;
    public static Label priceItem;
    public static Label price;
    public static Label pay;
    public static Label saving;

    public static BorderPane cartProduct;
    public static ScrollPane addressScroller;
    public static BorderPane itemList(String emailId) {

        priceOfItem = 0;
        amountToPay = 0;
        savingAmount = 0;

        cartProduct = new BorderPane();

        Label priceTitle = new Label("PRICE DETAILS");
        priceTitle.setFont(Font.font("Open Sans", FontWeight.BOLD, 18));
        priceTitle.setStyle("-fx-background-color: #2874f0");
        priceTitle.setPrefWidth(300);
        priceTitle.setTextFill(Paint.valueOf("#fff"));
        priceTitle.setPadding(new Insets(10,10,10,30));

        priceItem = new Label();
        priceItem.setFont(Font.font("Open Sans", 15));
        priceItem.setPadding(new Insets(10,5,5,30));

        price = new Label("₹ "+priceOfItem);
        price.setFont(Font.font("Open Sans", 15));
        price.setPadding(new Insets(15,20,5,30));

        BorderPane pricePane = new BorderPane(null,null,price,null,priceItem);

        Label deliveryCharges = new Label("Delivery Charges :");
        deliveryCharges.setFont(Font.font("Open Sans", 15));
        deliveryCharges.setPadding(new Insets(5,5,5,30));

        Label charges = new Label(" FREE ");            //curently its free. Need to change this.
        charges.setFont(Font.font("Open Sans", 15));
        charges.setPadding(new Insets(5,20,5,30));

        BorderPane deliveryPane = new BorderPane(null,null,charges,null,deliveryCharges);
        deliveryPane.setStyle("-fx-border-color: #c2c2c2; -fx-border-width: 0 0 1 0");

        Label amountPayable = new Label("Amount Payable:");
        amountPayable.setFont(Font.font("Open Sans", FontWeight.BOLD, 18));
        amountPayable.setPadding(new Insets(10,10,10,30));

        pay = new Label("₹ "+amountToPay);
        pay.setFont(Font.font("Open Sans", FontWeight.BOLD, 18));
        pay.setPadding(new Insets(5,20,5,30));

        BorderPane amountPayablePane = new BorderPane(null,null,pay,null,amountPayable);
        amountPayablePane.setStyle("-fx-border-color: #c2c2c2; -fx-border-width: 0 0 1 0");

        saving = new Label("Your Total Savings on this order ₹ "+savingAmount);
        saving.setFont(Font.font("Open Sans", 15));
        saving.setPrefWidth(300);
        saving.setTextFill(Paint.valueOf("green"));
        saving.setWrapText(true);
        saving.setPadding(new Insets(10,10,20,30));

        Label addressTitle = new Label("ADDRESS SAVED ");
        addressTitle.setFont(Font.font("Open Sans", FontWeight.BOLD, 18));
        addressTitle.setStyle("-fx-background-color: #2874f0");
        addressTitle.setPrefWidth(300);
        addressTitle.setTextFill(Paint.valueOf("#fff"));
        addressTitle.setPadding(new Insets(10,10,10,30));

        addressScroller = new ScrollPane(fetch.getAddress(emailId));
        addressScroller.setFitToWidth(true);
        addressScroller.setPrefHeight(main.window.getHeight()-505);
        main.window.heightProperty().addListener(e-> addressScroller.setPrefHeight(main.window.getHeight()-505));

        Button newAddress = GlyphsDude.createIconButton(
                FontAwesomeIcon.PLUS_SQUARE,
                "ADD ADDRESS ",
                "18",
                "18",
                ContentDisplay.LEFT);
        newAddress.setFont(Font.font("Open Sans", FontWeight.BOLD, 14));
        newAddress.setTextFill(Paint.valueOf("#fff"));
        newAddress.setStyle("-fx-background-color: #2874f0");
        newAddress.setPadding(new Insets(10));

        StackPane newAdd = new StackPane(newAddress);
        newAdd.setPadding(new Insets(0,0,0,10));
        newAdd.setAlignment(Pos.BASELINE_LEFT);
        newAdd.setCursor(Cursor.HAND);

        VBox rightVB = new VBox(0,
                priceTitle,
                pricePane,
                deliveryPane,
                amountPayablePane,
                saving,
                addressTitle,
                addressScroller,
                newAdd
        );
        rightVB.setPrefSize(300,500);
        rightVB.setPadding(new Insets(-40,30,0,0));

        VBox products = new VBox(0);
        products.setPadding(new Insets(10,10,10,30));
        products.setAlignment(Pos.TOP_LEFT);

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(
                " * ",
                " classroomflipkart.productdetail AS S ," +
                        "( "+DBUtils.prepareSelectQuery(
                        " quantity, productId AS cartproductId ",
                        " classroomflipkart.cartdetails ",
                        "emailId = '"+emailId+"' ")+" "+
                        ") AS T",
                " T.cartproductId  = S.productId");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            size = rs.getRow();

            if(size==1)
                priceItem.setText("Price ( "+size+" item ) : ");
            else
                priceItem.setText("Price ( "+size+" items ) : ");

            title = new Label("MY CART ( "+size+" )");
            title.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
            title.setPadding(new Insets(10,10,10,30));
            title.setStyle("-fx-border-color: #c2c2c2; -fx-border-width: 0 0 2 0");

            StackPane titlePane = new StackPane(title);
            titlePane.setAlignment(Pos.TOP_LEFT);
            cartProduct.setTop(titlePane);

            if (size>0){
                rs.beforeFirst();

                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String newPrice = rs.getString("newPrice");
                    String oldPrice = rs.getString("oldPrice");
                    String category = rs.getString("category");
                    String subcategory = rs.getString("subcategory");
                    String imageName = rs.getString("imageName");
                    String productAvailability = rs.getString("productAvailability");

                    products.getChildren().add(itemDetail.view(productId, productName, newPrice, oldPrice, category, subcategory, imageName, productAvailability));

                }

                ScrollPane proScroller = new ScrollPane(products);
                proScroller.setFitToHeight(true);
                proScroller.setFitToWidth(true);
                proScroller.setPannable(true);
                proScroller.setPadding(new Insets(0,0,30,0));

                StackPane productPane = new StackPane(proScroller);

                Button continueShopping = GlyphsDude.createIconButton(
                        FontAwesomeIcon.STEP_BACKWARD,
                        "CONTINUE SHOPPING",
                        "16",
                        "16",
                        ContentDisplay.LEFT);
                continueShopping.setFont(Font.font("Open Sans", FontWeight.BOLD,15));
                continueShopping.setAlignment(Pos.CENTER);
                continueShopping.setTextFill(Paint.valueOf("#fff"));
                continueShopping.setStyle("-fx-background-color: lightgrey");
                continueShopping.setPadding(new Insets(10));
                continueShopping.setCursor(Cursor.HAND);
                continueShopping.setPrefWidth(200);
                continueShopping.setOnAction(event-> centerPane.setCenter(homeProducts.homeProducts()));

                Button placeOrder = new Button("PLACE ORDER");
                placeOrder.setFont(Font.font("Open Sans", FontWeight.BOLD,15));
                placeOrder.setAlignment(Pos.CENTER);
                placeOrder.setTextFill(Paint.valueOf("#fff"));
                placeOrder.setStyle("-fx-background-color: #fb641b");
                placeOrder.setPadding(new Insets(10));
                placeOrder.setCursor(Cursor.HAND);
                placeOrder.setPrefWidth(200);
                placeOrder.setOnAction(e-> {
                    String status = addOrders.add(emailId);

                    Label statuslabel = new Label();
                    statuslabel.setFont(Font.font("Open Sans", FontWeight.SEMI_BOLD, 14));
                    statuslabel.setTextFill(Color.web("#fff"));
                    statuslabel.setAlignment(Pos.TOP_CENTER);

                    BorderPane added = new BorderPane(statuslabel);
                    added.setPadding(new Insets(15));

                    if (status.equals("success")){
                        statuslabel.setText("ORDER CONFIRMED. \nYou are now redirected to home page");
                        added.setStyle("-fx-background-color: #191919;");
                    }
                    else{
                        statuslabel.setText("SORRY. YOU ORDER CANNOT BE CONFIRMED. \nTRY LATER");
                        added.setStyle("-fx-background-color: #ff4040;");
                    }

                    final Popup popup = new Popup();
                    popup.setX(main.window.getX()+0.5*main.window.getWidth()-120);
                    popup.setY(main.window.getY()+ main.window.getHeight() - 80);
                    popup.getContent().add(added);
                    popup.show(main.window);

                    Task<Void> sleeper = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    };
                    sleeper.setOnSucceeded(event-> {
                        popup.hide();
                        if (status.equals("success"))
                            centerPane.setCenter(homeProducts.homeProducts());
                    });
                    new Thread(sleeper).start();

                });


                HBox bottom = new HBox(20,continueShopping,placeOrder);
                bottom.setPadding(new Insets(0,20,20,0));
                bottom.setAlignment(Pos.BASELINE_RIGHT);

                VBox leftVB = new VBox(15,
                        productPane,
                        bottom);
                leftVB.setPrefWidth(0.6* main.window.getWidth());
                main.window.widthProperty().addListener(e-> leftVB.setPrefWidth(0.6* main.window.getWidth()));

                cartProduct.setLeft(leftVB);
                cartProduct.setRight(rightVB);
            }
            else {

                Label noResult = new Label("Your Shopping Cart is empty");
                noResult.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
                noResult.setPadding(new Insets(10));

                Button continueShopping = GlyphsDude.createIconButton(
                        FontAwesomeIcon.BACKWARD,
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

        } catch (Exception e) {
            cartProduct.setCenter(new Label(e.getMessage()));
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return cartProduct;
        }
    }

}
