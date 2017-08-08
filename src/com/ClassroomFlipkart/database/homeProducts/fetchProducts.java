package com.ClassroomFlipkart.database.homeProducts;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.main.templates.home.productDetail;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fetchProducts {

    public static BorderPane productbyType(String type) {

        BorderPane products = new BorderPane();
        products.setPadding(new Insets(10,20,10,20));

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ",
                " classroomflipkart.productdetail AS T ," +
                        " ( "+ DBUtils.prepareSelectQuery("productId",
                                " classroomflipkart.homeproducts ",
                                "type = '"+type+"'")+
                        " ) AS S",
                " T.productId = S.productId ");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();

            if (size>0){
                rs.beforeFirst();

                Label title = new Label(type+"");
                title.setFont(Font.font("Open Sans", FontWeight.BOLD,17));
                title.setPadding(new Insets(10));
                title.setAlignment(Pos.CENTER);

                HBox productList = new HBox(20);
                productList.setAlignment(Pos.CENTER);

                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String newPrice = rs.getString("newPrice");
                    String oldPrice = rs.getString("oldPrice");
                    String imageName = rs.getString("imageName");

                    productList.getChildren().add(productDetail.productByType(productId,productName,newPrice,oldPrice,imageName));
                }

                ScrollPane proScroller = new ScrollPane(productList);
                proScroller.setFitToHeight(true);
                proScroller.setFitToWidth(true);
                proScroller.setPannable(true);
                proScroller.setPadding(new Insets(0,0,30,0));

                StackPane titlePane = new StackPane(title);
                titlePane.setAlignment(Pos.CENTER);

                StackPane productPane = new StackPane(proScroller);
                productPane.setAlignment(Pos.CENTER);

                products.setTop(titlePane);
                products.setCenter(productPane);
            }


        } catch (Exception e) {
            products.setCenter(new Label(e.getMessage()));
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return products;
        }
    }

}
