import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static List<Story> stories = new ArrayList<Story>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("1. Add Story");
            System.out.println("2. Update Story by ID");
            System.out.println("3. Delete Story by ID");
            System.out.println("4. Get Stories by Category");
            System.out.println("5. Get Stories by Tag");
            System.out.println("6. Get Stories by Date");
            System.out.println("7. Get stories by ID");
            System.out.println("8. Revers Order of Stories");
            System.out.println("9. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStory();
                    break;
                case 2:
                    updateStoryById();
                    break;
                case 3:
                    deleteStoryById();
                    break;
                case 4:
                    getStoryByCateg();
                    break;
                case 5:
                    getStoryByTag();
                    break;
                case 6:
                    getStoryByDate();
                    break;
                case 7:
                    getStoryById ();

                    break;
                case 8:
                    getRevers();
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting program. . .");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }
        }
    }



    private static void addStory() {
        int rundomId = random.nextInt(1000);
        System.out.println("Your story's ID is: " + rundomId);
        System.out.println("Enter story category: ");
        String category = scanner.nextLine();
        System.out.println("Enter story title: ");
        String title = scanner.nextLine();
        System.out.println("Enter story text: ");
        String text = scanner.nextLine();
        System.out.println("Enter story date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        System.out.println("Enter story tags (#-separated): ");
        String[] tagArray = scanner.nextLine().split("#");

        List<String> tags = Arrays.asList(tagArray);

        Story newStory = new Story(rundomId, category, title, text, tags, date);
        stories.add(newStory);

        System.out.println("Story added successfully!");
    }


    private static void updateStoryById() {
    System.out.print("Enter story ID to update: ");
    int idToUpdate = scanner.nextInt();
    scanner.nextLine();

        Story foundStory = findStoryById(idToUpdate);
        if (foundStory != null) {
            System.out.println("Enter updated story text: ");
            String newText = scanner.nextLine();
            foundStory.setText(newText);
            System.out.println("Story updated successfully!");
        } else {
            System.out.println("Story not found.");
        }
    }
    

    private static void deleteStoryById() {
        System.out.print("Enter story ID to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();

        Story foundStory = findStoryById(idToDelete);
        if (foundStory != null) {
            stories.remove(foundStory);
            System.out.println("Story deleted successfully!");
        } else {
            System.out.println("Story not found.");
        }
    }


    private static void getStoryByCateg() {
        System.out.print("Enter category to get stories: ");
        String categoryToFind = scanner.nextLine();

        boolean found = false;
        for (Story story : stories) {
            if (story.getCategory().equalsIgnoreCase(categoryToFind)) {
                displayStory(story);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stories found in the category: " + categoryToFind);
        }
    }

    private static void getStoryByTag() {
        System.out.print("Enter tag to get stories: ");
        String tagToFind = scanner.nextLine();

        boolean found = false;
        for (Story story : stories) {
            if (story.getTags().contains(tagToFind)) {
                displayStory(story);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stories found with the tag: " + tagToFind);
        }
    }

    private static void getStoryById() {
        System.out.print("Enter story ID to find: ");
        int idToFind = scanner.nextInt();
        scanner.nextLine();

        Story foundStory = findStoryById(idToFind);
        if (foundStory != null) {
            displayStory(foundStory);
        } else {
            System.out.println("Story not found.");
        }
    }

    private static Story findStoryById(int idToFind) {
        for (Story story : stories) {
            if (story.getId() == idToFind) {
                return story;
            }
        }
        return null;
    }
    private static void getStoryByDate() {
        System.out.print("Enter date to get stories (DD-MM-YYYY): ");
        String dateToFind = scanner.nextLine();

        boolean found = false;
        for (Story story : stories) {
            if (story.getDate().equals(dateToFind)) {
                displayStory(story);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stories found on the date: " + dateToFind);
        }
    }

    private static void getRevers() {
        Collections.reverse(stories);
        System.out.println("Stories order reversed.");
    }

    private static void displayStory(Story story) {
        System.out.println("ID: " + story.getId());
        System.out.println("Category: " + story.getCategory());
        System.out.println("Title: " + story.getTitle());
        System.out.println("Text: " + story.getText());
        System.out.println("Tags: " + story.getTags());
        System.out.println("Date: " + story.getDate());
}
}


