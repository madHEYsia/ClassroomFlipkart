package com.ClassroomFlipkart.database.search;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.templates.home.productDetail;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class searchByKeyword {

    public static BorderPane search(String keyword) {

        BorderPane catProduct = new BorderPane();

        VBox products = new VBox(15);
        products.setPadding(new Insets(10,0,10,0));

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(
                " * ",
                " classroomflipkart.productdetail ",
                "productName LIKE '%"+keyword+"%' OR category LIKE '%"+keyword+"%' OR subcategory LIKE '%"+keyword+"%'"
        );

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();

            Label title = new Label("Search Results");
            title.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
            title.setPadding(new Insets(10));

            StackPane titlePane = new StackPane(title);
            titlePane.setAlignment(Pos.TOP_LEFT);
            catProduct.setTop(titlePane);

            if (size>0){
                rs.beforeFirst();

                HBox productList = new HBox(20);
                productList.setAlignment(Pos.TOP_CENTER);

                int count =0;
                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String newPrice = rs.getString("newPrice");
                    String oldPrice = rs.getString("oldPrice");
                    String imageName = rs.getString("imageName");
                    String category = rs.getString("category");
                    String subcategory = rs.getString("subcategory");
                    String productAvailability = rs.getString("productAvailability");

                    if (count++ % 5 == 0){
                        products.getChildren().add(productList);
                        productList= new HBox(20);
                    }

                    productList.setAlignment(Pos.TOP_CENTER);

                    productList.getChildren().add(productDetail.productByType(productId,productName,newPrice,oldPrice,category,subcategory,imageName, productAvailability));
                }

                products.getChildren().add(productList);

                ScrollPane proScroller = new ScrollPane(products);
                proScroller.setFitToHeight(true);
                proScroller.setFitToWidth(true);
                proScroller.setPannable(true);
                proScroller.setPadding(new Insets(0,0,30,0));

                StackPane productPane = new StackPane(proScroller);

                catProduct.setCenter(productPane);
            }
            else {
                Label noResult = new Label("Sorry, No products found.");
                noResult.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
                noResult.setPadding(new Insets(10));

                catProduct.setCenter(noResult);
            }

        } catch (Exception e) {
            catProduct.setCenter(new Label(e.getMessage()));
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return catProduct;
        }
    }

}
