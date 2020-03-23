package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.Handle;

public class Search {

    static Stage stage;
    static TextField inputPlaceName;

    public static void searchPlaceName() {

        stage = new Stage();
        stage.setTitle("Search - Place Name");
        stage.setMaximized(true);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);

        Label title = new Label();
        title.setMinWidth(500);
        title.setMaxWidth(500);
        title.setAlignment(Pos.CENTER);
        title.setText("Search - Place Name");

        inputPlaceName = new TextField();
        inputPlaceName.setPromptText("Place Name to Search Here");
        inputPlaceName.setFocusTraversable(false);
        inputPlaceName.setMaxWidth(500);

        Button searchBtn = new Button("Search");
        searchBtn.setMinWidth(300);
        searchBtn.setOnAction(e -> {
            search(inputPlaceName.getText());
        });

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setMinWidth(300);
        cancelBtn.setOnAction(e -> {
            stage.close();
        });

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(searchBtn, cancelBtn);
        vbox.setAlignment(Pos.CENTER);

        gridPane.add(title, 0, 0);
        gridPane.add(inputPlaceName, 0, 1);
        gridPane.add(vbox, 0, 2);

        Scene scene = new Scene(gridPane);

        stage.setScene(scene);
        stage.show();

    }

    public static void search(String searchCriteria) {

        if (searchCriteria.matches("")) {
            AlertBox.alertBox("Type a place name to search!");
        } else if (!searchCriteria.matches("^[a-zA-Z ]+$")) {
            AlertBox.alertBox("Place name can contain alphabets only!");
        } else if (checkPlaceName(searchCriteria) == 1) {
            AlertBox.alertBox("Place name not available!");
        } else {
            displayResult(inputPlaceName.getText());
            stage.close();

        }

    }

    public static int checkPlaceName(String searchCriteria) {

        Package[] packages = ReadFile.readPackageFile();

        for (int i = 0; i < packages.length; i++) {
            if (packages[i].getPlaceName().equalsIgnoreCase(searchCriteria)) {
                return 0;
            }
        }

        return 1;
    }

    public static void displayResult(String searchCriteria) {

        int resultIndex = -1;

        Package[] packages = ReadFile.readPackageFile();

        for (int i = 0; i < packages.length; i++) {
            if (packages[i].getPlaceName().equalsIgnoreCase(searchCriteria)) {
                resultIndex = i;
            }
        }

        Stage resultStage = new Stage();
        resultStage.setTitle("Search Result");
        resultStage.setResizable(false);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(20);

        Label title = new Label();
        title.setText("Search Result");
        title.setFont(new Font(32));
        title.setAlignment(Pos.CENTER);

        Button closeBtn = new Button();
        closeBtn.setText("OK");
        closeBtn.setMinWidth(300);
        closeBtn.setOnAction(e -> {
            resultStage.close();
        });

        VBox titleVbox = new VBox(20);
        titleVbox.setAlignment(Pos.CENTER);
        titleVbox.getChildren().addAll(title);

        Text placeNameText = new Text("Place Name: " + packages[resultIndex].getPlaceName());
        Text lineText1 = new Text("------------------------------------");
        Text packageCodeText = new Text("Package Code: " + packages[resultIndex].getPackageCode());
        Text packageNameText = new Text("Package Name: " + packages[resultIndex].getPackageName());
        Text locationText = new Text("Location: " + packages[resultIndex].getLocation());
        Text regionText = new Text("Region: " + packages[resultIndex].getRegion());
        Text lineText2 = new Text("------------------------------------");
        Text adultText = new Text("Adult Price: Rs" + packages[resultIndex].getAdultPrice());
        Text childText = new Text("Child Price: Rs" + packages[resultIndex].getChildPrice());
        Text seniorText = new Text("Senior Price: Rs" + packages[resultIndex].getSeniorPrice());
        Text lineText3 = new Text("------------------------------------");
        Text durationText = new Text("Duration: " + packages[resultIndex].getDuration() + " hours");


        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(placeNameText, lineText1, packageCodeText, packageNameText, locationText, regionText, lineText2, adultText, childText, seniorText, lineText3, durationText);

        pane.add(titleVbox, 0, 0);
        pane.add(vbox, 0, 1);
        pane.add(closeBtn, 0, 3);

        Scene scene = new Scene(pane, 400, 700);

        resultStage.setScene(scene);
        resultStage.setMaximized(true);
        resultStage.show();
    }

}
