package com.ClassroomFlipkart.database.category;

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

public class getItems {

    public static BorderPane getItems(String category, String subcategory,double minmimum, double maximum) {

        BorderPane catProduct = new BorderPane();

        VBox products = new VBox(15);
        products.setPadding(new Insets(10,0,10,0));

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ",
                " classroomflipkart.productdetail ",
                "category = '"+category.replaceAll("'","`")+"' AND subcategory = '"+subcategory.replaceAll("'","`")+"' " +
                        "AND newPrice >= "+minmimum+" AND newPrice <= "+maximum+" ");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();

            if (size>0){
                rs.beforeFirst();

                Label title = new Label(subcategory+"");
                title.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
                title.setPadding(new Insets(10));

                HBox productList = new HBox(20);
                productList.setAlignment(Pos.TOP_CENTER);

                int count =0;
                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String newPrice = rs.getString("newPrice");
                    String oldPrice = rs.getString("oldPrice");
                    String imageName = rs.getString("imageName");
                    String productAvailability = rs.getString("productAvailability");

                    if (count++ % 4 == 0){
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

                StackPane titlePane = new StackPane(title);
                titlePane.setAlignment(Pos.TOP_LEFT);

                StackPane productPane = new StackPane(proScroller);

                catProduct.setTop(titlePane);
                catProduct.setCenter(productPane);
            }
            else {
                Label noResult = new Label("No product found in range "+ minmimum+" - "+maximum);
                noResult.setFont(Font.font("Open Sans", FontWeight.BOLD,20));
                noResult.setPadding(new Insets(10));
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
