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

    // Constants for easier maintenance
    private static final String CORRECT_PASSWORD = "password";
    private static final int WIDTH = 350;
    private static final int HEIGHT = 200;

    @Override
    public void start(Stage window) {
        // Create the scenes using helper methods
        Scene loginView = createLoginView(window);
        
        // Configure the main stage
        window.setScene(loginView);
        window.setTitle("Secure Login");
        window.setResizable(false);
        window.show();
    }

    /**
     * Creates the Login Scene with all its logic.
     */
    private Scene createLoginView(Stage window) {
        // Components
        Label instructionText = new Label("Please enter your password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Log in");
        Label errorMessage = new Label("");
        errorMessage.setStyle("-fx-text-fill: red;"); // Minimal styling in code

        // Layout setup
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(12);
        layout.setHgap(10);
        layout.setPadding(new Insets(20));

        // Adding components to grid
        layout.add(instructionText, 0, 0);
        layout.add(passwordField, 0, 1);
        layout.add(loginButton, 0, 2);
        layout.add(errorMessage, 0, 3);

        // Login logic encapsulated in a single action
        Runnable loginTask = () -> {
            if (passwordField.getText().equals(CORRECT_PASSWORD)) {
                window.setScene(createWelcomeView());
            } else {
                errorMessage.setText("Wrong password! Try again.");
                passwordField.clear();
                passwordField.requestFocus(); // Put cursor back to field
            }
        };

        // Trigger login on button click OR when pressing Enter
        loginButton.setOnAction(e -> loginTask.run());
        passwordField.setOnAction(e -> loginTask.run());

        return new Scene(layout, WIDTH, HEIGHT);
    }

    /**
     * Creates the Welcome Scene.
     */
    private Scene createWelcomeView() {
        Label welcomeText = new Label("Welcome, you are logged in!");
        welcomeText.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        StackPane layout = new StackPane(welcomeText);
        layout.setAlignment(Pos.CENTER);
        
        return new Scene(layout, WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        launch(args);
    }
}