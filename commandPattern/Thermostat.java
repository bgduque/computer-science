package commandPattern;

record Thermostat(String name, double[] temp) implements Device {
    Thermostat(String name) {
        this(name, new double[] { 20.0 });
    }

    public String status() {
        return "%s: %.1f C".formatted(name, temp[0]);
    }

    record SetTemp(Thermostat t, double target, double[] prev) implements Command {
        SetTemp(Thermostat t, double target) {
            this(t, target, new double[] { t.temp[0] });
        }

        public void execute() {
            prev[0] = t.temp[0];
            t.temp[0] = target;
        }

        public void undo() {
            t.temp[0] = prev[0];
        }
    }
}
