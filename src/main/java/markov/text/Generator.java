package markov.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Generator class for the main text generation
 */

public class Generator {

    private static HashMap<String, ArrayList<String>> dict = new HashMap<>();
    private static final SecureRandom rand = new SecureRandom();

    /**
     * Function to train the generator on the input text
     *
     * @param s The sentence on which the generator is to be trained
     */
    public static void train(String s) {
        String[] words = s.split("\\s+");

        if (words.length < 4) return;

        for (int i = 3; i < words.length; i++) {
            String key = words[i - 3] + " " + words[i - 2] + " " + words[i - 1];

            dict.putIfAbsent(key, new ArrayList<>());
            dict.get(key).add(words[i]);
        }

        System.out.println("Training completed. Total keys stored: " + dict.size());
    }

    /**
     * Function to train the generator from the file in the path provided.
     *
     * @param path The path to the file
     */
    public static void trainFromPath(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                train(line);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Function to print the keys in the generator
     */
    public static void printKeys() {
        for (String s : dict.keySet()) {
            System.out.println(s);
        }
    }

    /**
     * Function to generate text based on the previous text it is trained and the input text.
     * Returns if no data is found.
     *
     * @param s The starting tet for the generator to produce the rest of the sentences
     * @param desiredLength The desired word number of the output sentence
     * @return The generated text
     */
    public static String generate(String s, int desiredLength) {
        String[] wds = s.split("\\s+");

        if (wds.length < 3) return "Please provide at least three input words.";

        String curr = wds[wds.length - 3] + " " + wds[wds.length - 2] + " " + wds[wds.length - 1];

        if (!dict.containsKey(curr)) return "No data from given dataset";

        StringBuilder builder = new StringBuilder(s + " ");

        for (int i = 0; i < desiredLength; i++) {
            if (!dict.containsKey(curr) || dict.get(curr).isEmpty()) break;

            String nextWord = dict.get(curr).get(rand.nextInt(dict.get(curr).size()));

            builder.append(nextWord).append(" ");

            String[] keyParts = curr.split("\\s+");
            curr = keyParts[1] + " " + keyParts[2] + " " + nextWord;

            //System.out.println("Generating: " + keyParts[0] + " " + keyParts[1] + " " + keyParts[2] + " -> " + nextWord);
        }

        return builder.toString().trim();
    }
}
