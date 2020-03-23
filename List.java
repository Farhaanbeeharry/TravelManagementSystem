package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.*;

public class List {

        static Stage packageStage, bookingStage;
        static TableView packageTable, bookingTable;

        public static void listPackages(int sortingStatus) {

            packageStage = new Stage();
            packageStage.setTitle("Package List");
            packageStage.setMaximized(true);

            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setVgap(20);

            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);

            Label title = new Label();
            title.setText("Package List");
            vbox.getChildren().add(title);

            double screenWidth = Screen.getPrimary().getBounds().getWidth();
            double columnWidth = (screenWidth - 4) / 9;

            try {
                TableColumn<Package, String> nameColumns = new TableColumn<>("Package Name");
                nameColumns.setCellValueFactory(new PropertyValueFactory<>("packageName"));
                nameColumns.setMinWidth(columnWidth);
                nameColumns.setResizable(false);
                nameColumns.setSortable(false);

                TableColumn<Package, String> codeColumns = new TableColumn<>("Package Code");
                codeColumns.setCellValueFactory(new PropertyValueFactory<>("packageCode"));
                codeColumns.setMinWidth(columnWidth);
                codeColumns.setResizable(false);
                codeColumns.setSortable(false);

                TableColumn<Package, String> placeColumns = new TableColumn<>("Place Name");
                placeColumns.setCellValueFactory(new PropertyValueFactory<>("placeName"));
                placeColumns.setMinWidth(columnWidth);
                placeColumns.setResizable(false);
                placeColumns.setSortable(false);

                TableColumn<Package, String> locationColumns = new TableColumn<>("Location");
                locationColumns.setCellValueFactory(new PropertyValueFactory<>("location"));
                locationColumns.setMinWidth(columnWidth);
                locationColumns.setResizable(false);
                locationColumns.setSortable(false);

                TableColumn<Package, String> regionColumns = new TableColumn<>("Region");
                regionColumns.setCellValueFactory(new PropertyValueFactory<>("region"));
                regionColumns.setMinWidth(columnWidth);
                regionColumns.setResizable(false);
                regionColumns.setSortable(false);

                TableColumn<Package, Double> adultPriceColumns = new TableColumn<>("Adult Price (Rs)");
                adultPriceColumns.setCellValueFactory(new PropertyValueFactory<>("adultPrice"));
                adultPriceColumns.setMinWidth(columnWidth);
                adultPriceColumns.setResizable(false);
                adultPriceColumns.setSortable(false);

                TableColumn<Package, Double> childPriceColumns = new TableColumn<>("Child Price (Rs)");
                childPriceColumns.setCellValueFactory(new PropertyValueFactory<>("childPrice"));
                childPriceColumns.setMinWidth(columnWidth);
                childPriceColumns.setResizable(false);
                childPriceColumns.setSortable(false);

                TableColumn<Package, Double> seniorPriceColumns = new TableColumn<>("Senior Price (Rs)");
                seniorPriceColumns.setCellValueFactory(new PropertyValueFactory<>("seniorPrice"));
                seniorPriceColumns.setMinWidth(columnWidth);
                seniorPriceColumns.setResizable(false);
                seniorPriceColumns.setSortable(false);

                TableColumn<Package, Integer> durationColumns = new TableColumn<>("Duration (hours)");
                durationColumns.setCellValueFactory(new PropertyValueFactory<>("duration"));
                durationColumns.setMinWidth(columnWidth);
                durationColumns.setResizable(false);
                durationColumns.setSortable(false);

                packageTable = new TableView<>();
                packageTable.setFocusTraversable(false);
                packageTable.setEditable(false);
                packageTable.prefHeightProperty().bind(packageStage.heightProperty());
                packageTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

                Package[] packages = ReadFile.readPackageFile();

                if (sortingStatus == 1) {
                    packages = sort(packages);
                }

                for (int i = 0; i < packages.length; i++) {
                    packageTable.getItems().add(new Package(packages[i].getPackageName(),
                            packages[i].getPackageCode(),
                            packages[i].getPlaceName(),
                            packages[i].getLocation(),
                            packages[i].getRegion(),
                            packages[i].getAdultPrice(),
                            packages[i].getChildPrice(),
                            packages[i].getSeniorPrice(),
                            packages[i].getDuration()));
                }

                packageTable.getColumns().addAll(nameColumns, codeColumns, placeColumns, locationColumns, regionColumns, adultPriceColumns, childPriceColumns, seniorPriceColumns, durationColumns);
            } catch (Exception e) {
            }

