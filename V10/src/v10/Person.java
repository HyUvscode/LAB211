package v10;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String id;
    private String name;
    private String birthday;
    private String address;
    private List<HealthRecord> healthRecords;

    public Person(String id, String name, String birthday, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.healthRecords = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void addHealthRecord(HealthRecord healthRecord) {
        healthRecords.add(healthRecord);
    }
}
