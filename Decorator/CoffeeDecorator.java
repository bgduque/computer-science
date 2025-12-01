/**
 * Decorator Abstraction
 * Ensures the decorator classes implement the Coffee interface and have a way 
 * to hold a reference to the Coffee object they are wrapping.
 */
public abstract class CoffeeDecorator implements Coffee {
    /**
     * The Coffee object being wrapped/decorated
     */
    protected final Coffee wrappedCoffee;

    /**
     * Constructor to wrap a Coffee object
     * @param wrappedCoffee the Coffee object to be decorated
     */
    protected CoffeeDecorator(Coffee wrappedCoffee) {
        this.wrappedCoffee = wrappedCoffee;
    }

    /**
     * Delegates the description call to the wrapped Coffee object
     */
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription();
    }

    /**
     * Delegates the cost call to the wrapped Coffee object
     */
    @Override
    public double getCost() {
        return wrappedCoffee.getCost();
    }
}
