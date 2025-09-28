package commandPattern;

import java.util.Scanner;

public class ViewerApp {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int choice = 0;
        boolean cont = true;

        Light lights = new Light();
        Thermostat thermostat = new Thermostat();
        Speaker speaker = new Speaker();
        RemoteControl rc = new RemoteControl();

        while(cont){
            
            System.out.print("______________________________________\n");
            System.out.print("\nChoose which appliance to control\n1. Lights\n2. Thermostat\n3. Speaker\n4. Exit\nChoice: ");
            choice = input.nextInt();
            System.out.print("______________________________________\n");

            switch(choice){
                case 1: Command lightsPowerOff = new LightsPowerOff(lights);
                        Command lightsPowerOn = new LightsPowerOn(lights);
                    
                    if(lights.checkLightState())
                    {
                        System.out.print("\nLights are currently on!\nSwitch it on?\n1. Yes\n2. No\nChoice: ");
                    }
                    else
                    {
                        System.out.print("\nLights are currently off!\nSwitch it off?\n1. Yes\n2. No\nChoice: ");
                    }

                    Integer yesOrNo = input.nextInt();

                    if(lights.checkLightState())
                    {
                        rc.setCommand(lightsPowerOff);
                    } 
                    else
                    {   
                        rc.setCommand(lightsPowerOn);
                    } 

                    switch (yesOrNo) {
                        case 1:
                            rc.clickButton();
                            break;
                        case 2:
                            System.out.println("Lights stays on!\n");
                            break;
                        default: System.out.println("Enter Valid Choice!\n");
                    }

                    break;

                case 2: Command thermostatPowerOff = new ThermostatPowerOff(thermostat);
                        Command thermostatPowerOn = new ThermostatPowerOn(thermostat);
                        Command decreaseTemperature = new DecreaseTemperature(thermostat);
                        Command increaseTemperature = new IncreaseTemperature(thermostat);
                        
                        if(thermostat.checkThermostatState())
                        {
                            System.out.print("\nThermostat is currently on!\n\nWhat do you want to do?\n1. Power off \n2. Decrease Temperature\n3. Increase Temperature\n4. Exit\nChoice: ");
                        }
                        else
                        {
                            System.out.print("\nThermostat is currently off!\n\nWhat do you want to do?\n1. Power On \n2. Exit\nChoice: ");
                        }

                        int thermoChoice = input.nextInt();

                        if(thermostat.checkThermostatState())
                        {
                            switch(thermoChoice){
                                case 1: rc.setCommand(thermostatPowerOff);
                                    rc.clickButton();
                                    break;    
                                case 2: rc.setCommand(decreaseTemperature);    
                                    rc.clickButton();
                                    break;
                                case 3: rc.setCommand(increaseTemperature);
                                    rc.clickButton();
                                    break;
                                case 4: break;
                                default: System.out.println("Enter Valid Choice!\n");
                            }
                        }
                        else
                        {
                            switch(thermoChoice){
                                case 1: rc.setCommand(thermostatPowerOn);
                                    rc.clickButton();
                                break;

                                case 2: break;

                                default: System.out.println("Enter Valid Choice!\n");
                            }
                        }
                    break;
                
                case 3: Command speakerPowerOff = new SpeakerPowerOff(speaker);
                        Command speakerPowerOn = new SpeakerPowerOn(speaker);
                        Command increaseVolume = new IncreaseVolume(speaker);
                        Command decreaseVolume = new DecreaseVolume(speaker);

                        if(speaker.checkSpeakerState())
                        {
                            System.out.print("\nSpeaker is currently on!\n\nWhat do you want to do?\n1. Power off\n2. Increase Volume\n3. Decrease Volume\n4. Exit\nChoide: ");
                        }
                        else
                        {
                            System.out.print("\nSpeaker is currently off!\n\nPower on?\n1. Power on\n2. Exit\nCHoice: ");
                        }

                        int speakerChoice = input.nextInt();

                        if(speaker.checkSpeakerState())
                        {
                            switch(speakerChoice){
                                case 1: rc.setCommand(speakerPowerOff);
                                    rc.clickButton();
                                    break;

                                case 2: rc.setCommand(increaseVolume);
                                    rc.clickButton();
                                    break;

                                case 3: rc.setCommand(decreaseVolume);
                                    rc.clickButton();
                                    break;
                                
                                case 4: break;
                                default: System.out.println("Enter valid choice!");
                            }
                        }
                        else
                        {
                            switch (speakerChoice) {
                                case 1: rc.setCommand(speakerPowerOn);
                                    rc.clickButton();
                                    break;
                                
                                case 2: break;

                                default: System.out.println("Enter valid choice!");
                            }
                        }
                    break;

                case 4: System.out.println("\nExitting...");
                    System.out.print("______________________________________\n");
                    System.exit(0);

                default: 
                    System.out.println("Enter Valid Choice!\n"); 
            }
        }
    }
}
