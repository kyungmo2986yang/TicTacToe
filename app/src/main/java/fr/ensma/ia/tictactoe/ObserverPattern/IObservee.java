package fr.ensma.ia.tictactoe.ObserverPattern;

public interface IObservee {
    void initiate(IObserver observer);
    int fetchCurrentPlayer();
    void notifyOnclickCoord(int x, int y);
}
