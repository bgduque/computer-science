package commandPattern;

public class SpeakerPowerOn implements Command {
    private Speaker speaker;

    public SpeakerPowerOn(Speaker speaker){
        this.speaker = speaker;
    }

    @Override public void execute() {
         speaker.switchOn();
    }
}
