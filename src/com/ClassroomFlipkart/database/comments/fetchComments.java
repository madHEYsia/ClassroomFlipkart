package com.ClassroomFlipkart.database.comments;

import com.ClassroomFlipkart.database.utils.DBUtils;
import com.ClassroomFlipkart.database.userDetail.getUserName;
import com.ClassroomFlipkart.main.functions.timeStampChangeFormat;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fetchComments {

    public static VBox fetchComments(String productId) {

        VBox comments = new VBox();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ",
                " classroomflipkart.productcoment ",
                "productId = '"+productId+"' ",
                "ORDER BY timestamp desc");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();

            if (size>0) {
                rs.beforeFirst();
                while (rs.next()){
                    String productRating = rs.getString("productRating");
                    String productComent = rs.getString("productComent");
                    String emailId = rs.getString("emailId");
                    String timestamp = rs.getString("timestamp");

                    comments.getChildren().add(comment(productRating,productComent,emailId, timestamp));
                }
            }

        } catch (Exception e) {
            comments.getChildren().add(new Label(e.getMessage()));
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return comments;
        }
    }

    public static BorderPane comment(String rate, String commentTitle, String emailId, String timestamp ){

        Label rating = GlyphsDude.createIconLabel(
                FontAwesomeIcon.STAR,
                rate+"",
                "14",
                "14",
                ContentDisplay.RIGHT
        );
        rating.setFont(Font.font("Open Sans", FontWeight.THIN, 14));
        rating.setTextFill(Color.web("#000"));
        rating.setStyle("-fx-background-color: #388e3c");
        rating.setPadding(new Insets(5,10,5,10));

        Label commentTitleLabel = new Label(commentTitle);
        commentTitleLabel.setFont(Font.font("Open Sans",FontWeight.NORMAL, 15));
        commentTitleLabel.setTextFill(Color.web("#222"));

        HBox rateHB = new HBox(10,rating, commentTitleLabel);
        rateHB.setAlignment(Pos.CENTER_LEFT);
        rateHB.setPadding(new Insets(0,10,5,0));

        String[] user = getUserName.getUserName(emailId);

        String userCertificate = user[1].equals("yes") ? "Certified Buyer" : "Flipkart Customer";

        Label userName = new Label("\t\t"+user[0]+", ");
        userName.setFont(Font.font("Open Sans",FontWeight.NORMAL, 13.5));
        userName.setTextFill(Color.web("#666"));

        Label userCertificateLabel = new Label(userCertificate);
        userCertificateLabel.setFont(Font.font("Open Sans",FontWeight.NORMAL, 13.5));
        userCertificateLabel.setTextFill(Color.web("#666"));

        Label time = new Label(timeStampChangeFormat.timeStampChangeFormat(timestamp)+"");
        time.setFont(Font.font("Open Sans",FontWeight.NORMAL, 13.5));
        time.setTextFill(Color.web("#666"));

        BorderPane comment = new BorderPane(
                new HBox(10,userName,userCertificateLabel,time),
                rateHB,
                null,
                null,
                null
        );
        comment.setStyle("-fx-background-color: transparent");
        comment.setPadding(new Insets(0,0,10,20));

        return comment;

    }

}
