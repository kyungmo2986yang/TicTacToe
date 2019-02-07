package fr.ensma.ia.tictactoe.MenuButton;

import fr.ensma.ia.tictactoe.R;

public class MenuButtonModel {

    private static int[] color = {R.color.buttonColor, R.color.buttonTxtColor1, R.color.buttonTxtColor2, R.color.colorPrimaryDark};
    private boolean accessible;

    public MenuButtonModel(){
        accessible = false;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public static int[] getColor() {
        return color;
    }
}
