package sample;

import com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.NamespaceVersion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Add {

    static Stage addPackageStage, addBookingStage;
    static TextField inputPackageName, inputPackageCode, inputPlaceName, inputLocation, inputAdultPrice, inputChildPrice, inputSeniorPrice, inputDuration, inputAdult, inputChild, inputSenior, inputFirstName, inputLastName;
    static ToggleGroup regionGroup;
    static RadioButton europeBtn, africaBtn, nAmericaBtn, sAmericaBtn, eastIndiesBtn, iOIslandsBtn;
    static ComboBox comboBox;
    static Label totalPriceLabel;

    public static void addPackage() {

        addPackageStage = new Stage();
        addPackageStage.setTitle("Add new package");
        addPackageStage.setMaximized(true);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);

        Label title = new Label();
        title.setMinWidth(430);
        title.setMaxWidth(430);
        title.setAlignment(Pos.CENTER);
        title.setText("Add new package");

        inputPackageName = new TextField();
        inputPackageName.setPromptText("Input package name here");
        inputPackageName.setFocusTraversable(false);
        inputPackageName.setMaxWidth(430);

        inputPackageCode = new TextField();
        inputPackageCode.setPromptText("Input package code here");
        inputPackageCode.setFocusTraversable(false);
        inputPackageCode.setMaxWidth(430);

        inputPlaceName = new TextField();
        inputPlaceName.setPromptText("Input place name here");
        inputPlaceName.setFocusTraversable(false);
        inputPlaceName.setMaxWidth(430);

        inputLocation = new TextField();
        inputLocation.setPromptText("Input location here");
        inputLocation.setFocusTraversable(false);
        inputLocation.setMaxWidth(430);

        Text radioChoice = new Text("Region:");
        regionGroup = new ToggleGroup();
        africaBtn = new RadioButton("Africa");
        africaBtn.setToggleGroup(regionGroup);
        eastIndiesBtn = new RadioButton("East Indies");
        eastIndiesBtn.setToggleGroup(regionGroup);
        europeBtn = new RadioButton("Europe");
        europeBtn.setToggleGroup(regionGroup);
        iOIslandsBtn = new RadioButton("Indian Ocean Island");
        iOIslandsBtn.setToggleGroup(regionGroup);
        nAmericaBtn = new RadioButton("North America");
        nAmericaBtn.setToggleGroup(regionGroup);
        sAmericaBtn = new RadioButton("South America");
        sAmericaBtn.setToggleGroup(regionGroup);

        HBox radioBtns1 = new HBox(20);
        radioBtns1.getChildren().addAll(radioChoice, africaBtn, eastIndiesBtn, iOIslandsBtn);

        HBox radioBtns2 = new HBox(20);
        radioBtns2.setPadding(new Insets(0, 0, 0, 70));
        radioBtns2.getChildren().addAll(europeBtn, nAmericaBtn, sAmericaBtn);

        inputAdultPrice = new TextField();
        inputAdultPrice.setPromptText("Input adult price here");
        inputAdultPrice.setFocusTraversable(false);
        inputAdultPrice.setMaxWidth(430);

        inputChildPrice = new TextField();
        inputChildPrice.setPromptText("Input child price here");
        inputChildPrice.setFocusTraversable(false);
        inputChildPrice.setMaxWidth(430);

        inputSeniorPrice = new TextField();
        inputSeniorPrice.setPromptText("Input Senior price here");
        inputSeniorPrice.setFocusTraversable(false);
        inputSeniorPrice.setMaxWidth(430);

        inputDuration = new TextField();
        inputDuration.setPromptText("Input duration here (in hours)");
        inputDuration.setFocusTraversable(false);
        inputDuration.setMaxWidth(430);

        Button addBtn = new Button("Add");
        addBtn.setMaxWidth(300);
        addBtn.setOnAction(e -> {
            checkPackageData();
        });

        Button backBtn = new Button("Back");
        backBtn.setMinWidth(300);
        backBtn.setOnAction(e -> {
            addPackageStage.close();
        });

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(addBtn, backBtn);
        vbox.setAlignment(Pos.CENTER);

        gridPane.add(title, 0, 0);
        gridPane.add(inputPackageName, 0, 1);
        gridPane.add(inputPackageCode, 0, 2);
        gridPane.add(inputPlaceName, 0, 3);
        gridPane.add(inputLocation, 0, 4);
        gridPane.add(radioBtns1, 0, 5);
        gridPane.add(radioBtns2, 0, 6);
        gridPane.add(inputAdultPrice, 0, 7);
        gridPane.add(inputChildPrice, 0, 8);
        gridPane.add(inputSeniorPrice, 0, 9);
        gridPane.add(inputDuration, 0, 10);
        gridPane.add(vbox, 0, 11);

        Scene scene = new Scene(gridPane);

        addPackageStage.setScene(scene);
        addPackageStage.show();

    }

    public static void checkPackageData() {

        if (inputPackageName.getText().matches("")) {
            AlertBox.alertBox("Package name cannot be empty!");
        } else if (!inputPackageName.getText().matches("^[a-zA-Z0-9 ]+$")) {
            AlertBox.alertBox("Package name can only contain alphabets!");
        } else if (inputPackageCode.getText().length() != 4) {
            AlertBox.alertBox("Package Code should contain 4 characters!");
        } else if (inputPackageCode.getText().matches("")) {
            AlertBox.alertBox("Package code cannot be empty!");
        } else if (!inputPackageCode.getText().matches("^[a-zA-Z0-9]+$")) {
            AlertBox.alertBox("Package code should be alphanumeric!");
        } else if (checkDuplicateCode(inputPackageCode.getText()) == 1) {
            AlertBox.alertBox("Package Code already exists!");
        } else if (inputPlaceName.getText().matches("")) {
            AlertBox.alertBox("Place name cannot be empty!");
        } else if (!inputPlaceName.getText().matches("^[a-zA-Z ]+$")) {
            AlertBox.alertBox("Place name can only contain alphabets!");
        } else if (inputLocation.getText().matches("")) {
            AlertBox.alertBox("Location cannot be empty!");
        } else if (!inputLocation.getText().matches("^[a-zA-Z ]+$")) {
            AlertBox.alertBox("Location can only contain alphabets!");
        } else if (!africaBtn.isSelected() && !eastIndiesBtn.isSelected() && !europeBtn.isSelected() && !iOIslandsBtn.isSelected() && !nAmericaBtn.isSelected() && !sAmericaBtn.isSelected()) {
            AlertBox.alertBox("Please select a region!");
        } else if (inputAdultPrice.getText().matches("")) {
            AlertBox.alertBox("Adult price cannot be empty!");
        } else if (!inputAdultPrice.getText().matches("^[0-9.]+$")) {
            AlertBox.alertBox("Adult price should be numbers only!");
        } else if (Double.parseDouble(inputAdultPrice.getText()) < 0) {
            AlertBox.alertBox("Adult price cannot be negative!");
        } else if (inputChildPrice.getText().matches("")) {
            AlertBox.alertBox("Child price cannot be empty!");
        } else if (!inputChildPrice.getText().matches("^[0-9.]+$")) {
            AlertBox.alertBox("Child price should be numbers only!");
        } else if (Double.parseDouble(inputChildPrice.getText()) < 0) {
            AlertBox.alertBox("Child price cannot be negative!");
        } else if (inputSeniorPrice.getText().matches("")) {
            AlertBox.alertBox("Senior price cannot be empty!");
        } else if (!inputSeniorPrice.getText().matches("^[0-9.]+$")) {
            AlertBox.alertBox("Senior price should be numbers only!");
        } else if (Double.parseDouble(inputSeniorPrice.getText()) < 0) {
            AlertBox.alertBox("Senior cannot be negative!");
        } else if (inputDuration.getText().matches("")) {
            AlertBox.alertBox("Duration cannot be empty!");
        } else if (!inputDuration.getText().matches("^[0-9]+$")) {
            AlertBox.alertBox("Duration can be whole numbers only!");
        } else if (Integer.parseInt(inputDuration.getText()) < 1) {
            AlertBox.alertBox("Duration can be minimum 1 hour!");
        } else {
            String region = "";

            if (africaBtn.isSelected()) {
                region = "Africa";
            } else if (eastIndiesBtn.isSelected()) {
                region = "East Indies";
            } else if (europeBtn.isSelected()) {
                region = "Europe";
            } else if (iOIslandsBtn.isSelected()) {
                region = "Indian Ocean Islands";
            } else if (nAmericaBtn.isSelected()) {
                region = "North America";
            } else if (sAmericaBtn.isSelected()) {
                region = "South America";
            }

            WriteFile.writePackageFile(inputPackageName.getText(), inputPackageCode.getText(), inputPlaceName.getText(), inputLocation.getText(), region, Double.parseDouble(inputAdultPrice.getText()), Double.parseDouble(inputChildPrice.getText()), Double.parseDouble(inputSeniorPrice.getText()), Integer.parseInt(inputDuration.getText()));
            addPackageStage.close();
            AlertBox.alertBox("Add Successful!");
        }

    }

    public static int checkDuplicateCode(String packageCode) {

        Package[] packages = ReadFile.readPackageFile();

        for (int i = 0; i < packages.length; i++) {
            if (packages[i].getPackageCode().equalsIgnoreCase(packageCode)) {
                return 1;
            }
        }

        return 0;
    }

    public static void addBooking() {

        Package[] packages = ReadFile.readPackageFile();

        addBookingStage = new Stage();
        addBookingStage.setTitle("Add new booking");
        addBookingStage.setMaximized(true);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);

        Label title = new Label();
        title.setMinWidth(500);
        title.setMaxWidth(500);
        title.setAlignment(Pos.CENTER);
        title.setText("Add new booking");

        comboBox = new ComboBox();
        comboBox.setMinWidth(500);
        comboBox.setValue("Choose Package");

        for (int i = 0; i < packages.length; i++) {
            comboBox.getItems().add(packages[i].getPackageCode() + " - " + packages[i].getPackageName() + " - " + packages[i].getPlaceName() + " - " + packages[i].getLocation() + " - " + packages[i].getDuration() + "hours");
        }

        inputAdult = new TextField();
        inputAdult.setPromptText("Number of adult(s)");
        inputAdult.setFocusTraversable(false);
        inputAdult.setMaxWidth(500);

        inputChild = new TextField();
        inputChild.setPromptText("Number of Child(ren)");
        inputChild.setFocusTraversable(false);
        inputChild.setMaxWidth(500);

        inputSenior = new TextField();
        inputSenior.setPromptText("Number of senior(s)");
        inputSenior.setFocusTraversable(false);
        inputSenior.setMaxWidth(500);

        inputFirstName = new TextField();
        inputFirstName.setPromptText("Input First Name");
        inputFirstName.setFocusTraversable(false);
        inputFirstName.setMaxWidth(500);

        inputLastName = new TextField();
        inputLastName.setPromptText("Input Last Name");
        inputLastName.setFocusTraversable(false);
        inputLastName.setMaxWidth(500);

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setMinWidth(300);
        calculateBtn.setOnAction(e -> {

                    if (comboBox.getValue().toString().equalsIgnoreCase("Choose Package")) {
                        AlertBox.alertBox("Choose a package!");
                    } else if (inputAdult.getText().matches("")) {
                        AlertBox.alertBox("Number of adults cannot be empty!");
                    } else if (!inputAdult.getText().matches("^[0-9]+$")) {
                        AlertBox.alertBox("Number of adults should be integer only!");
                    } else if (inputChild.getText().matches("")) {
                        AlertBox.alertBox("Number of children cannot be empty!");
                    } else if (!inputChild.getText().matches("^[0-9]+$")) {
                        AlertBox.alertBox("Number of children should be integer only!");
                    } else if (inputSenior.getText().matches("")) {
                        AlertBox.alertBox("Number of seniors cannot be empty!");
                    } else if (!inputSenior.getText().matches("^[0-9]+$")) {
                        AlertBox.alertBox("Number of seniors should be integer only!");
                    } else {
                        totalPriceLabel.setText("Total Price = Rs" + getTotal());
                    }
                }
        );

        Button bookBtn = new Button("Book Without Receipt");
        bookBtn.setMinWidth(300);
        bookBtn.setOnAction(e -> {
            checkBookingData(0);
        });

        Button bookReceiptBtn = new Button("Book With Receipt");
        bookReceiptBtn.setMinWidth(300);
        bookReceiptBtn.setOnAction(e -> {
            checkBookingData(1);
        });

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setMinWidth(300);
        cancelBtn.setOnAction(e -> {
            addBookingStage.close();
        });

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(calculateBtn, bookBtn, bookReceiptBtn, cancelBtn);
        vbox.setAlignment(Pos.CENTER);

        totalPriceLabel = new Label();
        totalPriceLabel.setAlignment(Pos.CENTER);
        totalPriceLabel.setMinWidth(500);
        totalPriceLabel.setMaxWidth(500);
        totalPriceLabel.setText("Click on \"Calculate\" to get Total Price");

        gridPane.add(title, 0, 0);
        gridPane.add(comboBox, 0, 2);
        gridPane.add(inputAdult, 0, 3);
        gridPane.add(inputChild, 0, 4);
        gridPane.add(inputSenior, 0, 5);
        gridPane.add(inputFirstName, 0, 6);
        gridPane.add(inputLastName, 0, 7);
        gridPane.add(totalPriceLabel, 0, 8);
        gridPane.add(vbox, 0, 9);

        Scene scene = new Scene(gridPane);

        addBookingStage.setScene(scene);
        addBookingStage.show();

    }

    public static double getTotal() {

        double totalPrice = 0.0;
        String choice = (String) comboBox.getValue();
        choice = choice.substring(0, 4);
        int choiceIndex = -1;

        Package[] packages = ReadFile.readPackageFile();

        for (int i = 0; i < packages.length; i++) {
            if (packages[i].getPackageCode().equalsIgnoreCase(choice)) {
                choiceIndex = i;
            }
        }

        totalPrice = (Double.parseDouble(inputAdult.getText())*packages[choiceIndex].getAdultPrice())
                + (Double.parseDouble(inputChild.getText())*packages[choiceIndex].getChildPrice())
                + (Double.parseDouble(inputSenior.getText())*packages[choiceIndex].getSeniorPrice());


        return totalPrice;
    }

    public static void checkBookingData(int receiptStatus) {

        String packageCode = (String) comboBox.getValue();
        packageCode = packageCode.substring(0, 4);

        if (comboBox.getValue().toString().equalsIgnoreCase("Choose Package")) {
            AlertBox.alertBox("Choose a package!");
        } else if (inputAdult.getText().matches("")) {
            AlertBox.alertBox("Number of adults cannot be empty!");
        } else if (!inputAdult.getText().matches("^[0-9]+$")) {
            AlertBox.alertBox("Number of adults should be integer only!");
        } else if (inputChild.getText().matches("")) {
            AlertBox.alertBox("Number of children cannot be empty!");
        } else if (!inputChild.getText().matches("^[0-9]+$")) {
            AlertBox.alertBox("Number of children should be integer only!");
        } else if (inputSenior.getText().matches("")) {
            AlertBox.alertBox("Number of seniors cannot be empty!");
        } else if (!inputSenior.getText().matches("^[0-9]+$")) {
            AlertBox.alertBox("Number of seniors should be integer only!");
        } else if (inputFirstName.getText().matches("")) {
            AlertBox.alertBox("First name cannot be empty!");
        } else if (!inputFirstName.getText().matches("^[a-zA-Z]+$")) {
            AlertBox.alertBox("First name can contain alphabets only!");
        } else if (inputLastName.getText().matches("")) {
            AlertBox.alertBox("Last name cannot be empty!");
        } else if (!inputLastName.getText().matches("^[a-zA-Z]+$")) {
            AlertBox.alertBox("Last name can contain alphabets only!");
        } else {
            WriteFile.writeBookingFile(inputFirstName.getText(), inputLastName.getText(), packageCode, Integer.parseInt(inputAdult.getText()), Integer.parseInt(inputChild.getText()), Integer.parseInt(inputSenior.getText()), getTotal());
            addBookingStage.close();
            if (receiptStatus == 0) {
                AlertBox.alertBox("Booking Successful!");
            } else if (receiptStatus == 1) {
                Receipt.receipt(inputFirstName.getText(), inputLastName.getText(), packageCode, Integer.parseInt(inputAdult.getText()), Integer.parseInt(inputChild.getText()), Integer.parseInt(inputSenior.getText()), getTotal());
            }
        }

    }
}
