package markov.text;

import java.util.Scanner;

/**
 *  TUI for the Markov Text Generator
 */

public class TUI {
    public static void ui() {
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nMarkov Text Generator");
                System.out.println("1. Train with input text");
                System.out.println("2. Train from file");
                System.out.println("3. Generate text");
                System.out.println("4. View stored keys");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter training text: ");
                        String inputText = scanner.nextLine();
                        Generator.train(inputText);
                        System.out.println("Text trained successfully.");
                    }
                    case 2 -> {
                        System.out.print("Enter file path: ");
                        String filePath = scanner.nextLine();
                        Generator.trainFromPath(filePath);
                        System.out.println("File trained successfully.");
                    }
                    case 3 -> {
                        System.out.print("Enter seed text (at least 3 words): ");

                        String seed = scanner.nextLine();
                        System.out.print("Enter desired output length: ");
                        int length = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Generated text: " + Generator.generate(seed, length));
                    }
                    case 4 -> {
                        System.out.println("Stored keys:");
                        Generator.printKeys();
                    }
                    case 5 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
