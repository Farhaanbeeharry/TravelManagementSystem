package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Receipt {

    public static void receipt(String firstName, String lastName, String packageCode, int adult, int child, int senior, double total) {

        Stage stage = new Stage();
        stage.setTitle("Receipt");
        stage.setResizable(false);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(20);

        Label title = new Label();
        title.setText("Receipt");
        title.setFont(new Font(32));
        title.setAlignment(Pos.CENTER);

        Button closeBtn = new Button();
        closeBtn.setText("OK");
        closeBtn.setMinWidth(300);
        closeBtn.setOnAction(e -> {
            stage.close();
        });

        VBox titleVbox = new VBox(20);
        titleVbox.setAlignment(Pos.CENTER);
        titleVbox.getChildren().addAll(title);

        Text nameText = new Text("Name: " + firstName + " " + lastName);
        Text lineText1 = new Text("------------------------------------");
        Text packageCodeText = new Text("Package Code: " + packageCode);
        Text adultText = new Text("Number of Adults: " + adult);
        Text childText = new Text("Number of Children: " + child);
        Text seniorText = new Text("Number of Senior: " + senior);
        Text lineText2 = new Text("------------------------------------");
        Text totalText = new Text("Total Price = Rs" + total);
        Text lineText3 = new Text("------------------------------------");
        Text thankYouText = new Text("Thank you for your Booking!");


        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(nameText, lineText1, packageCodeText, adultText, childText, seniorText, lineText2, totalText, lineText3, thankYouText);

        pane.add(titleVbox, 0, 0);
        pane.add(vbox, 0, 1);
        pane.add(closeBtn, 0, 3);

        Scene scene = new Scene(pane, 400, 700);

        stage.setScene(scene);
        stage.show();


    }

}
