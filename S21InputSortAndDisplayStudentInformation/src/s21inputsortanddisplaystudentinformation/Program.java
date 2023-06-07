/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s21inputsortanddisplaystudentinformation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class representing the program to manage student information.
 *
 * @author khuakhanhhuy
 */
public class Program {

    private List<Student> students; // List to store student information

    /**
     * Set the list of students.
     *
     * @param students The list of students.
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Sort the students based on name using a custom comparator.
     */
    public void sortStudents() {
        Collections.sort(students, new StudentComparator());
    }

    /**
     * Display the student information.
     */
    public void displayStudents() {
//        System.out.println("-------------Student Information-------------");
        int count = 1;
        for (Student student : students) {
            System.out.println("-------------Student " + count + "-------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Class: " + student.getClasses());
            System.out.println("Mark: " + student.getMark());
            count++;
        }
    }

    /**
     * Inner class implementing the custom comparator for Student objects.
     */
    private class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            int nameComparison = s1.getName().compareToIgnoreCase(s2.getName());
            if (nameComparison != 0) {
                return nameComparison;
            } else {
                return Double.compare(s1.getMark(), s2.getMark());
            }
        }
    }
}
