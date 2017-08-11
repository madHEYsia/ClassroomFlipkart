package com.ClassroomFlipkart.database.checkout;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.templates.checkout.itemDetail;
import com.ClassroomFlipkart.main.templates.home.homeProducts;
import com.ClassroomFlipkart.main.windows.home.main;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.ClassroomFlipkart.main.templates.home.profile.centerPane;

public class fetchitems {

    public static Label title;
    public static int size;
    public static BorderPane cartProduct;

    public static BorderPane itemList(String emailId) {

        cartProduct = new BorderPane();

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

                HBox bottom = new HBox(20,continueShopping,placeOrder);
                bottom.setPadding(new Insets(0,20,20,0));
                bottom.setAlignment(Pos.BASELINE_RIGHT);

                VBox leftVB = new VBox(15,
                        productPane,
                        bottom);
                leftVB.setPrefWidth(0.6* main.window.getWidth());
                main.window.widthProperty().addListener(e-> leftVB.setPrefWidth(0.6* main.window.getWidth()));

                cartProduct.setLeft(leftVB);
            }
            else {
                Label noResult = new Label("Your Cart is empty");
                noResult.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
                noResult.setPadding(new Insets(10));

                cartProduct.setCenter(noResult);
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
