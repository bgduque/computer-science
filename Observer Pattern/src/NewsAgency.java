import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class NewsAgency {

    private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        IO.println("Subscribed: " + subscriber.name());
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        IO.println("Unsubscribed: " + subscriber.name());
    }

    public void publishNews(String news) {
        IO.println("\nPublishing: \"%s\" to %d subscriber(s)".formatted(news, subscribers.size()));
        subscribers.forEach(subscriber -> subscriber.update(news));
    }
}
