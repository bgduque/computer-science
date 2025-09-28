package commandPattern;

public class Speaker {
    private Boolean isSpeakerSwitchedOn = false;
    private int volume = 50;

    public void switchOn(){
        System.out.println("Speaker is successfully switched on!\n");
        isSpeakerSwitchedOn = true;
    }

    public void switchOff(){
        System.out.println("Speaker is successfully switched off!\n");
        isSpeakerSwitchedOn = false;
    }

    public void increaseVolume(){
        volume++;
        System.out.println("Volume is now set at: " + volume);
    }

    public void decreaseVolume(){
        volume--;
        System.out.println("Volume is now set at: " + volume);
    }     

    public Boolean checkSpeakerState()
    {
        return isSpeakerSwitchedOn;
    }
}

