package sample;

public class Package {

    private String packageName;
    private String packageCode;
    private String placeName;
    private String location;
    private String region;
    private double adultPrice;
    private double childPrice;
    private double seniorPrice;
    private int duration;

    public Package() {
        this.packageName = "";
        this.packageCode = "";
        this.placeName = "";
        this.location = "";
        this.region = "";
        this.adultPrice = 0.0;
        this.childPrice = 0.0;
        this.seniorPrice = 0.0;
        this.duration = 0;
    }

    public Package(String packageName, String packageCode, String placeName, String location, String region, double adultPrice, double childPrice, double seniorPrice, int duration) {
        this.packageName = packageName;
        this.packageCode = packageCode;
        this.placeName = placeName;
        this.location = location;
        this.region = region;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.seniorPrice = seniorPrice;
        this.duration = duration;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public double getSeniorPrice() {
        return seniorPrice;
    }

    public void setSeniorPrice(double seniorPrice) {
        this.seniorPrice = seniorPrice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
