package fr.ensma.ia.tictactoe.CaseAgent;

public class CaseModel {
    private boolean accessible;

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public CaseModel(){
        accessible = true;
    }
}
