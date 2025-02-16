/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minal
 */
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private RecipeBook recipeBook;
    
    public UserInterface(Scanner scanner, RecipeBook recipeBook){
        this.scanner = scanner;
        this.recipeBook = recipeBook;
    }
    
    public void start(){
        printCommands();
        evaluateCommand();
    }
    
    private void evaluateCommand(){
        while(true){
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            
            if(command.equals("stop")){
                return;
            }

            if(command.equals("list")){
                recipeBook.printRecipeBook();
            }

            if(command.equals("find name")){
                System.out.println("Searched word: ");
                String searchedWord = scanner.nextLine();

                System.out.println("Recipes:");
                recipeBook.printMatchingName(searchedWord);
            }

            if(command.equals("find cooking time")){
                System.out.println("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());

                System.out.println("Recipes:");
                recipeBook.printMatchingTime(maxTime);
            }

            if(command.equals("find ingredient")){
                System.out.println("Ingredient: ");
                String ingredient = scanner.nextLine();

                System.out.println("Recipes:");
                recipeBook.printContainsIngredient(ingredient);
            }

            System.out.println("");
        }
    }
    
    private void printCommands(){
        System.out.println("Commands:");
        
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println("");
    }
}
