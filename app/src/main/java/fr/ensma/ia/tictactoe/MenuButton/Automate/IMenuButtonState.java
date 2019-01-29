package fr.ensma.ia.tictactoe.MenuButton.Automate;

public interface IMenuButtonState {
    void toClickable() throws MenuButtonException;
    void toClicked() throws MenuButtonException;
}
