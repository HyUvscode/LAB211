/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s21inputsortanddisplaystudentinformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author khuakhanhhuy
 */
public class S21InputSortAndDisplayStudentInformation {

    /**
     * Main method.
     *
     */
    public static void main(String[] args) {
        // Create an instance of the Program class
        Program program = new Program();
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Display program header
        System.out.println("====== Collection Sort Program ======");

        // Create an empty list to store student objects
        List<Student> students = new ArrayList<>();

        boolean moreStudents = true;
        while (moreStudents) {
            // Prompt user to enter student information
            System.out.println("Please input student information");

            // Get valid student name from user
            String name = Validation.getStringContact("Name: ", "Error: The input name should only contain letters and spaces.");
            // Get valid student class from user
            String classes = Validation.getStringWithNumbers("Classes: ", "Error: The input address should only contain letters and number.");
            // Get valid student mark from user within the range of 0 to 100
            double mark = Validation.getDouble("Mark: ", 0, 100);

            // Create a new student object with the entered information
            Student student = new Student(name, mark, classes);
            // Add the student object to the list
            students.add(student);

            boolean validChoice = false;
            while (!validChoice) {
                // Prompt user to enter choice for more student information
                System.out.print("Do you want to enter more student information? (Y/N): ");
                // Read user choice and convert it to uppercase for case-insensitive comparison
                String choice = scanner.nextLine().toUpperCase();

                if (choice.equals("Y")) {
                    // Continue entering more student information
                    moreStudents = true;
                    validChoice = true;
                } else if (choice.equals("N")) {
                    // Stop entering more student information
                    moreStudents = false;
                    validChoice = true;
                } else {
                    // Display error message for invalid choice
                    System.out.println("Invalid choice! Please enter 'Y' or 'N'.");
                }
            }
        }

        // Set the list of students in the program
        program.setStudents(students);
        // Sort the students by name
        program.sortStudents();
        // Display the sorted student information
        program.displayStudents();
    }
}
