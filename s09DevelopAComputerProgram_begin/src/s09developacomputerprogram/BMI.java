/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09developacomputerprogram;

/**
 * A class for calculating Body Mass Index (BMI) and determining the
 * corresponding status.
 *
 * @author khuakhanhhuy
 */
public class BMI {

    /**
     * An enumeration of possible BMI statuses.
     */
    public enum Status {
        UNDER_STANDARD, // Define the UNDER_STANDARD status
        STANDARD, // Define the STANDARD status
        OVERWEIGHT, // Define the OVERWEIGHT status
        FAT_SHOULD_LOSE_WEIGHT, // Define the FAT_SHOULD_LOSE_WEIGHT status
        VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY  // Define the VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY status
    }

    /**
     * Calculates the BMI given a person's weight (in kilograms) and height (in
     * centimeters).
     *
     * @param weight the weight of the person (in kilograms)
     * @param height the height of the person (in centimeters)
     * @return the calculated BMI value
     * @throws IllegalArgumentException if the input values are not valid (i.e.
     * weight <= 0 or height <= 0)
     */
    public double calculateBMI(double weight, double height) throws IllegalArgumentException {
        if (weight <= 0 || height <= 0) {  // Check if weight or height is invalid
            throw new IllegalArgumentException("Invalid input values");  // Throw an exception with an error message
        }
        double heightInMeters = height / 100.0; // convert cm to m  // Convert height from centimeters to meters
        return weight / (heightInMeters * heightInMeters);  // Calculate and return the BMI value
    }

    /**
     * Determines the BMI status based on the given BMI value.
     *
     * @param bmi the BMI value two check
     * @return the corresponding BMI status
     */
    public Status getStatus(double bmi) {
        if (bmi < 19) {  // Check if bmi is less than 19
            return Status.UNDER_STANDARD;  // Return the UNDER_STANDARD status
        } else if (bmi < 25) {  // Check if bmi is less than 25
            return Status.STANDARD;  // Return the STANDARD status
        } else if (bmi < 30) {  // Check if bmi is less than 30
            return Status.OVERWEIGHT;  // Return the OVERWEIGHT status
        } else if (bmi < 40) {  // Check if bmi is less than 40
            return Status.FAT_SHOULD_LOSE_WEIGHT;  // Return the FAT_SHOULD_LOSE_WEIGHT status
        } else {
            return Status.VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY;  // Return the VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY status
        }
    }
}
