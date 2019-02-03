package fr.ensma.ia.tictactoe.BoardAgent.BoardObservation;

public interface ICaseObserver {
    void initiate();
    void updateCoords(int row, int column);
}
