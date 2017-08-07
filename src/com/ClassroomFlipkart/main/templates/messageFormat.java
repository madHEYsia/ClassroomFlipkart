package com.ClassroomFlipkart.main.templates;

import com.ClassroomFlipkart.main.functions.timeStampChangeFormat;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class messageFormat {

    public static BorderPane formatmessage(String timestamp, String message, String position){

        BorderPane notice = new BorderPane();
        notice.setPadding(new Insets(0,-20,0,10));
        notice.setMaxWidth(340);

        VBox noticeVB = new VBox(5);
        noticeVB.setStyle("-fx-background-color: transparent; -fx-border-color: #333; -fx-border-width: 1,1,1,1; -fx-border-radius: 10; -fx-text-color: #333;");

        Label messageLabel = new Label(message);
        messageLabel.setPadding(new Insets(5));
        messageLabel.setFont(new Font("Cambria", 16));
        messageLabel.setTextFill(Color.web("#191919"));
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(320);

        Label time = new Label(timeStampChangeFormat.timeStampChangeFormat(timestamp));
        time.setFont(new Font("Cambria", 12));
        time.setTextFill(Color.web("#4c4c4c"));
        time.setPadding(new Insets(5));
        time.setMaxWidth(320);

        noticeVB.getChildren().addAll(messageLabel,time);

        if (position.equals("left")){
            messageLabel.setAlignment(Pos.BOTTOM_LEFT);
            time.setAlignment(Pos.BOTTOM_LEFT);
            notice.setLeft(noticeVB);
            noticeVB.setStyle("-fx-background-color: #fff");
        }
        else if (position.equals("right")){
            messageLabel.setAlignment(Pos.BOTTOM_RIGHT);
            time.setAlignment(Pos.BOTTOM_RIGHT);
            notice.setRight(noticeVB);
            noticeVB.setStyle("-fx-background-color: #ccccdd");
        }

        return notice;

    }
}
