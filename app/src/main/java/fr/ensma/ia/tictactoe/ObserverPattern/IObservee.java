package fr.ensma.ia.tictactoe.ObserverPattern;

public interface IObservee {
    void initiate(IObserver observer);
    void notifyModifications();
    void notifyViews();
}
