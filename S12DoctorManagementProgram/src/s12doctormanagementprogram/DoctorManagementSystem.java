package s12doctormanagementprogram;

import java.util.HashMap;
import java.util.Scanner;

public class DoctorManagementSystem {

    private Scanner scanner;
    private DoctorHash doctorHash;
    private Validation validation;

    public DoctorManagementSystem() {
        doctorHash = new DoctorHash();
        scanner = new Scanner(System.in);
        validation = new Validation();
    }

    public void addDoctor() {
        System.out.println("ADD DOCTOR");

        String code = validation.getString("Enter Code:", "Invalid input!");

        String name = validation.getString("Enter Name: ", "Invalid input!");

        String specialization = validation.getString("Enter Specialization: ", "Invalid input!");

        int availability = validation.getInt("Enter Availability: ");

        try {
            Doctor doctor = new Doctor(code, name, specialization, availability);
            if (doctorHash.addDoctor(doctor)) {
                System.out.println("Doctor added successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateDoctor() {
        System.out.println("UPDATE DOCTOR");
        String code = validation.getString("Enter Code:", "Invalid input!");
        try {
            if (doctorHash.codeExists(code)) {
                Doctor existingDoctor = doctorHash.getDoctor(code);

                System.out.println("Existing Information:");
                System.out.println("Code: " + existingDoctor.getCode());
                System.out.println("Name: " + existingDoctor.getName());
                System.out.println("Specialization: " + existingDoctor.getSpecialization());
                System.out.println("Availability: " + existingDoctor.getAvailability());

                System.out.println("Enter New Information (Leave blank for no change):");
                String name = validation.getString("Enter Name: ", "Invalid input!");

                String specialization = validation.getString("Enter Specialization: ", "Invalid input!");

                String availabilityInput = validation.getString("Enter Availability: ", "Invalid input!");
                
                int availability = (availabilityInput.isEmpty()) ? existingDoctor.getAvailability() : Integer.parseInt(availabilityInput);

                Doctor updatedDoctor = new Doctor(code, (name.isEmpty()) ? existingDoctor.getName() : name,
                        (specialization.isEmpty()) ? existingDoctor.getSpecialization() : specialization,
                        availability);

                if (doctorHash.updateDoctor(updatedDoctor)) {
                    System.out.println("Doctor updated successfully.");
                }
            } else {
                System.out.println("Doctor with code [" + code + "] does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteDoctor() {
        System.out.println("DELETE DOCTOR");

        String code = validation.getString("Enter Code:", "Invalid input!");

        try {
            if (doctorHash.codeExists(code)) {
                Doctor doctor = doctorHash.getDoctor(code);
                if (doctorHash.deleteDoctor(doctor)) {
                    System.out.println("Doctor deleted successfully.");
                }
            } else {
                System.out.println("Doctor with code [" + code + "] does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchDoctor() {
        System.out.println("SEARCH DOCTOR");

        String searchInput = validation.getString("Enter Search String: ", "Invalid input!");

        try {
            HashMap<String, Doctor> searchResults = doctorHash.searchDoctor(searchInput);
            if (searchResults.isEmpty()) {
                System.out.println("No matching doctors found.");
            } else {
                System.out.println("Search Results:");
                for (Doctor doctor : searchResults.values()) {
                    System.out.println("Code: " + doctor.getCode());
                    System.out.println("Name: " + doctor.getName());
                    System.out.println("Specialization: " + doctor.getSpecialization());
                    System.out.println("Availability: " + doctor.getAvailability());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
