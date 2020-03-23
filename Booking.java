package sample;

public class Booking {

    private String firstName;
    private String lastName;
    private String packageCode;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfSeniors;
    private double totalPrice;

    public Booking() {
        this.firstName = "";
        this.lastName = "";
        this.packageCode = "";
        this.numberOfAdults = 0;
        this.numberOfChildren = 0;
        this.numberOfSeniors = 0;
        this.totalPrice = 0.0;
    }

    public Booking(String firstName, String lastName, String packageCode, int numberOfAdults, int numberOfChildren, int numberOfSeniors, double totalPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.packageCode = packageCode;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.numberOfSeniors = numberOfSeniors;
        this.totalPrice = totalPrice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfSeniors() {
        return numberOfSeniors;
    }

    public void setNumberOfSeniors(int numberOfSeniors) {
        this.numberOfSeniors = numberOfSeniors;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
