package commandPattern;

import java.util.List;
import java.util.stream.Stream;

class SmartHome {
    void main() {
        var living = new Light("Living Room");
        var thermo = new Thermostat("Main Thermostat");
        var speaker = new MusicPlayer("Smart Speaker");
        var remote = new RemoteControl();

        var commands = List.of(
                new Light.Toggle(living),
                new Light.SetBrightness(living, 75),
                new Thermostat.SetTemp(thermo, 22.5),
                new MusicPlayer.Control(speaker, MusicPlayer.Control.Action.PLAY),
                new MusicPlayer.Control(speaker, MusicPlayer.Control.Action.VOL_UP));

        System.out.println("Executing commands:");
        for (var cmd : commands) {
            remote.submit(cmd);
            System.out.println("  " + remote.describe(cmd));
        }

        System.out.println("\nDevice Status:");
        Stream.of((Device) living, thermo, speaker)
                .map(d -> switch (d) {
                    case Light l -> l.status();
                    case Thermostat t -> t.status();
                    case MusicPlayer m -> m.status();
                })
                .forEach(s -> System.out.println("  " + s));

        System.out.println("\nUndo last 2 commands:");
        remote.undoLast();
        remote.undoLast();

        System.out.println("\nFinal Status:");
        Stream.of((Device) living, thermo, speaker)
                .map(Device::status)
                .forEach(s -> System.out.println("  " + s));
    }
}