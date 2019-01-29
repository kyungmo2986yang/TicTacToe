package fr.ensma.ia.tictactoe.BoardAgent;

import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardException;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateChangedTurns;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateEnded;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateStarted;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.IBoardState;
import fr.ensma.ia.tictactoe.CaseAgent.CasePresentation;
import fr.ensma.ia.tictactoe.CaseAgent.CaseView;

public class BoardPresentation {
    private IBoardView view;
    private BoardModel model;

    private IBoardState currentState;
    private IBoardState boardStateStarted;
    private IBoardState boardStateChangedTurns;
    private IBoardState boardStateEnded;
    private CasePresentation[] presentations;

    public BoardPresentation() {
        model = new BoardModel();
        boardStateChangedTurns = new BoardStateChangedTurns(this, model);
        boardStateEnded = new BoardStateEnded(this, model);
        boardStateStarted = new BoardStateStarted(this, model);
        currentState = boardStateStarted;

        presentations = new CasePresentation[9];
        for (int i = 0; i < presentations.length; i++) {
            presentations[i] = new CasePresentation();
        }
    }

    public CasePresentation[] getPresentations() {
        return presentations;
    }

    public void setPresentations(CasePresentation[] presentations) {
        this.presentations = presentations;
    }

    public void setViews(CaseView[] views){
        for (int i = 0; i < presentations.length; i++) {
            presentations[i].setView(views[i]);
        }
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

    public void setBoardStateStarted(IBoardState boardStateStarted) {
        this.boardStateStarted = boardStateStarted;
    }

    public IBoardState getBoardStateChangedTurns() {
        return boardStateChangedTurns;
    }

    public void setBoardStateChangedTurns(IBoardState boardStateChangedTurns) {
        this.boardStateChangedTurns = boardStateChangedTurns;
    }

    public IBoardState getBoardStateEnded() {
        return boardStateEnded;
    }

    public void setBoardStateEnded(IBoardState boardStateEnded) {
        this.boardStateEnded = boardStateEnded;
    }
}
