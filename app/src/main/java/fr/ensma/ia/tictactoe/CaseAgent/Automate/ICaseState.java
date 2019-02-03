package fr.ensma.ia.tictactoe.CaseAgent.Automate;

public interface ICaseState {
    void toUnclickable() throws CaseException;
    void toClickable() throws CaseException;
}
