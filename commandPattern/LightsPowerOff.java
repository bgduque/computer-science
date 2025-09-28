package commandPattern;

public class LightsPowerOff implements Command {
    private Light lights;

    public LightsPowerOff(Light lights){
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.switchOff();
    }
}
