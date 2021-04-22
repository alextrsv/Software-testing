package thirdTask;

public class Whale extends Sentient {

    double xTop = 10;
    double xLow = -10;
    double yTop = 50;
    double yLow = -50;
    double zTop = 50;
    double zLow = -50;

    Whale(){
        this.xCoord = 0;
        this.yCoord = 0;
        this.zCoord = 0;
        this.determination = "whale";
        this.determinationTime = 500;
        this.setEmotionalState(EmotionalState.NORMAL);
    }


    @Override
    public void changePosition(double x, double y, double z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
        try {
            if (x > xTop || x < xLow || y > yTop || y < yLow || z > zTop || z < zLow) {
                determinationTime = 250;
                this.changeDetermination("not whale");
            }else {
                determinationTime = 500;
                this.changeDetermination("whale");
            }
            Thread.sleep(determinationTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void changeDetermination(String determination) {
        this.setDetermination(determination);
    }

    @Override
    public String whoAmI() {
        return this.toString();
    }


    @Override
    public String toString() {
        return "I am " + determination;
    }



}
