package com.ClassroomFlipkart.main.templates;

import com.ClassroomFlipkart.database.logIn.dbLoginCheck;
import com.ClassroomFlipkart.main.templates.home.profile;
import com.ClassroomFlipkart.main.windows.home.main;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userLogin {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public String[] status;
    final BooleanProperty firstTime = new SimpleBooleanProperty(true); // Variable to store the focus on stage load

    public BorderPane userLogin(){

        BorderPane loginPane = new BorderPane();
        loginPane.setPadding(new Insets(20));

        VBox vb = new VBox(15);
        vb.setPadding(new Insets(20));

        TextField emailId = new TextField();
        emailId.setPromptText("Email fetch");
        emailId.setFont(new Font("Open Sans", 15));
        emailId.setPrefHeight(30);
        emailId.setStyle("-fx-background-color: transparent; -fx-border-color: #ededed; -fx-border-width: 2,2,2,2; -fx-border-radius: 200; -fx-text-inner-color: #ededed;");
        emailId.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
            if(newValue && firstTime.get()){
                loginPane.requestFocus(); // Delegate the focus to container
                firstTime.setValue(false); // Variable value changed for future references
            }
        });

        PasswordField password = new PasswordField();
        password.setPromptText("password");
        password.setFont(new Font("Open Sans", 15));
        password.setPrefHeight(30);
        password.setStyle("-fx-background-color: transparent; -fx-border-color: #ededed; -fx-border-width: 2,2,2,2; -fx-border-radius: 200; -fx-text-inner-color: #ededed;");

        Label error = new Label();
        error.setTextFill(Color.web("red"));

        HBox loginRow = new HBox();
        Button loginButton = new Button("Login");
        loginButton.setFont(new Font("Open Sans", 18));
        loginButton.setStyle("-fx-focus-color: transparent;-fx-background-color: #6ac045;");
        loginButton.setTextFill(Color.web("#ededed"));
        loginRow.getChildren().addAll(loginButton);
        loginRow.setAlignment(Pos.BASELINE_CENTER);

        loginButton.setOnAction(e-> {
            e.consume();
            if (emailId.getText().isEmpty())
                error.setText("Username or EmailId can't be empty");
            else if (!validate(emailId.getText()))
                error.setText("Email ID incorrect");
            else if (password.getText().isEmpty())
                error.setText("Password can't be empty");
            else{
                status = dbLoginCheck.dbLoginCheck(emailId.getText(),password.getText());
                if (status[0].equals("success")){
                    main.window.setScene(profile.main(status[1], emailId.getText()));
                }
                else
                    error.setText("Incorrect Username / Email Id or password !");
            }
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(ee-> {
                error.setTextFill(Color.web("red"));
                error.setText("");
            });
            new Thread(sleeper).start();
        });

        vb.getChildren().addAll(emailId, password, error, loginRow);
        loginPane.setCenter(vb);
        loginPane.setPrefHeight(332);

        return loginPane;
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}
