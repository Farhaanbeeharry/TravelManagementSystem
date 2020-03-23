package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Label title = new Label();
        title.setText("Travel Management System");
        vbox.getChildren().add(title);

        Button bookingBtn = new Button("Make Booking");
        bookingBtn.setMinWidth(500);
        bookingBtn.setOnAction(e -> {
            Add.addBooking();
        });

        Button addPackageBtn = new Button("Add New Package");
        addPackageBtn.setMinWidth(500);
        addPackageBtn.setOnAction(e -> {
            Add.addPackage();
        });

        Button packagesBtn = new Button("List Packages");
        packagesBtn.setMinWidth(500);
        packagesBtn.setOnAction(e -> {
            List.listPackages(0);
        });

        Button packagesSortedBtn = new Button("List Packages (Alphabetical Order of Place Name)");
        packagesSortedBtn.setMinWidth(500);
        packagesSortedBtn.setOnAction(e -> {
            List.listPackages(1);
        });

        Button bookingsBtn = new Button("View All Bookings");
        bookingsBtn.setMinWidth(500);
        bookingsBtn.setOnAction(e -> {
            List.listBookings();
        });

        Button searchBtn = new Button("Search Package via Place Name");
        searchBtn.setMinWidth(500);
        searchBtn.setOnAction(e -> {
            Search.searchPlaceName();
        });

        Button contactUsBtn = new Button("Contact Us");
        contactUsBtn.setMinWidth(500);
        contactUsBtn.setOnAction(e -> {
            Contact.contactUs();
        });

        Button exitBtn = new Button("Exit");
        exitBtn.setMinWidth(500);
        exitBtn.setOnAction(e -> {
            System.exit(0);
        });

        gridPane.getChildren().add(vbox);
        gridPane.add(bookingBtn, 0, 1);
        gridPane.add(addPackageBtn, 0, 2);
        gridPane.add(packagesBtn, 0, 3);
        gridPane.add(packagesSortedBtn, 0, 4);
        gridPane.add(bookingsBtn, 0, 5);
        gridPane.add(searchBtn, 0, 6);
        gridPane.add(contactUsBtn, 0, 7);
        gridPane.add(exitBtn, 0, 8);

        Scene scene = new Scene(gridPane);

        primaryStage.setTitle("Travel Management System");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
