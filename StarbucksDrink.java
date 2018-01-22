package starbucksrobot;

public class StarbucksDrink {
    private final String name;
    private final Ingredient[] ingredients;
    int[] quantities;
    
    public StarbucksDrink(String n, Ingredient[] ings, int[] q) {
        name = n;
        ingredients = ings;
        quantities = q;
    }
    
    public String getName() {
        return name;
    }
    
    public Ingredient[] getIngredients() {
        return ingredients;
    }
    
    public int getQuantity(int index) {
        return quantities[index];
    }
    
    public void display() {
        System.out.printf(name + "," + "%.2f", this.drinkCost());
    }
    
    public double drinkCost() {
        double cost = 0.0;
        
        for (int i = 0; i < ingredients.length; i++) {
            cost += ingredients[i].getCost() * quantities[i];
        }
        
        return cost;
    }
}
