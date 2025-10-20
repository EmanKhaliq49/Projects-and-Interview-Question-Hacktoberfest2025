import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @brief Simple Movie Suggester Program in Java
 *
 * This program prompts the user to select a genre (1-4) and then randomly
 * suggests a movie from a predefined list for that genre.
 */
public class MovieSuggester {

    // Define the available genres and their corresponding movie lists using Lists
    private static final List<String> ACTION_MOVIES = Arrays.asList(
        "The Dark Knight",
        "Mad Max: Fury Road",
        "Inception"
    );

    private static final List<String> COMEDY_MOVIES = Arrays.asList(
        "Monty Python and the Holy Grail",
        "Superbad",
        "Airplane!"
    );

    private static final List<String> HORROR_MOVIES = Arrays.asList(
        "The Exorcist",
        "Hereditary",
        "Psycho"
    );

    private static final List<String> SCI_FI_MOVIES = Arrays.asList(
        "Dune",
        "Blade Runner 2049",
        "2001: A Space Odyssey"
    );

    public static void main(String[] args) {
        // Initialize Scanner for user input and Random for movie selection
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int choice = -1; // Initialize choice to an invalid value

        System.out.println("Welcome to the Simple Movie Suggester!\n");
        System.out.println("--------------------------------------");
        System.out.println("Please choose a genre by entering the corresponding number:");
        System.out.println("1. Action");
        System.out.println("2. Comedy");
        System.out.println("3. Horror");
        System.out.println("4. Sci-Fi");
        System.out.print("Enter your choice (1-4): ");

        // Read user input and handle non-integer input
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input. Please enter a whole number.");
            // We exit here because we can't recover from bad input type easily
            return;
        }

        System.out.println("\n--- Movie Suggestion ---");

        // Use a switch statement to handle the different genre choices
        switch (choice) {
            case 1:
                suggestMovie(ACTION_MOVIES, "For an action-packed evening, we suggest:", random);
                break;

            case 2:
                suggestMovie(COMEDY_MOVIES, "Need a laugh? How about:", random);
                break;

            case 3:
                suggestMovie(HORROR_MOVIES, "If you dare, watch this horror film:", random);
                break;

            case 4:
                suggestMovie(SCI_FI_MOVIES, "Explore the future with:", random);
                break;

            default:
                System.out.println("Sorry, that is not a valid genre choice. Please try again with 1, 2, 3, or 4.");
                break;
        }

        System.out.println("--------------------------------------");
        System.out.println("Enjoy your movie!");

        // Close the scanner resource
        scanner.close();
    }

    /**
     * Helper method to randomly select and print a movie suggestion.
     * @param movieList The list of movies for the selected genre.
     * @param prompt The message to display before the suggestion.
     * @param random The Random object used for selection.
     */
    private static void suggestMovie(List<String> movieList, String prompt, Random random) {
        // Generate a random index within the bounds of the list size
        int randomIndex = random.nextInt(movieList.size());
        String suggestedMovie = movieList.get(randomIndex);

        System.out.println(prompt);
        System.out.printf(">> %s\n", suggestedMovie);
    }
}
