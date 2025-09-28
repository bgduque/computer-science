package commandPattern;

public class DecreaseVolume implements Command {
    private Speaker speaker;

    public DecreaseVolume(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.decreaseVolume();
    }
}