            Button backBtn = new Button("Back");
            backBtn.setMinWidth(200);
            backBtn.setOnAction(e -> {
                packageStage.close();
            });

            VBox stageVBox = new VBox();
            stageVBox.getChildren().addAll(title, packageTable, backBtn);
            stageVBox.setAlignment(Pos.BOTTOM_CENTER);

            BorderPane bp = new BorderPane();
            bp.setCenter(stageVBox);

            Scene scene = new Scene(bp);

            packageStage.setScene(scene);
            packageStage.show();

        }

        public static Package[] sort(Package[] packages) {

            String tempPackageName, tempPackageCode, tempPlaceName, tempLocation, tempRegion;
            Double tempAdultPrice, tempChildPrice, tempSeniorPrice;
            int tempDuration;

            for (int i = 1; i < packages.length; i++) {
                for (int j = i; j > 0; j--) {

                    if (packages[j].getPlaceName().compareToIgnoreCase(packages[j - 1].getPlaceName()) < 0) {

                        tempPackageName = packages[j].getPackageName();
                        tempPackageCode = packages[j].getPackageCode();
                        tempPlaceName = packages[j].getPlaceName();
                        tempLocation = packages[j].getLocation();
                        tempRegion = packages[j].getRegion();
                        tempAdultPrice = packages[j].getAdultPrice();
                        tempChildPrice = packages[j].getChildPrice();
                        tempSeniorPrice = packages[j].getSeniorPrice();
                        tempDuration = packages[j].getDuration();

                        packages[j].setPackageName(packages[j - 1].getPackageName());
                        packages[j].setPackageCode(packages[j - 1].getPackageCode());
                        packages[j].setPlaceName(packages[j - 1].getPlaceName());
                        packages[j].setLocation(packages[j - 1].getLocation());
                        packages[j].setRegion(packages[j - 1].getRegion());
                        packages[j].setAdultPrice(packages[j - 1].getAdultPrice());
                        packages[j].setChildPrice(packages[j - 1].getChildPrice());
                        packages[j].setSeniorPrice(packages[j - 1].getSeniorPrice());
                        packages[j].setDuration(packages[j - 1].getDuration());

                        packages[j - 1].setPackageName(tempPackageName);
                        packages[j - 1].setPackageCode(tempPackageCode);
                        packages[j - 1].setPlaceName(tempPlaceName);
                        packages[j - 1].setLocation(tempLocation);
                        packages[j - 1].setRegion(tempRegion);
                        packages[j - 1].setAdultPrice(tempAdultPrice);
                        packages[j - 1].setChildPrice(tempChildPrice);
                        packages[j - 1].setSeniorPrice(tempSeniorPrice);
                        packages[j - 1].setDuration(tempDuration);

                    }

                }
            }

            return packages;
        }

        public static void listBookings() {
            bookingStage = new Stage();
            bookingStage.setTitle("Booking List");
            bookingStage.setMaximized(true);

            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setVgap(20);

            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);

            Label title = new Label();
            title.setText("Booking List");
            vbox.getChildren().add(title);

            double screenWidth = Screen.getPrimary().getBounds().getWidth();
            double columnWidth = (screenWidth - 4) / 8;

            try {
                TableColumn<Package, String> firstNameColumns = new TableColumn<>("First Name");
                firstNameColumns.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                firstNameColumns.setMinWidth(columnWidth);
                firstNameColumns.setResizable(false);
                firstNameColumns.setSortable(false);

                TableColumn<Package, String> lastNameColumns = new TableColumn<>("Last Name");
                lastNameColumns.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                lastNameColumns.setMinWidth(columnWidth);
                lastNameColumns.setResizable(false);
                lastNameColumns.setSortable(false);

                TableColumn<Package, String> packageCodeColumns = new TableColumn<>("Package Code");
                packageCodeColumns.setCellValueFactory(new PropertyValueFactory<>("packageCode"));
                packageCodeColumns.setMinWidth(columnWidth);
                packageCodeColumns.setResizable(false);
                packageCodeColumns.setSortable(false);

                TableColumn<Package, Integer> adultsColumns = new TableColumn<>("No. of Adults");
                adultsColumns.setCellValueFactory(new PropertyValueFactory<>("numberOfAdults"));
                adultsColumns.setMinWidth(columnWidth);
                adultsColumns.setResizable(false);
                adultsColumns.setSortable(false);

                TableColumn<Package, Integer> childrenColumns = new TableColumn<>("No. of Children");
                childrenColumns.setCellValueFactory(new PropertyValueFactory<>("numberOfChildren"));
                childrenColumns.setMinWidth(columnWidth);
                childrenColumns.setResizable(false);
                childrenColumns.setSortable(false);

                TableColumn<Package, Integer> seniorsColumns = new TableColumn<>("No. of Seniors");
                seniorsColumns.setCellValueFactory(new PropertyValueFactory<>("numberOfSeniors"));
                seniorsColumns.setMinWidth(columnWidth);
                seniorsColumns.setResizable(false);
                seniorsColumns.setSortable(false);

                TableColumn<Package, Double> priceColumns = new TableColumn<>("Total Price (Rs)");
                priceColumns.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
                priceColumns.setMinWidth(columnWidth);
                priceColumns.setResizable(false);
                priceColumns.setSortable(false);

                bookingTable = new TableView<>();
                bookingTable.setFocusTraversable(false);
                bookingTable.setEditable(false);
                bookingTable.prefHeightProperty().bind(bookingStage.heightProperty());
                bookingTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                bookingTable.getColumns().addAll(firstNameColumns, lastNameColumns, packageCodeColumns, adultsColumns, childrenColumns, seniorsColumns, priceColumns);

                Booking[] bookings = ReadFile.readBookingFile();

                for (int i = 0; i < bookings.length; i++) {
                    bookingTable.getItems().add(new Booking(bookings[i].getFirstName(),
                            bookings[i].getLastName(),
                            bookings[i].getPackageCode(),
                            bookings[i].getNumberOfAdults(),
                            bookings[i].getNumberOfChildren(),
                            bookings[i].getNumberOfSeniors(),
                            bookings[i].getTotalPrice()));
                }

            } catch (Exception e) {
            }

            Button backBtn = new Button("Back");
            backBtn.setMinWidth(400);
            backBtn.setOnAction(e -> {
                bookingStage.close();
            });

            Button deleteBtn = new Button("Delete");
            deleteBtn.setMinWidth(400);
            deleteBtn.setOnAction(e -> {
                deleteBooking();
            });

            HBox hbox = new HBox(25);
            hbox.getChildren().addAll(deleteBtn, backBtn);
            hbox.setAlignment(Pos.CENTER);

            VBox stageVBox = new VBox(20);
            stageVBox.setPadding(new Insets(0, 0, 20, 0));
            stageVBox.getChildren().addAll(title, bookingTable, hbox);
            stageVBox.setAlignment(Pos.BOTTOM_CENTER);

            BorderPane bp = new BorderPane();
            bp.setCenter(stageVBox);

            Scene scene = new Scene(bp);

            bookingStage.setScene(scene);
            bookingStage.show();

        }

        public static void deleteBooking() {

            int arrayToDelete = bookingTable.getSelectionModel().getSelectedIndex();

            if (arrayToDelete == -1) {
                AlertBox.alertBox("Please select a line to delete!");
            } else {
                Booking[] bookings = ReadFile.readBookingFile();
                Booking[] updatedBookings = new Booking[bookings.length - 1];

                for (int x = 0, k = 0; x < bookings.length; x++) {

                    if (x == arrayToDelete) {
                        continue;
                    }

                    updatedBookings[k++] = bookings[x];
                }

                WriteFile.updateBookingFile(updatedBookings);
                bookingTable.getItems().clear();
                addToBookingTable();
                AlertBox.alertBox("Delete successful!");
            }

        }

        public static void addToBookingTable() {
            Booking[] bookings = ReadFile.readBookingFile();

            for (int i = 0; i < bookings.length; i++) {
                bookingTable.getItems().add(new Booking(bookings[i].getFirstName(),
                        bookings[i].getLastName(),
                        bookings[i].getPackageCode(),
                        bookings[i].getNumberOfAdults(),
                        bookings[i].getNumberOfChildren(),
                        bookings[i].getNumberOfSeniors(),
                        bookings[i].getTotalPrice()));
            }
        }

    }


