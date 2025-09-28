package commandPattern;

public class ThermostatPowerOff implements Command {
    private Thermostat thermostat;

    public ThermostatPowerOff(Thermostat thermostat){
        this.thermostat = thermostat;
    }

    @Override
    public void execute() {
        thermostat.switchOff();
    }
}
