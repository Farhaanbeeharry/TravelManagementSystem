package sample;

import java.io.*;

public class ReadFile {

    public static int count(String fileChoice) {

        int count = 0;
        String fileName = "";

        if (fileChoice.equalsIgnoreCase("Package")) {
            fileName = "src/sample/data/Package.txt";
        } else if (fileChoice.equalsIgnoreCase("Booking")) {
            fileName = "src/sample/data/Booking.txt";
        }

        try {
            FileReader inputFile = new FileReader(fileName);

            try(BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String packageData = inputBuffer.readLine();

                while (packageData != null) {
                    count++;
                    packageData = inputBuffer.readLine();
                }
            }
        } catch (IOException e) {
            AlertBox.alertBox("File not found!");
        }

        return count;
    }

    public static Package[] readPackageFile() {

        Package[] packages = new Package[count("Package")];

        try {
            FileReader inputFile = new FileReader("src/sample/data/Package.txt");

            try(BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String packageData;
                packageData = inputBuffer.readLine();

                while (packageData != null) {
                    for (int i = 0; i < count("Package"); i++) {
                        String[] data = packageData.split("--");
                        packages[i] = new Package();
                        packages[i].setPackageName(data[0]);
                        packages[i].setPackageCode(data[1]);
                        packages[i].setPlaceName(data[2]);
                        packages[i].setLocation(data[3]);
                        packages[i].setRegion(data[4]);
                        packages[i].setAdultPrice(Double.parseDouble(data[5]));
                        packages[i].setChildPrice(Double.parseDouble(data[6]));
                        packages[i].setSeniorPrice(Double.parseDouble(data[7]));
                        packages[i].setDuration(Integer.parseInt(data[8]));
                        packageData = inputBuffer.readLine();
                    }
                }
            }


        } catch (IOException e) {
            AlertBox.alertBox("File not found!");
        }

        return packages;
    }

    public static Booking[] readBookingFile() {

        Booking[] bookings = new Booking[count("Booking")];

        try {
            FileReader inputFile = new FileReader("src/sample/data/Booking.txt");

            try(BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String bookingData;
                bookingData = inputBuffer.readLine();

                while (bookingData != null) {
                    for (int i = 0; i < count("Booking"); i++) {
                        String[] data = bookingData.split("--");
                        bookings[i] = new Booking();
                        bookings[i].setFirstName(data[0]);
                        bookings[i].setLastName(data[1]);
                        bookings[i].setPackageCode(data[2]);
                        bookings[i].setNumberOfAdults(Integer.parseInt(data[3]));
                        bookings[i].setNumberOfChildren(Integer.parseInt(data[4]));
                        bookings[i].setNumberOfSeniors(Integer.parseInt(data[5]));
                        bookings[i].setTotalPrice(Double.parseDouble(data[6]));
                        bookingData = inputBuffer.readLine();
                    }
                }
            }


        } catch (IOException e) {
            AlertBox.alertBox("File not found!");
        }

        return bookings;
    }

}
