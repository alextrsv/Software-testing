package code.funcs;

public abstract class Function implements Functional {
   protected double accuracy;

    public double getAccuracy() {
        return this.accuracy;
    }


    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

}
