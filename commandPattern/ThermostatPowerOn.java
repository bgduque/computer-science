package commandPattern;

public class ThermostatPowerOn implements Command {
    private Thermostat thermostat;

    public ThermostatPowerOn(Thermostat thermostat){
        this.thermostat = thermostat;
    }

    @Override
    public void execute() {
        thermostat.switchOn();
    }
}
