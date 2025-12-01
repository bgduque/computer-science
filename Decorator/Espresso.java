/**
 * Concrete Component
 * Another basic coffee option - Espresso
 */
public class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 120.00; // ₱ 120.00
    }
}
