import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Initialize DataStore objects outside the loop to preserve data
        DataStore<String> strData = new DataStore<>();
        DataStore<Integer> intData = new DataStore<>();
        DataStore<Double> doubleData = new DataStore<>();

        while (!exit) {
            System.out.println("\nWhich data type would you like to work with: (1)String | (2)Integer | (3)Double | (4)Exit");
            int typeChoice = scanner.nextInt();

            // Check for exit option
            if (typeChoice == 4) {
                System.out.println("Exiting the program...");
                exit = true;
            } else {
                // Pass the correct DataStore instance based on the user's choice
                menu(typeChoice, strData, intData, doubleData);
            }
        }
    }

    public static void menu(int typeChoice, DataStore<String> strData, DataStore<Integer> intData, DataStore<Double> doubleData) {
        Scanner scanner = new Scanner(System.in);
        boolean goBack = false;

        // Operations menu, entered after selecting the data type
        while (!goBack) {
            System.out.println("\nSelect an operation: (1) Add Data | (2) Remove Data | (3) Show Data | (4) Go Back");
            int choice = scanner.nextInt();
            scanner.nextLine();  // To clear the newline character after reading an integer

            // Process the user's choice and interact with the correct DataStore instance
            if (typeChoice == 1) {
                goBack = processMenu(strData, scanner, typeChoice, choice);
            } else if (typeChoice == 2) {
                goBack = processMenu(intData, scanner, typeChoice, choice);
            } else if (typeChoice == 3) {
                goBack = processMenu(doubleData, scanner, typeChoice, choice);
            } else {
                System.out.println("Invalid choice!");
                goBack = true;
            }
        }
    }

    // Function to process menu actions
    public static <E> boolean processMenu(DataStore<E> dataStore, Scanner scanner, int typeChoice, int choice) {
        if (choice == 1) {
            System.out.println("Enter the data you want to add:");
            E add = readInput(scanner, typeChoice);  // Read the input in the correct type
            dataStore.add_data(add);
        } else if (choice == 2) {
            System.out.println("Enter the data you want to remove:");
            E remove = readInput(scanner, typeChoice);  // Read the input in the correct type
            dataStore.remove_data(remove);
        } else if (choice == 3) {
            System.out.println("Showing data...");
            dataStore.print_data();
        } else if (choice == 4) {
            return true;  // Exit to the previous menu
        } else {
            System.out.println("Invalid input!");
        }
        return false;  // Stay in the current menu
    }

    // Helper method to read input based on data type
    public static <E> E readInput(Scanner scanner, int typeChoice) {
        if (typeChoice == 1) {
            return (E) scanner.nextLine();  // String
        } else if (typeChoice == 2) {
            return (E) (Integer) scanner.nextInt();  // Integer
        } else if (typeChoice == 3) {
            return (E) (Double) scanner.nextDouble();  // Double
        } else {
            return null;
        }
    }
}
