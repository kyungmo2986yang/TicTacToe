package fr.ensma.ia.tictactoe.MenuButton.Automate;

public interface IMenuButtonState {
    void toTheEnd() throws MenuButtonException;
    void toTheBeginning() throws MenuButtonException;
}
