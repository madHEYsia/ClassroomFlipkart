package com.ClassroomFlipkart.main.templates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class loginHome {

    public  static String image;

    public static Scene homeView(){

        BorderPane view = new BorderPane();

        Label title = new Label("Classroom Flipkart");
        title.setFont(new Font("Open Sans", 60));
        title.setTextFill(Color.web("#ededed"));

        HBox header = new HBox(25);
        header.setMinHeight(30);
        header.setAlignment(Pos.TOP_CENTER);

        Label login = new Label("Login");
        login.setPadding(new Insets(5));
        login.setFont(new Font("Open Sans", 20));
        login.setTextFill(Color.web("#ededed"));
        login.setCursor(Cursor.HAND);
        login.setStyle(" -fx-border-color: red; -fx-border-width: 0 0 3 0; -fx-border-insets: 0 0 1 0; ");

        Label register = new Label("Register");
        register.setPadding(new Insets(5));
        register.setFont(new Font("Open Sans", 20));
        register.setTextFill(Color.web("#ededed"));
        register.setCursor(Cursor.HAND);

        header.getChildren().addAll(login, register);

        userLogin loginObject = new userLogin();
        userSignUp signUpObject = new userSignUp();

        BorderPane credential = new BorderPane(loginObject.userLogin(), header, null, null, null);
        credential.setMaxWidth(350);
        credential.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-border-color: grey; -fx-border-width: 1 1 1 1;");

        login.setOnMouseClicked(e->{
            credential.setCenter(loginObject.userLogin());
            login.setStyle(" -fx-border-color: red; -fx-border-width: 0 0 3 0; -fx-border-insets: 0 0 1 0; ");
            register.setStyle("");
        });

        register.setOnMouseClicked(e->{
            credential.setCenter(signUpObject.userSignUp());
            login.setStyle("");
            register.setStyle(" -fx-border-color: red; -fx-border-width: 0 0 3 0; -fx-border-insets: 0 0 1 0; ");
        });

        VBox centerVB = new VBox(30);
        centerVB.setAlignment(Pos.CENTER);
        centerVB.getChildren().addAll(title, credential);

        view.setCenter(centerVB);

        Scene scene = new Scene(view,800,500);
        scene.getStylesheets().add(loginHome.class.getResource("../resources/css/main.css").toExternalForm());

        image = loginHome.class.getResource("../resources/images/splash.jpg").toExternalForm();
        view.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-size: cover, auto; " +
                "-fx-background-repeat: stretch;");

        return  scene;
    }
}
