/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s20analyzetheuserinputstring;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * The UserInterface class handles the user interaction.
 * It prompts the user for input string and displays the analysis results.
 * The analysis results include number analysis and character analysis.
 * The class provides methods to get user input and display the analysis results.
 * 
 * @author khuakhanhhuy
 */
public class UserInterface {

    private Scanner scanner;

    /**
     * Constructs a UserInterface object.
     * Initializes the Scanner for user input.
     */
    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user to enter an input string.
     * 
     * @return The input string entered by the user.
     */
    public String getInputString() {
        System.out.println("===== Analysis String program ====");
        System.out.print("Input String: ");
        return scanner.nextLine();
    }

    /**
     * Displays the analysis results to the user.
     * 
     * @param analysisResults The analysis results to be displayed.
     */
    public void displayAnalysisResults(AnalysisResults analysisResults) {
        System.out.println("\n-----Result Analysis------");
        displayNumberAnalysis(analysisResults.getNumberAnalysis());
        displayCharacterAnalysis(analysisResults.getCharacterAnalysis());
    }

    /**
     * Displays the number analysis results to the user.
     * 
     * @param numberAnalysis The number analysis results to be displayed.
     */
    private void displayNumberAnalysis(HashMap<String, List<?>> numberAnalysis) {
        for (String key : numberAnalysis.keySet()) {
            System.out.println(key + ": " + numberAnalysis.get(key));
        }
    }

    /**
     * Displays the character analysis results to the user.
     * 
     * @param characterAnalysis The character analysis results to be displayed.
     */
    private void displayCharacterAnalysis(HashMap<String, StringBuilder> characterAnalysis) {
        for (String key : characterAnalysis.keySet()) {
            System.out.println(key + ": " + characterAnalysis.get(key).toString());
        }
    }
}