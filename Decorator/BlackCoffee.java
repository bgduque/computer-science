/**
 * Concrete Component
 * The original, basic object that will be decorated.
 */
public class BlackCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Black Coffee";
    }

    @Override
    public double getCost() {
        return 100.00; // ₱ 100.00
    }
}
