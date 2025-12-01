/**
 * Concrete Decorator - Caramel Syrup
 * Adds caramel syrup to the coffee order
 */
public class CaramelSyrup extends CoffeeDecorator {
    public CaramelSyrup(Coffee wrappedCoffee) {
        super(wrappedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Caramel Syrup";
    }

    @Override
    public double getCost() {
        return super.getCost() + 40.00; // ₱ 40.00
    }
}
