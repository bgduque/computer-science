package commandPattern;

sealed interface Device permits Light, Thermostat, MusicPlayer {
    String status();
}
