package thirdTask;

public abstract class Being {
    protected double xCoord;
    protected double yCoord;
    protected double zCoord;


    protected void changePosition(double x, double y, double z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    protected double getxCoord() {
        return xCoord;
    }

    protected void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    protected double getyCoord() {
        return yCoord;
    }

    protected void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    protected double getzCoord() {
        return zCoord;
    }

    protected void setzCoord(double zCoord) {
        this.zCoord = zCoord;
    }

    public String getCoordsAsString(){
        return String.valueOf(getxCoord()) + " " + String.valueOf(getyCoord()) + " "  + String.valueOf(getzCoord());
    }
}
