/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s21inputsortanddisplaystudentinformation;

/**
 * Class representing a student.
 *
 * @author khuakhanhhuy
 */
public class Student {

    private String name; // Name of the student
    private double mark; // Mark of the student
    private String classes; // Classes of the student

    /**
     * Constructor to initialize a Student object.
     *
     * @param name The name of the student.
     * @param mark The mark of the student.
     * @param classes The classes of the student.
     */
    public Student(String name, double mark, String classes) {
        this.name = name;
        this.mark = mark;
        this.classes = classes;
    }

    /**
     * Get the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the mark of the student.
     *
     * @return The mark of the student.
     */
    public double getMark() {
        return mark;
    }

    /**
     * Get the classes of the student.
     *
     * @return The classes of the student.
     */
    public String getClasses() {
        return classes;
    }

    /**
     * Set the name of the student.
     *
     * @param name The name to set for the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the mark of the student.
     *
     * @param mark The mark to set for the student.
     */
    public void setMark(double mark) {
        this.mark = mark;
    }

    /**
     * Set the classes of the student.
     *
     * @param classes The classes to set for the student.
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }
}
