package fr.ensma.ia.tictactoe.BoardAgent;

import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardException;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateChangedTurns;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateEnded;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateStarted;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.IBoardState;
import fr.ensma.ia.tictactoe.BoardAgent.BoardObservation.ICaseObserver;
import fr.ensma.ia.tictactoe.CaseAgent.CasePresentation;
import fr.ensma.ia.tictactoe.CaseAgent.CaseView;
import fr.ensma.ia.tictactoe.ObserverPattern.IObservee;
import fr.ensma.ia.tictactoe.ObserverPattern.IObserver;

public class BoardPresentation implements IObservee, ICaseObserver {
    private IBoardView view;
    private BoardModel model;

    private IBoardState currentState;
    private IBoardState boardStateStarted;
    private IBoardState boardStateChangedTurns;
    private IBoardState boardStateEnded;
    private CasePresentation[] presentations;
    private IObserver referee;

    public BoardPresentation() {
        model = new BoardModel();
        boardStateChangedTurns = new BoardStateChangedTurns(this, model);
        boardStateEnded = new BoardStateEnded(this, model);
        boardStateStarted = new BoardStateStarted(this, model);
        currentState = boardStateStarted;

        presentations = new CasePresentation[9];
        for (int i = 0; i < presentations.length; i++) {
            presentations[i] = new CasePresentation();
            presentations[i].getModel().setRow(3 - i/3);
            presentations[i].getModel().setColumn(i%3 + 1);
        }
    }

    public CasePresentation[] getPresentations() {
        return presentations;
    }

    public void actionPlaying(){
        try {
            currentState.toChangeTurns();
            view.notifyAccess(model.isAccess());
        } catch (BoardException e) {
            e.printStackTrace();
        }
    }

    public void actionStartAPlay(){
        try {
            currentState.toStartAnew();
            view.notifyAccess(model.isAccess());
        } catch (BoardException e) {
            e.printStackTrace();
        }
    }

    public void actionEndOfPlay(){
        try{
            currentState.toTheEnd();
            view.notifyAccess(model.isAccess());
        } catch (BoardException e) {
            e.printStackTrace();
        }
    }

    public IBoardView getView() {
        return view;
    }

    public void setView(IBoardView view) {
        this.view = view;
    }

    public BoardModel getModel() {
        return model;
    }

    public void setModel(BoardModel model) {
        this.model = model;
    }

    public IBoardState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IBoardState currentState) {
        this.currentState = currentState;
    }

    public IBoardState getBoardStateStarted() {
        return boardStateStarted;
    }

    public IBoardState getBoardStateChangedTurns() {
        return boardStateChangedTurns;
    }

    public IBoardState getBoardStateEnded() {
        return boardStateEnded;
    }

    @Override
    public void initiate(IObserver observer) {
        referee = observer;
    }

    @Override
    public void notifyModifications() {
        referee.update();
    }

    @Override
    public void notifyViews() {
        referee.updateViews();
    }

    public IObserver getReferee(){
        return referee;
    }

    @Override
    public void caseInitiate() {
        for (int i = 0; i < presentations.length; i++) {
            presentations[i].caseInitiate(this);
        }
    }

    @Override
    public void caseUpdate() {

    }

    @Override
    public void caseUpdateViews() {

    }

    @Override
    public void caseExecute() {

    }
}
