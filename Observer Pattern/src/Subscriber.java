public record Subscriber(String name) implements Observer {

    @Override
    public void update(String news) {
        IO.println("[%s] Breaking News: %s".formatted(name, news));
    }
}
