package application;

import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = sc.nextLine();

        Application.launch(JavaFxApplication.class,
        "--title="+title);
    }
}
