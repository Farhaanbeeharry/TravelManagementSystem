package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlertBox {

    public static void alertBox(String alertMsg) {

        Stage alertStage = new Stage();
        alertStage.setTitle("Alert Box");
        alertStage.setResizable(false);

        GridPane alertPane = new GridPane();
        alertPane.setAlignment(Pos.CENTER);
        alertPane.setVgap(20);

        Label message = new Label();
        message.setText(alertMsg);
        message.setAlignment(Pos.CENTER);

        Button okBtn = new Button();
        okBtn.setText("OK");
        okBtn.setMinWidth(300);
        okBtn.setOnAction(e -> {
            alertStage.close();
        });

        alertPane.add(message, 0, 0);
        alertPane.add(okBtn, 0, 1);

        Scene scene = new Scene(alertPane, 600, 150);

        alertStage.setScene(scene);
        alertStage.show();
    }

}
