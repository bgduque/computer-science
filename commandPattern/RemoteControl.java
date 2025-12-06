package commandPattern;

import java.util.ArrayDeque;
import java.util.Deque;

record RemoteControl(Deque<Command> history) {
    RemoteControl() {
        this(new ArrayDeque<>());
    }

    void submit(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    void undoLast() {
        if (!history.isEmpty())
            history.pop().undo();
    }

    String describe(Command cmd) {
        return switch (cmd) {
            case Light.Toggle(Light l, _) -> "Toggle " + l.name();
            case Light.SetBrightness(Light l, int lvl, _) -> "Set %s to %d%%".formatted(l.name(), lvl);
            case Thermostat.SetTemp(Thermostat t, double temp, _) -> "Set %s to %.1f C".formatted(t.name(), temp);
            case MusicPlayer.Control(MusicPlayer p, var action, _) -> action + " on " + p.name();
        };
    }
}
