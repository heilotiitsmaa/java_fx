package application;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String title = params.getNamed().get("title");

        window.setTitle(title);
        window.show();
    }
}