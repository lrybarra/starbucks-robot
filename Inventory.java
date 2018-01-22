package starbucksrobot;

import java.util.Arrays;
import java.util.*;


public class Inventory {
    
    private final int[] quantities;
    private final ArrayList<Ingredient> ingredients;
    
    public Inventory(ArrayList<Ingredient> ings) {
        ingredients = ings;
        sort();
        quantities = new int[ingredients.size()];
        restock();
    }
    
    public void restock() {
        Arrays.fill(quantities, 10);
    }
    
    public void display() {
                
        System.out.println("Inventory:");

        for(int i = 0; i < ingredients.size(); i++) {
            ingredients.get(i).displayName();
            System.out.print("," + quantities[i] + "\n");
        }
    }
    
    public Ingredient getIngredient(String str) { 
        for (int j = 0; j < ingredients.size(); j++) {
            if (ingredients.get(j).ingredientName().equals(str)) {
                return ingredients.get(j);
            }
        }
        return null;
    }
    
    public void useIngredient(String str, int q) {
        for (int j = 0; j < ingredients.size(); j++) {
            if (ingredients.get(j).ingredientName().equals(str)) {
                quantities[j] -= q; 
            }
        }
    }
    
    public int getQuantityInStock(String ingredientName) {
        int index = -1;
        
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).ingredientName().equals(ingredientName)) {
                index = i;
            }
        }
        return quantities[index];
    }
    
    private void sort() {
                        
        Ingredient temp;
        boolean swap;
        
        do {
            swap = false;
            for (int i = 0; i < ingredients.size() - 1; i++) {
                if (ingredients.get(i+1).ingredientName().compareTo(ingredients.get(i).ingredientName()) < 0){
                    temp = ingredients.get(i+1);
                    ingredients.set(i+1, ingredients.get(i));
                    ingredients.set(i, temp);
                    swap = true;
                }
            }
        } while(swap);
    }
}
