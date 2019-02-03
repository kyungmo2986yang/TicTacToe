package fr.ensma.ia.tictactoe.BoardAgent.Automate;

public interface IBoardState {

    void toStartAnew() throws BoardException;
    void toTheEnd() throws BoardException;
}
