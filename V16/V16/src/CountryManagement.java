
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * The CountryManagement class manages country information and provides various
 * operations such as adding, displaying, searching, and sorting.
 *
 * @author NGMINHAT
 */
/**
 *
 * @author NGMINHAT
 */
public class CountryManagement {

    private List<Country> countries = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Runs the country management system.
     */
    public void run() {
        int choice = 0;

        do {
            System.out.println("                               MENU                               ");
            System.out.println("=================================================================");
            System.out.println("1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of the countries you just entered");
            System.out.println("3. Search for country information by user-entered name");
            System.out.println("4. Display Country Information Sorted by Name (Descending Order)");
            System.out.println("5. Exit");
            System.out.println("=================================================================");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addCountryInformation();
                        break;
                    case 2:
                        displayRecentCountryInformation();
                        break;
                    case 3:
                        searchCountryInformationByName();
                        break;
                    case 4:
                        displayCountryInformationSortedByName();
                        break;
                    case 5:
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter an integer(1-5).");
                }

                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter an integer(1-5).");
            }
        } while (choice != 5);
    }

    /**
     * Checks if a string contains numbers.
     *
     * @param input the input string
     * @return true if the string contains numbers, false otherwise
     */
    public static boolean containsNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a country name already exists in the list.
     *
     * @param name the country name to check
     * @return true if the country name already exists, false otherwise
     */
    public boolean isDuplicateCountryName(String name) {
        for (Country country : countries) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a country code already exists in the list.
     *
     * @param code the country code to check
     * @return true if the country code already exists, false otherwise
     */
    public boolean isCountryCodeExist(String code) {
        for (Country country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds country information to the list.
     */
    public void addCountryInformation() {
        System.out.println("Enter Country Information:");
        System.out.print("Country Code: ");
        String code = scanner.nextLine();
        while (code.trim().isEmpty() || isCountryCodeExist(code)) {
            if (isCountryCodeExist(code)) {
                System.out.println("Country code is already taken. Please enter a different country code: ");
            } else {
                System.out.println("Invalid input. Please enter Country Code: ");
            }
            code = scanner.nextLine();
        }
        System.out.print("Country Name: ");
        String name = scanner.nextLine();
        while (name.trim().isEmpty() || containsNumbers(name) || isDuplicateCountryName(name)) {
            if (isDuplicateCountryName(name)) {
                System.out.print("Country name already exists. Please enter a different country name: ");
            } else if (containsNumbers(name)) {
                System.out.print("Invalid input. Country Name cannot contain numbers. Please enter Country Name: ");
            } else {
                System.out.print("Invalid input. Please enter Country Name: ");
            }
            name = scanner.nextLine();
        }
        String[] nameWords = name.toLowerCase().split("\\s+");
        StringBuilder formattedName = new StringBuilder();
        for (String word : nameWords) {
            formattedName.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        formattedName.setLength(formattedName.length() - 1);
        name = formattedName.toString();
        System.out.print("Total Area: ");
        float area;
        while (true) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Invalid input. Please enter Total Area: ");
            } else {
                try {
                    area = Float.parseFloat(input);
                    if (area <= 0) {
                        System.out.println("Invalid input. Total Area must be greater than 0. Please enter Total Area: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Total Area must be greater than 0. Please enter Total Area: ");
                }
            }
        }

        String terrain;
        while (true) {
            System.out.print("Country Terrain: ");
            terrain = scanner.nextLine();
            if (terrain.trim().isEmpty()) {
                System.out.println("Invalid input. Please enter Country Terrain: ");
            } else {
                break;
            }
        }
        EastAsiaCountry country = new EastAsiaCountry(code, name, area, terrain);
        countries.add(country);
        System.out.println("Country information added successfully.");
    }

    /**
     * Checks if a string is numeric.
     *
     * @param input the input string
     * @return true if the string is numeric, false otherwise
     */
    public static boolean isNumeric(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Displays the information of the most recently entered country.
     */
    public void displayRecentCountryInformation() {
        if (countries.isEmpty()) {
            System.out.println("No country information available.");
        } else {
            System.out.println("Recently Entered Country Information:");
            System.out.printf("%-15s %-15s %-15s %-15s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");
            Country country = countries.get(countries.size() - 1);
            country.display();
        }
    }

    /**
     * Displays country information sorted by name in descending order.
     */
    public void displayCountryInformationSortedByName() {
        if (countries.isEmpty()) {
            System.out.println("No country information available.");
        } else {
            List<Country> sortedCountries = new ArrayList<>(countries);
            Collections.sort(sortedCountries, Comparator.comparing(Country::getCountryName).reversed());

            System.out.println("Country Information Sorted by Name (Descending Order):");
            System.out.printf("%-15s %-15s %-15s %-15s", "Country Code", "Country Name", "Total Area", "Country Terrain");
            for (Country country : sortedCountries) {
                country.display();
            }
        }
    }

    /**
     * Searches for country information by user-entered name.
     */
    public void searchCountryInformationByName() {
        if (countries.isEmpty()) {
            System.out.println("No country information available.");
        } else {
            System.out.print("Enter Country Name to Search: ");
            String searchName = scanner.nextLine();
            List<Country> searchResults = new ArrayList<>();

            for (Country country : countries) {
                if (country.getCountryName().equalsIgnoreCase(searchName)) {
                    searchResults.add(country);
                }
            }

            if (searchResults.isEmpty()) {
                System.out.println("No matching country found.");
            } else {
                System.out.println("Matching Countries:");
                System.out.println("Country Information:");
                System.out.printf("%-15s %-15s %-15s %-15s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");
                for (Country country : searchResults) {
                    country.display();
                }
            }
        }
    }
}
