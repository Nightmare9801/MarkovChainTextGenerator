# Markov Text Generator (TUI)

This is a simple Markov Chain-based text generator implemented in Java with a Terminal User Interface (TUI). It allows users to train a Markov model with input text, generate new text based on trained data, and view stored keys.

## Features
- Train the model using manually inputted text.
- Train the model using a text file.
- Generate text based on a given seed phrase.
- View stored keys used for text generation.
- Simple interactive menu-driven interface.

## Prerequisites
- Java 8 or higher

## Installation
1. Clone or download the repository.
2. Navigate to the project directory.
3. Compile the Java files:
   ```sh
   javac markov/text/*.java
   ```
4. Run the program:
   ```sh
   java markov.text.MarkovTUI
   ```

## Usage
1. Run the program and select an option from the menu.
2. Provide input text or file paths as prompted.
3. Use the "Generate text" option to create new text based on trained data.
4. Exit the program when done.

## Example Usage
```sh
Markov Text Generator
1. Train with input text
2. Train from file
3. Generate text
4. View stored keys
5. Exit
Choose an option: 1
Enter training text: The quick brown fox jumps over the lazy dog
Text trained successfully.
```

## Future Enhancements
- Save and load trained models.
- Improve text parsing and processing.
- Add support for different Markov chain orders.

## License
This project is open-source and available under the MIT License.

