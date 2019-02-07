package fr.ensma.ia.tictactoe.ObserverPattern;

public interface IObserver {
    void initiate();
    void updateOnClickCoord(int x, int y);
    void updateReset();
    void updateKill();
    int notifyPlayer();

    void updateTimer(int value);
}
