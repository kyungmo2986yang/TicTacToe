package fr.ensma.ia.tictactoe.BoardAgent.BoardObservation;

public interface ICaseObserver {
    void caseInitiate();
    void caseUpdate();
    void caseUpdateViews();
    void caseExecute();
}
