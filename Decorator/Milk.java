/**
 * Concrete Decorator - Milk
 * Adds milk to the coffee order
 */
public class Milk extends CoffeeDecorator {
    public Milk(Coffee wrappedCoffee) {
        super(wrappedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 25.00; // ₱ 25.00
    }
}
