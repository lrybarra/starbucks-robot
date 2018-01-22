package starbucksrobot;
import java.util.*;
import java.util.Scanner;

public class StarbucksRobot {

    public static void main(String[] args) {
        
        Inventory roboBaristaInventory = initializeInventory();
        Menu roboBaristaMenu = intializeMenu(roboBaristaInventory);
        Scanner scanner = new Scanner( System.in );
        String userInput;
        int userChoice;  
        
        do {
            roboBaristaMenu.display();

            System.out.print(">: ");
            userInput = scanner.nextLine();
            
            try {
                userChoice = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                userChoice = -1;
            }

            if (userInput.toLowerCase().equals("r")) {
                roboBaristaMenu.restock();
            } 
            else if (userInput.toLowerCase().equals("q")) {
                
            }
            else if (userChoice <= roboBaristaMenu.beveragesCount() && 
                     userChoice > 0) {
                roboBaristaMenu.makeDrink(userChoice - 1);
            }
            else {
                System.out.println("Invalid selection: " + userInput);
            }
           
        } while(userInput.toLowerCase().equals("q") != true);
    }
    
    public static Inventory initializeInventory() {
        
        ArrayList<Ingredient> ingredients = new ArrayList();
        
        String[] ingredientNames = {"Coffee", "Decaf Coffee", "Sugar", "Cream",
                                    "Steamed Milk", "Foamed Milk", "Espresso",
                                    "Cocoa", "Whipped Cream"};
        
        double[] ingredientUnitCosts = {.75, .75, .25, .25, .35, .35, 1.1, .9, 1};
        
        if (ingredientNames.length == ingredientUnitCosts.length) {
            for (int i = 0; i < ingredientNames.length; i++) {
                ingredients.add(new Ingredient(ingredientNames[i], ingredientUnitCosts[i]));
            }
        } else {
            
        }
        
        Inventory inventory = new Inventory(ingredients);

//        Arrays.sort(inventory);
        return inventory;
    }
    
    public static Menu intializeMenu(Inventory inv) {
        ArrayList<StarbucksDrink> drinks = new ArrayList();
        
        // 3 units of coffee, 1 unit of sugar, 1 unit of cream
        drinks.add(new StarbucksDrink("Coffee", 
            new Ingredient[] {inv.getIngredient("Coffee"), inv.getIngredient("Sugar"), inv.getIngredient("Cream")},
            new int[] {3, 1, 1}));
        // 3 units of Decaf Coffee, 1 unit of sugar, 1 unit of cream
        drinks.add(new StarbucksDrink("Decaf Coffee",
            new Ingredient[] {inv.getIngredient("Decaf Coffee"), inv.getIngredient("Sugar"), inv.getIngredient("Cream")},
            new int[] {3, 1, 1}));
        // 2 units of espresso, 1 unit of steamed milk
        drinks.add(new StarbucksDrink("Caffe Latte",
            new Ingredient[] {inv.getIngredient("Espresso"), inv.getIngredient("Steamed Milk")},
            new int[] {2, 1}));
        // 3 units of espresso
        drinks.add(new StarbucksDrink("Caffe Americano",
            new Ingredient[] {inv.getIngredient("Espresso")},
            new int[] {3}));
        // 1 units of Espresso, 1 unit of cocoa, 1 unit of steamed milk, 1 unit of whipped cream
        drinks.add(new StarbucksDrink("Caffe Mocha",
            new Ingredient[] {inv.getIngredient("Espresso"), inv.getIngredient("Cocoa"),
                inv.getIngredient("Steamed Milk"), inv.getIngredient("Whipped Cream")},
            new int[] {1, 1, 1, 1}));
        //  2 units of Espresso, 1 unit of steamed milk, 1 unit of foamed milk
        drinks.add(new StarbucksDrink("Cappuccino",
            new Ingredient[] {inv.getIngredient("Espresso"), inv.getIngredient("Steamed Milk"),
                inv.getIngredient("Foamed Milk")},
            new int[] {2, 1, 1}));
        
        Menu menu = new Menu(drinks, inv);
        
        return menu;
    }
    
}
