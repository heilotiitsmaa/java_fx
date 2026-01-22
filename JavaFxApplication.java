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
/**
 * A simple JavaFX application demonstrating a login screen 
 * and switching between different scenes.
 */

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        // 1. INITIALIZING LOGIN VIEW COMPONENTS ---
        Label instructionText = new Label("Write pass and press Log in");
        PasswordField passwordField = new PasswordField();
        Button startButton = new Button("Log in");
        Label errorMessage = new Label(""); // Placeholder for error messages

        // Create a GridPane layout for organized positioning (Rows/Columns)
        GridPane layout = new GridPane();
        layout.add(instructionText, 0, 0); // Column 0, Row 0
        layout.add(passwordField, 0, 1); // Column 0, Row 1
        layout.add(startButton, 0, 2); // Column 0, Row 2
        layout.add(errorMessage, 0, 3); // Column 0, Row 3

        // UI Styling: sizing, alignment, and spacing
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10); // Vertical gap between components
        layout.setHgap(10); // Horizontal gap between components
        layout.setPadding(new Insets(20, 20, 20, 20));

        // Create the first Scene (Login View)
        Scene passwordView = new Scene(layout);

        // 2. INITIALIZING WELCOME VIEW ---
        Label welcomeText = new Label("Welcome, this is the beginning!");
        StackPane welcomeLayout = new StackPane(); // StackPane centers content by default
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        // Create the second Scene (Welcome View)
        Scene welcomeView = new Scene(welcomeLayout);

        // --- 3. EVENT HANDLING / LOGIC ---
        // Define what happens when the login button is clicked
        startButton.setOnAction(event -> {
            // Check if password matches "password" (trimmed to remove accidental spaces)
            if (!passwordField.getText().trim().equals("password")) {
                errorMessage.setText("Unknown password!");
                return; // Stop execution if password is wrong
            }

            // If correct, switch the scene shown in the primary window
            window.setScene(welcomeView);
        });

        // 4. STAGE CONFIGURATION ---
        window.setScene(passwordView); // Set the initial scene
        window.setTitle("Password Protected App");
        window.show(); // Display the window
    }

    public static void main(String[] args) {
        // Launches the JavaFX application
        launch(args);
    }
}
