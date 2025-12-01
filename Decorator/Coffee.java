/**
 * Component Interface
 * Defines the common operations for both the basic item and the decorators.
 */
public interface Coffee {
    /**
     * Returns the description of the coffee with all its ingredients
     * @return String description of the coffee
     */
    String getDescription();
    
    /**
     * Returns the total cost of the coffee with all additions
     * @return double cost in Philippine Pesos
     */
    double getCost();
}
