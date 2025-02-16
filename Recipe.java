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

public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;

    public Recipe(String name, int cookingTime) {
        this.name = name;
        this.cookingTime = cookingTime;
        ingredients = new ArrayList<>();
    }
    
    public void addIngredient(String ingredient){
        ingredients.add(ingredient);
    }
    
    public String name(){
        return name;
    }
    
    public int cookingTime(){
        return cookingTime;
    }
    
    public boolean containsIngredient(String ingredientToFind){
        for(String ingredient : ingredients){
            if(ingredient.equals(ingredientToFind)){
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString(){
        return name + ", cooking time: " + cookingTime + ".";
    }
}

// this comment is to test pull requests on github :D