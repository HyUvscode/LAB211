/**
 * A class for calculating Body Mass Index (BMI) and determining the corresponding status.
 */
public class BMI {
     /**
     * An enumeration of possible BMI statuses.
     */
    public enum Status {
        UNDER_STANDARD,
        STANDARD,
        OVERWEIGHT,
        FAT_SHOULD_LOSE_WEIGHT,
        VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY
    }
    
    /**
     * Calculates the BMI given a person's weight (in kilograms) and height (in centimeters).
     *
     * @param weight the weight of the person (in kilograms)
     * @param height the height of the person (in centimeters)
     * @return the calculated BMI value
     * @throws IllegalArgumentException if the input values are not valid (i.e. weight <= 0 or height <= 0)
     */
    public double calculateBMI(double weight, double height) throws IllegalArgumentException {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid input values");
        }
        double heightInMeters = height / 100.0; // convert cm to m
        return weight / (heightInMeters * heightInMeters); 
    }
    
     /**
     * Determines the BMI status based on the given BMI value.
     *
     * @param bmi the BMI value twwwo check
     * @return the corresponding BMI status
     */
    public Status getStatus(double bmi) {
        if (bmi < 19) {
            return Status.UNDER_STANDARD;
        } else if (bmi < 25) {
            return Status.STANDARD;
        } else if (bmi < 30) {
            return Status.OVERWEIGHT;
        } else if (bmi < 40) {
            return Status.FAT_SHOULD_LOSE_WEIGHT;
        } else {
            return Status.VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY;
        }
    }
}
