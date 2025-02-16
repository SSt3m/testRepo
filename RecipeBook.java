/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minal
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class RecipeBook {
    private ArrayList<Recipe> recipeBook;

    public RecipeBook(String fileName) {
        recipeBook = new ArrayList<>();
        
        try(Scanner fileReader = new Scanner(Paths.get(fileName))){
            addRecipes(fileReader);
        } catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
    
    private void addRecipes(Scanner fileReader){
        ArrayList<String> recipeFile = new ArrayList<>();
        while(fileReader.hasNextLine()){
            recipeFile.add(fileReader.nextLine());
        }
        
        int line = 0;
        
        while(line < recipeFile.size()){
            String name = recipeFile.get(line);
            line++;
            
            int cookingTime = Integer.valueOf(recipeFile.get(line));
            line++;
            
            Recipe recipeToAdd = new Recipe(name, cookingTime);
            
            while(true){
                if(line >= recipeFile.size()){
                    break;
                } // this block ensures that after going over it breaks out of loop
                    //instead of indexOutOfBounds after going over size of list
                
                if(recipeFile.get(line).equals("")){
                    break;
                }
                
                String ingredient = recipeFile.get(line);
                
                recipeToAdd.addIngredient(ingredient);
                line++;
            }
            
            recipeBook.add(recipeToAdd);
            line++;
        }
    }
    
    public void printRecipeBook(){
        for(Recipe recipe : recipeBook){
            System.out.println(recipe);
        }
    }
    
    public void printMatchingName(String wordToFind){
        for(Recipe recipe : recipeBook){
            if(recipe.name().contains(wordToFind)){
                System.out.println(recipe);
            }
        }
    }
    
    public void printMatchingTime(int timeToMatch){
        for(Recipe recipe : recipeBook){
            if(timeToMatch >= recipe.cookingTime()){
                System.out.println(recipe);
            }
        }
    }
    
    public void printContainsIngredient(String ingredientToFind){
        for(Recipe recipe : recipeBook){
            if(recipe.containsIngredient(ingredientToFind)){
                System.out.println(recipe);
            }
        }
    }
    
    
}
