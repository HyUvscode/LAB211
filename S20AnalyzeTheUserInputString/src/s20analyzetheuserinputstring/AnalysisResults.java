/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s20analyzetheuserinputstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The AnalysisResults class represents the results of the string analysis.
 * It stores the analysis results for numbers and characters.
 * The analysis results are stored in HashMaps.
 * The class provides methods to set and retrieve the analysis results.
 * The number analysis results are stored as lists, and the character analysis results are stored as StringBuilders.
 * 
 * @author khuakhanhhuy
 */
public class AnalysisResults {

    private HashMap<String, List<?>> numberAnalysis;
    private HashMap<String, StringBuilder> characterAnalysis;

    /**
     * Constructs an AnalysisResults object.
     * Initializes the numberAnalysis and characterAnalysis HashMaps.
     */
    public AnalysisResults() {
        numberAnalysis = new HashMap<>();
        characterAnalysis = new HashMap<>();
    }

    /**
     * Sets the analysis results for numbers.
     * The analysis results are stored as a list.
     * 
     * @param key The key to identify the type of analysis.
     * @param analysis The analysis results as a list.
     */
    public void setNumberAnalysis(String key, List<?> analysis) {
        numberAnalysis.put(key, new ArrayList<>(analysis));
    }

    /**
     * Sets the analysis results for characters.
     * The analysis results are stored as a StringBuilder.
     * 
     * @param key The key to identify the type of analysis.
     * @param analysis The analysis results as a StringBuilder.
     */
    public void setCharacterAnalysis(String key, StringBuilder analysis) {
        characterAnalysis.put(key, new StringBuilder(analysis));
    }

    /**
     * Retrieves the analysis results for numbers.
     * 
     * @return The number analysis results as a HashMap.
     */
    public HashMap<String, List<?>> getNumberAnalysis() {
        return numberAnalysis;
    }

    /**
     * Retrieves the analysis results for characters.
     * 
     * @return The character analysis results as a HashMap.
     */
    public HashMap<String, StringBuilder> getCharacterAnalysis() {
        return characterAnalysis;
    }
}