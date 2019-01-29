package fr.ensma.ia.tictactoe.GlobalAgent;

import fr.ensma.ia.tictactoe.Kernel.Kernel;

public class GameModel {
    private boolean accessBoard, accessButton;
    private Kernel kernel;

    public boolean isAccessBoard() {
        return accessBoard;
    }

    public void setAccessBoard(boolean access) {
        this.accessBoard = access;
    }

    public boolean isAccessButton() {
        return accessButton;
    }

    public void setAccessButton(boolean access) {
        this.accessButton = access;
    }

    public GameModel(){
        accessBoard = true;
        accessButton = false;
    }

    public Kernel getKernel(){
        return kernel;
    }
}