package thirdTask;

public abstract class Sentient extends Being {
    EmotionalState emotionalState;
    protected String determination;

    int determinationTime;

    protected abstract String whoAmI();

    protected abstract void changeDetermination(String determination);

    public String getDetermination() {
        return determination;
    }

    protected void setDetermination(String determination) {
        this.determination = determination;
    }

    public EmotionalState getEmotionalState() {
        return emotionalState;
    }

    public void setEmotionalState(EmotionalState emotionalState) {
        this.emotionalState = emotionalState;
    }

    public int getDeterminationTime() {
        return determinationTime;
    }
}
