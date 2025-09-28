package commandPattern;

public class IncreaseVolume implements Command {
    private Speaker speaker;

    public IncreaseVolume(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.increaseVolume();
    }
}
