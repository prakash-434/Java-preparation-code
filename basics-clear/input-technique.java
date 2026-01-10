import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class InputTechniquesDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== JAVA INPUT TECHNIQUES DEMO ===\n");
        
        // ==========================================
        // 1. INTEGER INPUT (int)
        // ==========================================
        System.out.println("--- INTEGER INPUT ---");
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        System.out.println("You entered: " + num);
        
        // Multiple integers in one line (space-separated)
        System.out.print("Enter 3 integers separated by space: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("You entered: " + a + ", " + b + ", " + c);
        
        // ==========================================
        // 2. LONG INPUT
        // ==========================================
        System.out.println("\n--- LONG INPUT ---");
        System.out.print("Enter a long number: ");
        long longNum = scanner.nextLong();
        System.out.println("You entered: " + longNum);
        
        // ==========================================
        // 3. FLOAT INPUT
        // ==========================================
        System.out.println("\n--- FLOAT INPUT ---");
        System.out.print("Enter a float number: ");
        float floatNum = scanner.nextFloat();
        System.out.println("You entered: " + floatNum);
        
        // ==========================================
        // 4. DOUBLE INPUT
        // ==========================================
        System.out.println("\n--- DOUBLE INPUT ---");
        System.out.print("Enter a double number: ");
        double doubleNum = scanner.nextDouble();
        System.out.println("You entered: " + doubleNum);
        
        // ==========================================
        // 5. BYTE INPUT
        // ==========================================
        System.out.println("\n--- BYTE INPUT ---");
        System.out.print("Enter a byte (-128 to 127): ");
        byte byteNum = scanner.nextByte();
        System.out.println("You entered: " + byteNum);
        
        // ==========================================
        // 6. SHORT INPUT
        // ==========================================
        System.out.println("\n--- SHORT INPUT ---");
        System.out.print("Enter a short number: ");
        short shortNum = scanner.nextShort();
        System.out.println("You entered: " + shortNum);
        
        // ==========================================
        // 7. BOOLEAN INPUT
        // ==========================================
        System.out.println("\n--- BOOLEAN INPUT ---");
        System.out.print("Enter a boolean (true/false): ");
        boolean boolValue = scanner.nextBoolean();
        System.out.println("You entered: " + boolValue);
        
        // Clear buffer before string input
        scanner.nextLine();
        
        // ==========================================
        // 8. CHARACTER INPUT
        // ==========================================
        System.out.println("\n--- CHARACTER INPUT ---");
        System.out.print("Enter a character: ");
        char charValue = scanner.next().charAt(0);
        System.out.println("You entered: " + charValue);
        
        // Alternative method for character
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter another character: ");
        String temp = scanner.nextLine();
        char charValue2 = temp.charAt(0);
        System.out.println("You entered: " + charValue2);
        
        // ==========================================
        // 9. STRING INPUT (SINGLE WORD)
        // ==========================================
        System.out.println("\n--- STRING INPUT (Single Word) ---");
        System.out.print("Enter a single word: ");
        String word = scanner.next();
        System.out.println("You entered: " + word);
        
        // ==========================================
        // 10. STRING INPUT (ENTIRE LINE)
        // ==========================================
        scanner.nextLine(); // Clear buffer
        System.out.println("\n--- STRING INPUT (Entire Line) ---");
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("You entered: " + sentence);
        
        // ==========================================
        // 11. ARRAY INPUT
        // ==========================================
        System.out.println("\n--- ARRAY INPUT ---");
        
        // Integer Array
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(arr));
        
        // String Array
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter number of strings: ");
        int strSize = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        String[] strArr = new String[strSize];
        System.out.println("Enter " + strSize + " strings:");
        for (int i = 0; i < strSize; i++) {
            strArr[i] = scanner.nextLine();
        }
        System.out.println("String Array: " + Arrays.toString(strArr));
        
        // ==========================================
        // 12. 2D ARRAY INPUT
        // ==========================================
        System.out.println("\n--- 2D ARRAY INPUT ---");
        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter columns: ");
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // ==========================================
        // 13. ARRAYLIST INPUT
        // ==========================================
        scanner.nextLine(); // Clear buffer
        System.out.println("\n--- ARRAYLIST INPUT ---");
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("How many numbers to add: ");
        int count = scanner.nextInt();
        System.out.println("Enter " + count + " numbers:");
        for (int i = 0; i < count; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println("ArrayList: " + list);
        
        // ==========================================
        // 14. DYNAMIC INPUT (Until specific input)
        // ==========================================
        scanner.nextLine(); // Clear buffer
        System.out.println("\n--- DYNAMIC INPUT ---");
        System.out.println("Enter numbers (type 'stop' to end):");
        ArrayList<Integer> dynamicList = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                dynamicList.add(scanner.nextInt());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("stop")) {
                    break;
                }
            }
        }
        System.out.println("Dynamic List: " + dynamicList);
        
        // ==========================================
        // 15. COMMA-SEPARATED INPUT
        // ==========================================
        scanner.nextLine(); // Clear buffer
        System.out.println("\n--- COMMA-SEPARATED INPUT ---");
        System.out.print("Enter numbers separated by commas: ");
        String csvInput = scanner.nextLine();
        String[] csvArray = csvInput.split(",");
        System.out.println("Parsed values:");
        for (String value : csvArray) {
            System.out.println(value.trim());
        }
        
        // ==========================================
        // 16. INPUT WITH VALIDATION
        // ==========================================
        System.out.println("\n--- INPUT WITH VALIDATION ---");
        int validNum = 0;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print("Enter a positive integer: ");
                validNum = scanner.nextInt();
                if (validNum > 0) {
                    validInput = true;
                    System.out.println("Valid input: " + validNum);
                } else {
                    System.out.println("Please enter a positive number!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        // ==========================================
        // 17. READING ENTIRE LINE AS INTEGERS
        // ==========================================
        scanner.nextLine(); // Clear buffer
        System.out.println("\n--- LINE OF INTEGERS ---");
        System.out.print("Enter integers in one line (space-separated): ");
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        int[] intArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            intArray[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println("Parsed integers: " + Arrays.toString(intArray));
        
        // ==========================================
        // 18. MENU-DRIVEN INPUT
        // ==========================================
        System.out.println("\n--- MENU-DRIVEN INPUT ---");
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("You selected Option 1");
                    break;
                case 2:
                    System.out.println("You selected Option 2");
                    break;
                case 3:
                    System.out.println("You selected Option 3");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        
        // ==========================================
        // 19. USING hasNext() METHODS
        // ==========================================
        System.out.println("\n--- USING hasNext() METHODS ---");
        System.out.print("Enter any value: ");
        
        if (scanner.hasNextInt()) {
            System.out.println("It's an integer: " + scanner.nextInt());
        } else if (scanner.hasNextDouble()) {
            System.out.println("It's a double: " + scanner.nextDouble());
        } else if (scanner.hasNextBoolean()) {
            System.out.println("It's a boolean: " + scanner.nextBoolean());
        } else {
            System.out.println("It's a string: " + scanner.next());
        }
        
        // Close scanner
        scanner.close();
        System.out.println("\n=== PROGRAM ENDED ===");
    }
}



****************

Additional Input Techniques
1. Using BufferedReader (Alternative to Scanner)
javaimport java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderInput {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // String input
        System.out.print("Enter your name: ");
        String name = reader.readLine();
        
        // Integer input
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(reader.readLine());
        
        // Double input
        System.out.print("Enter your salary: ");
        double salary = Double.parseDouble(reader.readLine());
        
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        
        reader.close();
    }
}
2. Using Console Class
javaimport java.io.Console;

public class ConsoleInput {
    public static void main(String[] args) {
        Console console = System.console();
        
        if (console != null) {
            String username = console.readLine("Enter username: ");
            char[] password = console.readPassword("Enter password: ");
            
            System.out.println("Username: " + username);
            System.out.println("Password entered (hidden)");
        } else {
            System.out.println("Console not available");
        }
    }
}
3. Using Scanner with Custom Delimiter
javaimport java.util.Scanner;

public class CustomDelimiterInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Set custom delimiter (comma)
        scanner.useDelimiter(",");
        
        System.out.println("Enter values separated by commas:");
        while (scanner.hasNext()) {
            String value = scanner.next().trim();
            System.out.println("Value: " + value);
            
            if (value.equalsIgnoreCase("stop")) {
                break;
            }
        }
        
        scanner.close();
    }
}


******************************