/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s20analyzetheuserinputstring;

/**
 * This class represents the entry point of the program. It prompts the user for
 * an input string, performs the analysis, and displays the results.
 *
 * @author khuakhanhhuy
 */
public class S20AnalyzeTheUserInputString {

    /**
     * The main method of the program. It prompts the user for an input string,
     * performs the analysis, and displays the results.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        UserInterface ui = new UserInterface();
        String input = ui.getInputString();
        StringAnalyzer analyzer = new StringAnalyzer(input);
        analyzer.analyze();
        ui.displayAnalysisResults(analyzer.getAnalysisResults());
    }

}
