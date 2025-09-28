package commandPattern;

public class DecreaseTemperature implements Command{
    private Thermostat thermostat;

    public DecreaseTemperature(Thermostat thermostat){
        this.thermostat = thermostat;
    }

    @Override
    public void execute() {
        thermostat.decreaseTemperature();
    }
}
