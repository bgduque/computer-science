package commandPattern;

public class IncreaseTemperature implements Command {
    private Thermostat thermostat;

    public IncreaseTemperature(Thermostat thermostat){
        this.thermostat = thermostat;
    }

    @Override
    public void execute() {
        thermostat.increaseTemperature();
    }
}
