package fr.ensma.ia.tictactoe.BoardAgent.Automate;

public interface IBoardState {

    void toChangeTurns() throws BoardException;
    void toStartAnew() throws BoardException;
    void toTheEnd() throws BoardException;
}
