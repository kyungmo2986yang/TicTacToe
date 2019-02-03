package fr.ensma.ia.tictactoe.GlobalAgent.Automate;

public interface IGameState {
    void toTheEnd() throws GameException;
    void intoProcess() throws GameException;
}
