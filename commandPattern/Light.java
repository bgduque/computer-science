package commandPattern;

record Light(String name, int[] brightness) implements Device {
    Light(String name) {
        this(name, new int[] { 0 });
    }

    public String status() {
        return "%s: %d%%".formatted(name, brightness[0]);
    }

    record Toggle(Light light, boolean[] wasOn) implements Command {
        Toggle(Light light) {
            this(light, new boolean[] { false });
        }

        public void execute() {
            wasOn[0] = light.brightness[0] > 0;
            light.brightness[0] = wasOn[0] ? 0 : 100;
        }

        public void undo() {
            light.brightness[0] = wasOn[0] ? light.brightness[0] : 0;
        }
    }

    record SetBrightness(Light light, int level, int[] prev) implements Command {
        SetBrightness(Light light, int level) {
            this(light, level, new int[] { light.brightness[0] });
        }

        public void execute() {
            prev[0] = light.brightness[0];
            light.brightness[0] = level;
        }

        public void undo() {
            light.brightness[0] = prev[0];
        }
    }
}
