package commandPattern;

public class SpeakerPowerOff implements Command {
    private Speaker speaker;

    public SpeakerPowerOff(Speaker speaker){
        this.speaker = speaker;
    }

    @Override public void execute() {
         speaker.switchOff();
    }
}
