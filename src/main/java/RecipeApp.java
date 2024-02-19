// This program manages a recipe collection, allowing users to add, view, and search for recipes.

import java.util.ArrayList;
import java.util.Scanner;

// Recipe class represents a single recipe with a title, ingredients, and cooking instructions
class Recipe {
    private String title;
    private String ingredients;
    private String instructions;

    // Constructor to initialize the recipe with title, ingredients, and instructions
    public Recipe(String title, String ingredients, String instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Accessor methods to retrieve recipe details
    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
}

// RecipeManager class manages the collection of recipes
class RecipeManager {
    private ArrayList<Recipe> recipes;

    // Constructor to initialize the recipe collection
    public RecipeManager() {
        recipes = new ArrayList<>();
    }

    // Method to add a new recipe to the collection
    public void addRecipe(String title, String ingredients, String instructions) {
        Recipe newRecipe = new Recipe(title, ingredients, instructions);
        recipes.add(newRecipe);
        System.out.println("Recipe added successfully!");
    }

    // Method to display all recipes in the collection
    public void displayRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes found.");
        } else {
            System.out.println("All Recipes:");
            for (Recipe recipe : recipes) {
                System.out.println("Title: " + recipe.getTitle());
                System.out.println("Ingredients: " + recipe.getIngredients());
                System.out.println("Instructions: " + recipe.getInstructions());
                System.out.println();
            }
        }
    }

    // Method to search for recipes containing a specific keyword in the title
    public void searchRecipes(String keyword) {
        boolean found = false;
        System.out.println("Search Results:");
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                found = true;
                System.out.println("Title: " + recipe.getTitle());
                System.out.println("Ingredients: " + recipe.getIngredients());
                System.out.println("Instructions: " + recipe.getInstructions());
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("No recipes found matching the keyword.");
        }
    }
}

// Main class to interact with the user and manage the recipe application
public class RecipeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeManager recipeManager = new RecipeManager();

        // Menu options for the user
        String menu = "Recipe Management System\n" +
                "1. Add Recipe\n" +
                "2. View All Recipes\n" +
                "3. Search Recipes\n" +
                "4. Exit";

        int choice;
        do {
            System.out.println(menu);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter recipe title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter ingredients: ");
                    String ingredients = scanner.nextLine();
                    System.out.print("Enter cooking instructions: ");
                    String instructions = scanner.nextLine();
                    recipeManager.addRecipe(title, ingredients, instructions);
                    break;
                case 2:
                    recipeManager.displayRecipes();
                    break;
                case 3:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    recipeManager.searchRecipes(keyword);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
