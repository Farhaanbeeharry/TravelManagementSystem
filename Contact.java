package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Contact {

    public static void contactUs() {

        double labelFontSize = 30.0;

        Stage stage = new Stage();
        stage.setTitle("Contact Us");
        stage.setMaximized(true);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);

        Label title = new Label();
        title.setMinWidth(500);
        title.setMaxWidth(500);
        title.setFont(new Font(labelFontSize));
        title.setAlignment(Pos.CENTER);
        title.setText("Contact Us");

        try {
            Image contactImage = new Image(new FileInputStream("src/sample/images/map.jpg"));
            ImageView contactImageView = new ImageView(contactImage);
            contactImageView.setFitHeight(500);
            contactImageView.setPreserveRatio(true);

        Text phoneNo = new Text("Phone Number: +230 1234 5678");
        phoneNo.setTextAlignment(TextAlignment.CENTER);

        Text emailAdd = new Text("Email Address: bajadansbol@gmail.com");
        emailAdd.setTextAlignment(TextAlignment.CENTER);

        Text address = new Text("Address: Royal Road, Port-Louis, Mauritius");
        address.setTextAlignment(TextAlignment.CENTER);

        Button backBtn = new Button("Back");
        backBtn.setMinWidth(300);
        backBtn.setOnAction(e -> {
            stage.close();
        });

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(title, contactImageView, phoneNo, emailAdd, address, backBtn);

            gridPane.add(vbox, 0, 0);

        } catch(IOException e) {
            AlertBox.alertBox("File not found!");
        }


        Scene scene = new Scene(gridPane);

        stage.setScene(scene);
        stage.show();

    }
}
