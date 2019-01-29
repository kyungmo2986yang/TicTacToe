package fr.ensma.ia.tictactoe.BoardAgent.BoardObservation;

public interface ICaseObservee {
    void caseInitiate(ICaseObserver obs);
    void caseNotifyNews();
    void caseNotifyViews();
}
