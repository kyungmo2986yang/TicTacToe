package fr.ensma.ia.tictactoe.GlobalAgent.Automate;

public interface IGameState {
    void toBegin() throws GameException;
    void toTheEnd() throws GameException;
    void intoProcess() throws GameException;
}
