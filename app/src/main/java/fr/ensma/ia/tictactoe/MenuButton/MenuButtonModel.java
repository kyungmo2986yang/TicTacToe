package fr.ensma.ia.tictactoe.MenuButton;

public class MenuButtonModel {

    private boolean accessible;

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public MenuButtonModel(){
        accessible = true;
    }
}
