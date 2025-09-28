package commandPattern;

public class LightsPowerOn implements Command {
    private Light lights;

    public LightsPowerOn(Light lights){
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.switchOn();
    }

}
