package starbucksrobot;

import java.util.*;

public class Menu {
    
    private final ArrayList<StarbucksDrink> drinks;
    private final Inventory inventory;
    
    public Menu(ArrayList<StarbucksDrink> sd, Inventory inv) {
        drinks = sd;
        inventory = inv;
        sort();
    }
    
    public void restock() {
        inventory.restock();
    }
    
    public int beveragesCount() {
        return drinks.size();
    }
    
    public void display(){
        
        inventory.display();
        System.out.println("Menu:");
        
        for(int i = 0; i < drinks.size(); i++) {
            System.out.print((i+1) + ",");
            drinks.get(i).display();
            System.out.println("," + this.canMakeDrink(i));
        }
    }
    
    public void makeDrink(int index) {
        
        StarbucksDrink star = drinks.get(index);
        
        if (this.canMakeDrink(index) == false) {
            System.out.println("Out of stock: " + star.getName());
        } 
        else {
            Ingredient[] drinkIngredients = star.getIngredients();
            
            for (int i = 0; i < drinkIngredients.length; i++) {
                inventory.useIngredient(drinkIngredients[i].ingredientName(), star.getQuantity(i));
            }
            
            System.out.println("Dispensing: " + star.getName());
        }
    }
    
    private boolean canMakeDrink(int index) {
        StarbucksDrink star = drinks.get(index);
        
        Ingredient[] drinkIngredients = star.getIngredients();
        
        for (int i = 0; i < drinkIngredients.length; i++) {
            if (star.getQuantity(i) > inventory.getQuantityInStock(drinkIngredients[i].ingredientName())) {
                return false;
            }
        }
        
        return true;
    }
    
    private void sort() {
                        
        StarbucksDrink temp;
        boolean swap;
        
        do {
            swap = false;
            for (int i = 0; i < drinks.size() - 1; i++) {
                if (drinks.get(i+1).getName().compareTo(drinks.get(i).getName()) < 0){
                    temp = drinks.get(i+1);
                    drinks.set(i+1, drinks.get(i));
                    drinks.set(i, temp);
                    swap = true;
                }
            }
        } while(swap);
    }
    
}
