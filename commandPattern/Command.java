package commandPattern;

sealed interface Command permits Light.Toggle, Light.SetBrightness, Thermostat.SetTemp, MusicPlayer.Control {
    void execute();

    void undo();
}
