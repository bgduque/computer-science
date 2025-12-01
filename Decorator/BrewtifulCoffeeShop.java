import java.util.ArrayList;
import java.util.List;

public class BrewtifulCoffeeShop {
    public static void main(String[] args) {
        List<Coffee> orders = new ArrayList<>();

        orders.add(new BlackCoffee());

        Coffee order2 = new Espresso();
        order2 = new Milk(order2);
        order2 = new CaramelSyrup(order2);
        orders.add(order2);

        Coffee order3 = new BlackCoffee();
        order3 = new Milk(order3);
        order3 = new Sugar(order3);
        order3 = new WhippedCream(order3);
        orders.add(order3);

        Coffee order4 = new Espresso();
        order4 = new Sugar(order4);
        order4 = new Sugar(order4); // Double sugar!
        order4 = new WhippedCream(order4);
        orders.add(order4);

        printReceipt(orders);
    }

    private static void printReceipt(List<Coffee> orders) {
        
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║       BREWTIFUL COFFEE SHOP             ║");
        System.out.println("║   \"Where Every Cup Tells a Story\"       ║");
        System.out.println("╚═════════════════════════════════════════╝");
        
        double grandTotal = 0;
        int orderNumber = 1;

        for (Coffee order : orders) {
            System.out.printf("\nORDER #%d%n", orderNumber++);
            System.out.println("─────────────────────────────────────────");

            String description = order.getDescription();
            String[] ingredients = description.split(", ");
            
            if (ingredients.length == 1) {
                System.out.println(ingredients[0]);
            } else {
                System.out.println(ingredients[0]);
                for (int i = 1; i < ingredients.length; i++) {
                    System.out.println("     + " + ingredients[i]);
                }
            }
            
            double cost = order.getCost();
            System.out.printf("%n  Subtotal: ................ Php%6.2f%n", cost);
            System.out.println();
            grandTotal += cost;
        }

        System.out.println("═══════════════════════════════════════════");
        System.out.printf("  TOTAL ORDERS: %d%n", orders.size());
        System.out.printf("  GRAND TOTAL: .............. Php %6.2f%n", grandTotal);
        System.out.println("═══════════════════════════════════════════");
    }
}
