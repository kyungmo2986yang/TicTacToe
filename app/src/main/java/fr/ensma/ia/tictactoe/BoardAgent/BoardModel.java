package fr.ensma.ia.tictactoe.BoardAgent;

public class BoardModel {
    private boolean access;

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public BoardModel(){
        access = true;
    }
}
