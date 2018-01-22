package starbucksrobot;

public class Ingredient {
    
    private final String name;
    private final double unitCost; 
    
    public Ingredient(String n, double u) {
        name = n;
        unitCost = u;
    }
    
    public void displayName() {
        System.out.print(name);
    }
    
    public String ingredientName() {
        return name;
    }
    
    public double getCost() {
        return unitCost;
    }
}
