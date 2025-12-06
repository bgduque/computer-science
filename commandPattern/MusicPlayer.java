package commandPattern;

record MusicPlayer(String name, String[] playlist, int[] volume) implements Device {
    MusicPlayer(String name) {
        this(name, new String[] { "None" }, new int[] { 50 });
    }

    public String status() {
        return "%s: Vol=%d, Playing=%s".formatted(name, volume[0], playlist[0]);
    }

    record Control(MusicPlayer p, Action action, Object[] prev) implements Command {
        enum Action {
            PLAY, STOP, VOL_UP, VOL_DOWN
        }

        Control(MusicPlayer p, Action action) {
            this(p, action, new Object[] { p.playlist[0], p.volume[0] });
        }

        public void execute() {
            prev[0] = p.playlist[0];
            prev[1] = p.volume[0];
            switch (action) {
                case PLAY -> p.playlist[0] = "Favorites";
                case STOP -> p.playlist[0] = "None";
                case VOL_UP -> p.volume[0] = Math.min(100, p.volume[0] + 10);
                case VOL_DOWN -> p.volume[0] = Math.max(0, p.volume[0] - 10);
            }
        }

        public void undo() {
            p.playlist[0] = (String) prev[0];
            p.volume[0] = (int) prev[1];
        }
    }
}
