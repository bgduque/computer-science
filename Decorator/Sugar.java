/**
 * Concrete Decorator - Sugar
 * Adds sugar to the coffee order
 */
public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee wrappedCoffee) {
        super(wrappedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.00; // ₱ 10.00
    }
}
