package fr.ensma.ia.tictactoe.GlobalAgent;

public class MDDAccel {
    private float xVal;
    private float yVal;
    private float zVal;

    public MDDAccel(){
        xVal=0f;
        yVal=0f;
        zVal=0f;
    }

    synchronized public float getXVal(){
        return xVal;
    }

    synchronized public float getYVal(){
        return yVal;
    }

    synchronized public float getZVal(){
        return zVal;
    }

    synchronized public void setValeurs(float x,float y,float z){
        xVal=x;
        yVal=y;
        zVal=z;
    }
}
