package machine;

public class Coffee {
    // field needed for coffee
    private final String name;
    private final int waterNeeded;
    private final int milkNeeded;
    private final int coffeeNeeded;
    private final int price;

    // constructor
    public Coffee(String name, int waterNeeded, int milkNeeded, int coffeeNeeded, int price) {
        this.name = name;
        this.waterNeeded = waterNeeded;
        this.milkNeeded = milkNeeded;
        this.coffeeNeeded = coffeeNeeded;
        this.price = price;
    }

    // getters method
    public String getName() {
        return name;
    }

    public int getWaterNeeded(){
        return waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public int getCoffeeNeeded() {
        return coffeeNeeded;
    }

    public int getPrice() {
        return price;
    }
}
