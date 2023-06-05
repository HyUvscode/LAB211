package v10;

public class HealthRecord {

    private String date;
    private double weight;
    private double height;

    public HealthRecord(String date, double weight, double height) {
        this.date = date;
        this.weight = weight;
        this.height = height;
    }

    public String getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
