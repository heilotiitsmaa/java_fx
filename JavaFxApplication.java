package com.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        // 1. Login view
        Label instructionText = new Label("Write the password and press Log in");
        PasswordField passwordField = new PasswordField();
        Button startButton = new Button("Log in");
        Label errorMessage = new Label("");

        // Layout for login
        GridPane layout = new GridPane();
        layout.add(instructionText, 0, 0);
        layout.add(passwordField, 0, 1);
        layout.add(startButton, 0, 2);
        layout.add(errorMessage, 0, 3);

        // Styling
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        // Scene for login
        Scene passwordView = new Scene(layout);

        // 2. Welcome view
        Label welcomeText = new Label("Welcome, this is the beginning!");
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeLayout);

        // 3. Button logic
        startButton.setOnAction(event -> {
            if (!passwordField.getText().trim().equals("password")) {
                errorMessage.setText("Unknown password!");
                return;
            }

            window.setScene(welcomeView);
        });

        // Set up window
        window.setScene(passwordView);
        window.setTitle("Password Protected App");
        window.show();
    }

    public static void main(String[] args) {
        launch(args); // <-- ainult nii, mitte klassi nimega
    }
}
