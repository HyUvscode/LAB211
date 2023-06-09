/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author khuakhanhhuy
 */
public class Manager {

    private static final String DATA_FILE = "dictionary.txt";

    public int menu() {
        System.out.println("1. Add new word");
        System.out.println("2. Delete word");
        System.out.println("3. Translate word");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4); // Retrieves the user's choice and validates it within the range 1-5
        return choice;
    }

    public void addNewWord(HashMap<String, String> hm) {
        String english = Validation.getStringTrue("Enter English word: ", "Error: The input origin should only contain letters and spaces.");
        if (hm.containsKey(english)) {
            System.out.println("Word already exists in the dictionary.");
            boolean updateMeaning = Validation.checkInputYN();
            if (updateMeaning) {
                String vietnamese = Validation.getStringTrue("Enter Vietnamese meaning: ", "Error: The input origin should only contain letters and spaces.");
                hm.put(english, vietnamese);
                updateDatabase(hm);
                System.out.println("Word updated successfully.");
            }
        } else {
            String vietnamese = Validation.getStringTrue("Enter Vietnamese meaning: ", "Error: The input origin should only contain letters and spaces.");
            hm.put(english, vietnamese);
            updateDatabase(hm);
            System.out.println("Word added successfully.");
        }
    }

    public void deleteWord(HashMap<String, String> hm) {
        if (hm.isEmpty()) {
            System.out.println("Dictionary is empty. No words to delete.");
            return;
        }

        String english = Validation.getStringTrue("Enter English word: ", "Error: The input origin should only contain letters and spaces.");
        if (hm.containsKey(english)) {
            hm.remove(english);
            updateDatabase(hm);
            System.out.println("Word deleted successfully.");
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    public void translate(HashMap<String, String> hm) {
        if (hm.isEmpty()) {
            System.out.println("Dictionary is empty. No words to translate.");
            return;
        }

        String english = Validation.getStringTrue("Enter English word: ", "Error: The input origin should only contain letters and spaces.");
        if (hm.containsKey(english)) {
            String vietnamese = hm.get(english);
            System.out.println("Vietnamese meaning: " + vietnamese);
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    public void loadData(HashMap<String, String> hm) {
        try {
            File file = new File(DATA_FILE);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        String english = parts[0].trim();
                        String vietnamese = parts[1].trim();
                        hm.put(english, vietnamese);
                    }
                }
                scanner.close();
                System.out.println("Data loaded successfully.");
            } else {
                System.out.println("Data file does not exist. Starting with an empty dictionary.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while loading data: " + e.getMessage());
        }
    }

    public void updateDatabase(HashMap<String, String> hm) {
        try {
            FileWriter writer = new FileWriter(DATA_FILE);
            for (String english : hm.keySet()) {
                String vietnamese = hm.get(english);
                writer.write(english + " = " + vietnamese + "\n");
            }
            writer.close();
            System.out.println("Data updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating data: " + e.getMessage());
        }
    }

    /**
     * Checks if the data file exists.
     *
     * @return true if the data file exists, false otherwise
     */
    public static boolean hasDataFile() {
        File file = new File("dictionary.txt");
        return file.exists();
    }
}
