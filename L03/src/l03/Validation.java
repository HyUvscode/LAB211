package l03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The Validation class provides methods for validating user input. It includes
 * methods for inputting integers, doubles, strings, and checking yes/no inputs.
 *
 * @author khuakhanhhuy
 */
public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to input an integer within a specified range.
     *
     * @param mess the message to display as a prompt
     * @param min the minimum allowed value (inclusive)
     * @param max the maximum allowed value (inclusive)
     * @return the validated integer input from the user
     */
    public static int inputInt(String mess, int min, int max) {
        System.out.print(mess); // Display the prompt message
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) { // Check range of number
                    System.out.print("Please input between " + min + ", " + max + ": "); // Prompt for input within the specified range
                    continue;
                }
                return number; // Return the validated input number
            } catch (Exception e) {
                System.out.print("Please input an integer number: "); // Prompt for an integer input
            }
        }
    }

    /**
     * Prompts the user for a double input within a specified range.
     *
     * @param mess the message to display to the user
     * @param min the minimum allowed value (inclusive)
     * @param max the maximum allowed value (inclusive)
     * @return the validated double input
     */
    public static double inputDouble(String mess, double min, double max) {
        System.out.print(mess); // Display the prompt message
        while (true) {
            String input = scanner.nextLine();
            try {
                double number = Double.parseDouble(input);
                // Check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": "); // Prompt for input within the specified range
                    continue;
                }
                return number; // Return the validated input number
            } catch (Exception e) {
                System.out.print("Please input a double number: "); // Prompt for a double input
            }
        }
    }

    /**
     * Prompts the user for a string input that matches a specified regex
     * pattern.
     *
     * @param mess the message to display to the user
     * @param regex the regular expression pattern to match
     * @return the validated string input
     */
    public static String inputString(String mess, String regex) {
        System.out.print(mess); // Display the prompt message
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(regex)) { // Check if the input matches the regex pattern
                System.out.print(regex); // Prompt for input that matches the regex pattern
                continue;
            }
            return input; // Return the validated input string
        }
    }

    /**
     * Prompts the user for a yes/no input (Y/N) and returns a corresponding
     * boolean value.
     *
     * @param mess the message to display to the user
     * @return true if the user input is "Y" or "y", false if the user input is
     * "N" or "n"
     */
    public static boolean checkInputYN(String mess) {
        System.out.println(mess); // Display the prompt message
        while (true) {
            String result = scanner.nextLine();

            if (result.equalsIgnoreCase("Y")) {
                return true; // Return true if the input is "Y" or "y"
            }

            if (result.equalsIgnoreCase("N")) {
                return false; // Return false if the input is "N" or "n"
            }
            System.err.println("Please input y/Y or n/N."); // Display error message for invalid input
            System.out.print("Enter again: "); // Prompt the user to enter again
        }
    }

    /**
     * Reads an integer input from the user and ensures it is within the
     * specified range.
     *
     * @param min the minimum allowed value
     * @param max the maximum allowed value
     * @return the validated integer input
     */
    public static int checkInputIntLimit(int min, int max) {
        // Loop until the user inputs a correct value
        while (true) {
            try {
                // Read the user input as a string and remove leading/trailing spaces
                int result = Integer.parseInt(scanner.nextLine().trim());
                // Check if the input is within the specified range
                if (result < min || result > max) {
                    throw new NumberFormatException(); // Throw an exception to handle out-of-range input
                }
                return result; // Return the valid input value
            } catch (NumberFormatException e) {
                // Catch the exception if the input is not a valid integer or is out of range
                System.err.println("Please input a number in the range [" + min + ", " + max + "]");
                System.out.print("Enter again: "); // Prompt the user to enter the value again
            }
        }
    }

    /**
     * Reads a non-empty string input from the user.
     *
     * @return the non-empty string input
     */
    public static String checkInputString() {
        // Loop until the user inputs a non-empty value
        while (true) {
            String result = scanner.nextLine().trim(); // Read the user input as a string and remove leading/trailing spaces
            if (result.isEmpty()) {
                System.err.println("Input should not be empty"); // Display an error message if the input is empty
                System.out.print("Enter again: "); // Prompt the user to enter the value again
            } else {
                return result; // Return the non-empty input value
            }
        }
    }

    /**
     * Reads an integer input from the user and ensures it is a valid integer.
     *
     * @return the validated integer input
     */
    public static int checkInputInt() {
        // Loop until the user inputs a correct integer value
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim()); // Read the user input as a string, convert it to an integer
                return result; // Return the integer value
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Must enter an integer."); // Display an error message if the input is not a valid integer
                System.out.print("Enter again: "); // Prompt the user to enter the value again
            }
        }
    }

    /**
     * Prompts the user to input 'Y' or 'N' and returns true for 'Y' and false
     * for 'N
     *
     * @return true if the user inputs 'Y', false if the user inputs 'N'
     */
    public static boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        // Loop until the user inputs a correct choice
        while (true) {
            String result = checkInputString(); // Read the user input as a string
            // Return true if the user input is 'y' or 'Y'
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            // Return false if the user input is 'n' or 'N'
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input 'y' or 'Y' for Yes, or 'n' or 'N' for No."); // Display an error message for invalid input
            System.out.print("Enter again: "); // Prompt the user to enter the choice again
        }
    }

    /**
     * Checks if all items in the list are out of stock.
     *
     * @param lf the list of fruits
     * @return true if all items are out of stock, false otherwise
     */
    public static boolean areAllItemsOutOfStock(List<Fruit> lf) {
        boolean allOutOfStock = true; // Assume all items are out of stock initially
        for (Fruit fruit : lf) { // Iterate through each fruit in the list
            if (fruit.getQuantity() > 0) { // If the fruit's quantity is greater than 0
                allOutOfStock = false; // Set allOutOfStock to false
                break; // Exit the loop since we found a fruit that is not out of stock
            }
        }
        return allOutOfStock; // Return the value of allOutOfStock
    }

    /**
     * Checks if a given ID exists in the list of fruits.
     *
     * @param lf the list of fruits to check
     * @param id the ID to search for
     * @return true if the ID doesn't exist in the list, false if the ID exists
     */
    public static boolean checkIdExist(ArrayList<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            // Check if the given ID matches any existing fruit ID in the list
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return false; // ID exists, return false
            }
        }
        return true; // ID doesn't exist, return true
    }

    /**
     * Returns the size of the fruit list, excluding fruits with quantity equal
     * to 0.
     *
     * @param lf the list of fruits
     * @return the size of the fruit list
     */
    public static int getFruitListSize(ArrayList<Fruit> lf) {
        int size = lf.size(); // Initialize size with the total number of fruits
        for (Fruit fruit : lf) { // Iterate through each fruit in the list
            if (fruit.getQuantity() == 0) { // If the fruit's quantity is 0
                size--; // Decrement the size by 1
            }
        }
        return size; // Return the updated size
    }

    /**
     * Get an integer value from the user.
     *
     * @param prompt the prompt message
     * @return the validated integer value
     */
    public static int getInt(String prompt) { // Define a method to get an integer value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            try { // Start a try-catch block to handle NumberFormatException
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) { // Check if the value is greater than zero
                    return value;
                } else {
                    System.err.println("Invalid input, please enter an integer greater than zero.");
                }
            } catch (NumberFormatException e) { // Catch NumberFormatException
                System.err.println("Invalid input, please enter an integer."); // Print an error message for invalid input
            }
        }
    }

    /**
     * Get a double value from the user.
     *
     * @param prompt the prompt message
     * @return the validated double value
     */
    public static double getDouble(String prompt) { // Define a method to get a double value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            try { // Start a try-catch block to handle NumberFormatException
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) { // Check if the value is greater than zero
                    return value;
                } else {
                    System.err.println("Invalid input, please enter a number greater than zero.");
                }
            } catch (NumberFormatException e) { // Catch NumberFormatException
                System.err.println("Invalid input, please enter a number."); // Print an error message for invalid input
            }
        }
    }

    /**
     * Get a String from the user.
     *
     * @param prompt the prompt message
     * @return the validated String.
     */
    public static String getString(String prompt, String errorMessage) { // Define a method to get a string value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            String input = scanner.nextLine(); // Read a string value from the user

            if (!input.equals("") && !input.equals(null)) { // Check if the input is not empty or null
                return input; // Return the input
            } else {
                System.out.println(errorMessage); // Print an error message for empty input
                return null; // Return null
            }
        }
    }

    /**
     * Get a character value from the user.
     *
     * @param prompt the prompt message
     * @return the validated character value
     */
    public static char getChar(String prompt) { // Define a method to get a character value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            String input = scanner.nextLine(); // Read a string value from the user
            if (input.length() != 1) { // Check if the input length is not 1
                System.out.println("Invalid input, please enter a single character."); // Print an error message for invalid input
            } else {
                return input.charAt(0); // Return the first character of the input string
            }
        }
    }

    /**
     * Get a boolean value from the user.
     *
     * @param prompt the prompt message
     * @return the validated boolean value
     */
    public static boolean getBoolean(String prompt) { // Define a method to get a boolean value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            String input = scanner.nextLine().toLowerCase(); // Read a string value from the user and convert it to lowercase
            if (input.equals("true") || input.equals("yes") || input.equals("y")) { // Check if the input is true, yes, or y
                return true; // Return true
            } else if (input.equals("false") || input.equals("no") || input.equals("n")) { // Check if the input is false, no, or n
                return false; // Return false
            } else {
                System.out.println("Invalid input, please enter 'true' or 'false'."); // Print an error message for invalid input
            }
        }
    }

    /**
     * Read a positive integer value from the scanner.
     *
     * @param scanner the scanner object
     * @param prompt the prompt message
     * @return the validated positive integer value
     */
    public static int readPositiveInt(Scanner scanner, String prompt) { // Define a method to read a positive integer value
        int value = 0; // Initialize the value to 0
        while (value <= 0) { // Start a loop while the value is less than or equal to 0
            System.out.println(prompt); // Print the prompt
            if (scanner.hasNextInt()) { // Check if the scanner has a next integer
                value = scanner.nextInt(); // Read an integer value from the scanner
                if (value <= 0) { // Check if the value is less than or equal to 0
                    System.out.println("Value must be a positive integer!"); // Print an error message for invalid input
                }
            } else {
                System.out.println("Invalid input! Value must be a positive integer."); // Print an error message for invalid input
                scanner.next(); // Discard the invalid input
            }
        }
        return value; // Return the positive integer value
    }

    /**
     * Prompts the user for a non-empty string value and returns the value
     * entered. If the user enters an empty input, an error message is displayed
     * and the user is prompted to enter a valid value.
     *
     * @param prompt the prompt to display to the user
     * @param errorMessage the error message to display for invalid input
     * @return the non-empty string value entered by the user
     */
    public static String getStringOrigin(String prompt, String errorMessage) {
        String input;

        do {
            System.out.print(prompt); // Display the prompt to the user
            input = scanner.nextLine().trim(); // Read the user input and remove leading/trailing spaces

            // Check if the name is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage); // Display the error message for empty input
                continue;
            }

            // Check if the name contains special characters or numbers
            if (!input.matches("^[a-zA-Z ]+$")) {
                System.out.println(errorMessage); // Display the error message for invalid characters
                continue;
            }

            break;
        } while (true);

        return input;
    }

    /**
     * Prompts the user for a non-empty string value that matches a specific
     * phone number format and returns the value entered. If the user enters an
     * empty input or an invalid phone number format, an error message is
     * displayed and the user is prompted to enter a valid value.
     *
     * @param prompt the prompt to display to the user
     * @param errorMessage the error message to display for invalid input
     * @return the non-empty string value entered by the user with a valid phone
     * number format
     */
    public static String getStringWithPhoneFormat(String prompt, String errorMessage) {
        String input;
        do {
            System.out.print(prompt); // Display the prompt to the user
            input = scanner.nextLine().trim(); // Read the user input and remove leading/trailing spaces
            if (input.isEmpty() || !isValidPhoneNumber(input)) {
                System.out.println(errorMessage); // Display the error message for empty or invalid input
            }
        } while (input.isEmpty() || !isValidPhoneNumber(input));

        return input;
    }

    /**
     * Validates if the given phone number has a valid format.
     *
     * @param phoneNumber the phone number to validate
     * @return true if the phone number has a valid format, false otherwise
     */
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("(0[35789][0-9][0-9]{7})");
    }

    public static String getStringWithNumbers(String prompt, String errorMessage) {
        String input;

        do {
            System.out.print(prompt); // Display the prompt to the user
            input = scanner.nextLine().trim(); // Read the user input and remove leading/trailing spaces

            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage); // Display the error message for empty input
                continue;
            }

            // Check if the input contains special characters
            if (!input.matches("^[a-zA-Z0-9 ]+$")) {
                System.err.println(errorMessage); // Display the error message for invalid characters
                continue;
            }

            break;
        } while (true);
        return input;
    }

    /**
     * Get the origin from the user.
     *
     * @param prompt the prompt message
     * @param errorMessage the error message for invalid input
     * @return the validated origin
     */
    public static String getOriginInInternational(String prompt, String errorMessage) {
        // Define a list of valid origins (country names)
        List<String> validOrigins = Arrays.asList(
                // List of country names
                "AFGHANISTAN", "ALBANIA", "ALGERIA", "ANDORRA", "ANGOLA", "ANTIGUA AND BARBUDA", "ARGENTINA",
                "ARMENIA", "AUSTRALIA", "AUSTRIA", "AZERBAIJAN", "BAHAMAS", "BAHRAIN", "BANGLADESH", "BARBADOS",
                "BELARUS", "BELGIUM", "BELIZE", "BENIN", "BHUTAN", "BOLIVIA", "BOSNIA AND HERZEGOVINA", "BOTSWANA",
                "BRAZIL", "BRUNEI", "BULGARIA", "BURKINA FASO", "BURUNDI", "CABO VERDE", "CAMBODIA", "CAMEROON",
                "CANADA", "CENTRAL AFRICAN REPUBLIC", "CHAD", "CHILE", "CHINA", "COLOMBIA", "COMOROS", "CONGO",
                "COSTA RICA", "CROATIA", "CUBA", "CYPRUS", "CZECH REPUBLIC", "DENMARK", "DJIBOUTI", "DOMINICA",
                "DOMINICAN REPUBLIC", "EAST TIMOR", "ECUADOR", "EGYPT", "EL SALVADOR", "EQUATORIAL GUINEA", "ERITREA",
                "ESTONIA", "ESWATINI", "ETHIOPIA", "FIJI", "FINLAND", "FRANCE", "GABON", "GAMBIA", "GEORGIA", "GERMANY",
                "GHANA", "GREECE", "GRENADA", "GUATEMALA", "GUINEA", "GUINEA-BISSAU", "GUYANA", "HAITI", "HONDURAS",
                "HUNGARY", "ICELAND", "INDIA", "INDONESIA", "IRAN", "IRAQ", "IRELAND", "ISRAEL", "ITALY", "JAMAICA",
                "JAPAN", "JORDAN", "KAZAKHSTAN", "KENYA", "KIRIBATI", "KOREA, NORTH", "KOREA, SOUTH", "KOSOVO",
                "KUWAIT", "KYRGYZSTAN", "LAOS", "LATVIA", "LEBANON", "LESOTHO", "LIBERIA", "LIBYA", "LIECHTENSTEIN",
                "LITHUANIA", "LUXEMBOURG", "MADAGASCAR", "MALAWI", "MALAYSIA", "MALDIVES", "MALI", "MALTA",
                "MARSHALL ISLANDS", "MAURITANIA", "MAURITIUS", "MEXICO", "MICRONESIA", "MOLDOVA", "MONACO",
                "MONGOLIA", "MONTENEGRO", "MOROCCO", "MOZAMBIQUE", "MYANMAR", "NAMIBIA", "NAURU", "NEPAL",
                "NETHERLANDS", "NEW ZEALAND", "NICARAGUA", "NIGER", "NIGERIA", "NORTH MACEDONIA", "NORWAY", "OMAN",
                "PAKISTAN", "PALAU", "PANAMA", "PAPUA NEW GUINEA", "PARAGUAY", "PERU", "PHILIPPINES", "POLAND",
                "PORTUGAL", "QATAR", "ROMANIA", "RUSSIA", "RWANDA", "SAINT KITTS AND NEVIS", "SAINT LUCIA",
                "SAINT VINCENT AND THE GRENADINES", "SAMOA", "SAN MARINO", "SAO TOME AND PRINCIPE", "SAUDI ARABIA",
                "SENEGAL", "SERBIA", "SEYCHELLES", "SIERRA LEONE", "SINGAPORE", "SLOVAKIA", "SLOVENIA",
                "SOLOMON ISLANDS", "SOMALIA", "SOUTH AFRICA", "SOUTH SUDAN", "SPAIN", "SRI LANKA", "SUDAN",
                "SURINAME", "SWEDEN", "SWITZERLAND", "SYRIA", "TAIWAN", "TAJIKISTAN", "TANZANIA", "THAILAND",
                "TOGO", "TONGA", "TRINIDAD AND TOBAGO", "TUNISIA", "TURKEY", "TURKMENISTAN", "TUVALU", "UGANDA",
                "UKRAINE", "UNITED ARAB EMIRATES", "UNITED KINGDOM", "UNITED STATES", "URUGUAY", "UZBEKISTAN",
                "VANUATU", "VATICAN CITY", "VENEZUELA", "YEMEN", "ZAMBIA", "ZIMBABWE", "VIETNAM",
                "AF", "AL", "DZ", "AD", "AO", "AG", "AR", "AM", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY", "BE", "BZ", "BJ",
                "BT", "BO", "BA", "BW", "BR", "BN", "BG", "BF", "BI", "CV", "KH", "CM", "CA", "CF", "TD", "CL", "CN", "CO", "KM",
                "CG", "CR", "HR", "CU", "CY", "CZ", "DK", "DJ", "DM", "DO", "TL", "EC", "EG", "SV", "GQ", "ER", "EE", "SZ", "ET",
                "FJ", "FI", "FR", "GA", "GM", "GE", "DE", "GH", "GR", "GD", "GT", "GN", "GW", "GY", "HT", "HN", "HU", "IS", "IN",
                "ID", "IR", "IQ", "IE", "IL", "IT", "JM", "JP", "JO", "KZ", "KE", "KI", "KP", "KR", "XK", "KW", "KG", "LA", "LV",
                "LB", "LS", "LR", "LY", "LI", "LT", "LU", "MG", "MW", "MY", "MV", "ML", "MT", "MH", "MR", "MU", "MX", "FM", "MD",
                "MC", "MN", "ME", "MA", "MZ", "MM", "NA", "NR", "NP", "NL", "NZ", "NI", "NE", "NG", "MK", "NO", "OM", "PK", "PW",
                "PA", "PG", "PY", "PE", "PH", "PL", "PT", "QA", "RO", "RU", "RW", "KN", "LC", "VC", "WS", "SM", "ST", "SA", "SN",
                "RS", "SC", "SL", "SG", "SK", "SI", "SB", "SO", "ZA", "SS", "ES", "LK", "SD", "SR", "SE", "CH", "SY", "TW", "TJ",
                "TZ", "TH", "TG", "TO", "TT", "TN", "TR", "TM", "TV", "UG", "UA", "AE", "GB", "US", "UY", "UZ", "VU", "VA", "VE",
                "VN", "YE", "ZM", "ZW"
        );
        while (true) {
            // Prompt the user to enter an origin
            String origin = getStringOrigin(prompt, errorMessage);

            if (validOrigins.contains(origin.toUpperCase())) {
                return origin; // Return the valid origin
            } else {
                // Display an error message if the entered origin is not valid
                System.err.println("Invalid origin. Please input one of the following country names: ");
                System.err.println("Korea, Qatar, United States, Cuba, Japan and Thailand, Argentina, ...");
            }
        }
    }

    /**
     * Get the origin from the user.
     *
     * @param prompt the prompt message
     * @param errorMessage the error message for invalid input
     * @return the validated origin
     */
    public static String getOriginInDomestic(String prompt, String errorMessage) {
        // Define a list of valid origins (province names in Vietnamese)
        List<String> validOrigins = Arrays.asList(
                // List of province names in Vietnamese in uppercase
                "HA NOI", "HO CHI MINH", "HAI PHONG", "DA NANG", "CAN THO", "AN GIANG", "BA RIA - VUNG TAU", "BAC LIEU",
                "BAC GIANG", "BAC KAN", "BAC NINH", "BEN TRE", "BINH DUONG", "BINH DINH", "BINH PHUOC", "BINH THUAN",
                "CA MAU", "CAO BANG", "DAK LAK", "DAK NONG", "DIEN BIEN", "DONG NAI", "DONG THAP", "GIA LAI", "HA GIANG",
                "HA NAM", "HA TINH", "HAI DUONG", "HAU GIANG", "HOA BINH", "HUNG YEN", "KHANH HOA", "KIEN GIANG", "KON TUM",
                "LAI CHAU", "LAM DONG", "LANG SON", "LAO CAI", "LONG AN", "NAM DINH", "NGHE AN", "NINH BINH", "NINH THUAN",
                "PHU THO", "QUANG BINH", "QUANG NAM", "QUANG NGAI", "QUANG NINH", "QUANG TRI", "SOC TRANG", "SON LA", "TAY NINH",
                "THAI BINH", "THAI NGUYEN", "THANH HOA", "THUA THIEN HUE", "TIEN GIANG", "TRA VINH", "TUYEN QUANG", "VINH LONG",
                "VINH PHUC", "YEN BAI", "PHU YEN", "CAO BANG",
                "AG", "BL", "BN", "BRVT", "BG", "BT", "BTL", "CB", "CT", "CM",
                "CBG", "DL", "DN", "DB", "GL", "HG", "HD", "HCM", "HP", "HB",
                "HY", "HNA", "HT", "HNI", "HN", "HDG", "KG", "KH", "KT", "LA",
                "LD", "LS", "LC", "LI", "LCA", "LDK", "ND", "NA", "NB", "NT",
                "NI", "PY", "PT", "QB", "QN", "QT", "QN", "ST", "SL", "TN",
                "TV", "TQ", "TB", "TG", "TT", "TV", "VL", "VPG", "YB"
        );
        while (true) {
            // Prompt the user to enter an origin
            String origin = getStringOrigin(prompt, errorMessage);

            if (validOrigins.contains(origin.toUpperCase())) {
                return origin; // Return the valid origin
            } else {
                // Display an error message if the entered origin is not valid
                System.err.println("Invalid origin. Please input one of the following province names in Vietnamese: ");
                System.err.println("Ha Noi, Ho Chi Minh, Da Nang, Can Tho, Cao Bang, Tay Ninh, Bac Lieu, Soc Trang, ...");
            }
        }
    }
}
