
public class Main {

    void main() {
        var agency = new NewsAgency();

        var alice = new Subscriber("Alice");
        var bob = new Subscriber("Bob");
        var charlie = new Subscriber("Charlie");

        agency.subscribe(alice);
        agency.subscribe(bob);
        agency.subscribe(charlie);

        agency.publishNews("Tech stocks surge 15% in early trading!");

        agency.unsubscribe(bob);

        agency.publishNews("Central Bank announces rate cut decision.");
    }
}