package com.ClassroomFlipkart.main.templates;

import com.ClassroomFlipkart.main.functions.timeStampChangeFormat;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class commentFormat {

    public static BorderPane formatcomment(String timestamp, String comment){

        BorderPane notice = new BorderPane();
        notice.setPadding(new Insets(0,-20,0,10));
        notice.setMaxWidth(340);

        VBox noticeVB = new VBox(5);
        noticeVB.setStyle("-fx-background-color: transparent; -fx-border-color: #333; -fx-border-width: 1,1,1,1; -fx-border-radius: 10; -fx-text-color: #333;");

        Label commentLabel = new Label(comment);
        commentLabel.setPadding(new Insets(5));
        commentLabel.setFont(new Font("Cambria", 16));
        commentLabel.setTextFill(Color.web("#191919"));
        commentLabel.setWrapText(true);
        commentLabel.setMaxWidth(320);
        commentLabel.setAlignment(Pos.BOTTOM_LEFT);

        Label time = new Label(timeStampChangeFormat.timeStampChangeFormat(timestamp));
        time.setFont(new Font("Cambria", 12));
        time.setTextFill(Color.web("#4c4c4c"));
        time.setPadding(new Insets(5));
        time.setMaxWidth(320);
        time.setAlignment(Pos.BOTTOM_LEFT);

        noticeVB.getChildren().addAll(commentLabel,time);
        notice.setLeft(noticeVB);
        noticeVB.setStyle("-fx-background-color: #fff");

        return notice;

    }
}
