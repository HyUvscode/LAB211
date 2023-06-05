/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s20analyzetheuserinputstring;

import java.util.ArrayList;
import java.util.List;

/**
 * The StringAnalyzer class is responsible for analyzing a given input string.
 * It analyzes the numbers and characters in the string and stores the analysis
 * results.
 *
 * @author khuakhanhhuy
 *
 *
 */
public class StringAnalyzer {

    private String input;
    private AnalysisResults analysisResults;

    /**
     * Constructs a StringAnalyzer object with the given input string.
     *
     * @param input The input string to be analyzed.
     */
    public StringAnalyzer(String input) {
        this.input = input;
        this.analysisResults = new AnalysisResults();
    }

    /**
     * Performs the analysis of the input string. It analyzes the numbers and
     * characters in the string.
     */
    public void analyze() {
        analyzeNumbers();
        analyzeCharacters();
    }

    /**
     * Retrieves the analysis results.
     *
     * @return The analysis results.
     */
    public AnalysisResults getAnalysisResults() {
        return analysisResults;
    }

    /**
     * Analyzes the numbers in the input string. It identifies all numbers, even
     * numbers, odd numbers, and square numbers.
     */
    private void analyzeNumbers() {
        List<Integer> allNumbers = new ArrayList<>(); // Create a list to store all numbers
        List<Integer> evenNumbers = new ArrayList<>(); // Create a list to store even numbers
        List<Integer> oddNumbers = new ArrayList<>(); // Create a list to store odd numbers
        List<Integer> squareNumbers = new ArrayList<>(); // Create a list to store square numbers

        String[] words = input.split("\\D+"); // Split the input string into words using non-digit characters as separators

        for (String word : words) { // Iterate through each word
            if (word.matches("-?\\d+")) { // Check if the word is a number
                int number = Integer.parseInt(word); // Convert the word to an integer
                allNumbers.add(number); // Add the number to the list of all numbers

                if (number % 2 == 0) { // Check if the number is even
                    evenNumbers.add(number); // Add the number to the list of even numbers
                } else {
                    oddNumbers.add(number); // Add the number to the list of odd numbers
                }

                double sqrt = Math.sqrt(number); // Calculate the square root of the number
                if (sqrt == (int) sqrt) { // Check if the square root is an integer (i.e., the number is a perfect square)
                    squareNumbers.add(number); // Add the number to the list of square numbers
                }
            }
        }

        analysisResults.setNumberAnalysis("All Numbers", allNumbers); // Set the analysis results for all numbers
        analysisResults.setNumberAnalysis("Even Numbers", evenNumbers); // Set the analysis results for even numbers
        analysisResults.setNumberAnalysis("Odd Numbers", oddNumbers); // Set the analysis results for odd numbers
        analysisResults.setNumberAnalysis("Square Numbers", squareNumbers); // Set the analysis results for square numbers
    }

    /**
     * Analyzes the characters in the input string. It identifies all
     * characters, special characters, uppercase characters, and lowercase
     * characters.
     */
    private void analyzeCharacters() {
        StringBuilder allCharacters = new StringBuilder(); // Create a StringBuilder to store all characters
        StringBuilder specialCharacters = new StringBuilder(); // Create a StringBuilder to store special characters
        StringBuilder uppercaseCharacters = new StringBuilder(); // Create a StringBuilder to store uppercase characters
        StringBuilder lowercaseCharacters = new StringBuilder(); // Create a StringBuilder to store lowercase characters

        for (char c : input.toCharArray()) { // Iterate through each character in the input string
            allCharacters.append(c); // Append the character to the StringBuilder for all characters

            if (Character.isUpperCase(c)) { // Check if the character is uppercase
                uppercaseCharacters.append(c); // Append the character to the StringBuilder for uppercase characters
            } else if (Character.isLowerCase(c)) { // Check if the character is lowercase
                lowercaseCharacters.append(c); // Append the character to the StringBuilder for lowercase characters
            } else if (!Character.isWhitespace(c) && !Character.isDigit(c)) { // Check if the character is a special character (neither whitespace nor digit)
                specialCharacters.append(c); // Append the character to the StringBuilder for special characters
            }
        }

        analysisResults.setCharacterAnalysis("All Characters", allCharacters); // Set the analysis results for all characters
        analysisResults.setCharacterAnalysis("Special Characters", specialCharacters); // Set the analysis results for special characters
        analysisResults.setCharacterAnalysis("Uppercase Characters", uppercaseCharacters); // Set the analysis results for uppercase characters
        analysisResults.setCharacterAnalysis("Lowercase Characters", lowercaseCharacters); // Set the analysis results for lowercase characters
    }
}
