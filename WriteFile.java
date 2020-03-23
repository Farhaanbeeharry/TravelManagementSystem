package sample;

import java.io.*;

public class WriteFile {

    public static void writePackageFile(String packageName, String packageCode, String placeName, String location, String region, Double adultPrice, Double childPrice, Double seniorPrice, int duration) {

        try {
            File outputFile = new File("src/sample/data/Package.txt");

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
                writer.newLine();
                writer.write(packageName + "--" + packageCode + "--" + placeName + "--" + location + "--" + region + "--" + adultPrice + "--" + childPrice + "--" + seniorPrice + "--" + duration);
            }
        } catch (IOException e) {
            AlertBox.alertBox("File not found!");
        }

    }

    public static void writeBookingFile(String firstName, String lastName, String packageCode, int numberOfAdults, int numberOfChildren, int numberOfSeniors, double totalPrice) {

        try {
            File outputFile = new File("src/sample/data/Booking.txt");

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
                writer.newLine();
                writer.write(firstName + "--" + lastName + "--" + packageCode + "--" + numberOfAdults + "--" + numberOfChildren + "--" + numberOfSeniors + "--" + totalPrice);
            }
        } catch (IOException e) {
            AlertBox.alertBox("File not found!");
        }

    }

    public static void updateBookingFile(Booking[] bookings) {

        try {
            File outputFile = new File("src/sample/data/Booking.txt");

            try(PrintStream writer = new PrintStream(outputFile)) {
                for (int i = 0; i < bookings.length; i++) {
                    if(bookings[i].getFirstName() != null) {
                        writer.print(bookings[i].getFirstName());
                        writer.print("--");
                        writer.print(bookings[i].getLastName());
                        writer.print("--");
                        writer.print(bookings[i].getPackageCode());
                        writer.print("--");
                        writer.print(bookings[i].getNumberOfAdults());
                        writer.print("--");
                        writer.print(bookings[i].getNumberOfChildren());
                        writer.print("--");
                        writer.print(bookings[i].getNumberOfSeniors());
                        writer.print("--");
                        if (i == bookings.length - 1) {
                            writer.print(bookings[i].getTotalPrice());
                        } else {
                            writer.println(bookings[i].getTotalPrice());
                        }

                    }
                }
            }
        } catch (IOException e) {
            AlertBox.alertBox("File not found!");
        }


    }

}
