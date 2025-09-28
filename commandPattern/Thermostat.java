package commandPattern;

public class Thermostat {
    private Boolean isThermostatSwitchedOn = false;
    private int temperature = 22;

    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(){
        this.temperature = temperature;
    }
    
    public void switchOn() {
        System.out.println("Thermostat is successfully switched on!\n");
        isThermostatSwitchedOn = true;
    }

    public void switchOff(){
        System.out.println("Thermostat are successfully switched off!\n");
        isThermostatSwitchedOn = false;
    }

    public boolean checkThermostatState(){
        return isThermostatSwitchedOn;
    }

    public void increaseTemperature(){
        System.out.println("Increase Temperature?(y/n): ");
        temperature++;
        System.out.println("Temperature is now set at: " + temperature);
    }

    public void decreaseTemperature(){
        System.out.println("Increase Temperature?(y/n): ");
        temperature--;
        System.out.println("Temperature is now set at: " + temperature);
    }
}
