package fr.ensma.ia.tictactoe.BoardAgent;

import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardException;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateEnded;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.BoardStateInPlay;
import fr.ensma.ia.tictactoe.BoardAgent.Automate.IBoardState;
import fr.ensma.ia.tictactoe.BoardAgent.BoardObservation.ICaseObserver;
import fr.ensma.ia.tictactoe.CaseAgent.CasePresentation;
import fr.ensma.ia.tictactoe.ObserverPattern.IObservee;
import fr.ensma.ia.tictactoe.ObserverPattern.IObserver;

public class BoardPresentation implements IObservee, ICaseObserver {
    private IBoardView view;
    private BoardModel model;

    private IBoardState currentState, allEnabledState, allDisabledState;
    private CasePresentation[] presentations;
    private IObserver iObserver;

    public BoardPresentation() {
        model = new BoardModel();
        allDisabledState = new BoardStateEnded(this, model);
        allEnabledState = new BoardStateInPlay(this, model);
        currentState = allEnabledState;

        presentations = new CasePresentation[9];
        for (int i = 0; i < presentations.length; i++) {
            presentations[i] = new CasePresentation();
            presentations[i].getModel().setRow(3 - i/3);
            presentations[i].getModel().setColumn(i%3 + 1);
        }
        initiate();

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

    public void setCurrentState(IBoardState currentState) {
        this.currentState = currentState;
    }

    public IBoardState getAllEnabledState() {
        return allEnabledState;
    }

    public IBoardState getAllDisabledState() {
        return allDisabledState;
    }

    public CasePresentation[] getPresentations() {
        return presentations;
    }

    @Override
    public void initiate() {
        for (CasePresentation presentation : presentations) {
            presentation.caseInitiate(this);
        }
    }

    @Override
    public void updateCoords(int x, int y) {
        notifyOnclickCoord(x, y);//1-5
    }

    @Override
    public void notifyOnclickCoord(int x, int y) {//1-5 //suite in GamePresentation
        iObserver.updateOnClickCoord(x, y);
    }

    @Override
    public void initiate(IObserver observer) {
        iObserver = observer;
    }

    @Override
    public int fetchCurrentPlayer(){
        return iObserver.notifyPlayer();
    }

    public void actionDeactivate(){
        try {
            currentState.toTheEnd();
        } catch (BoardException e) {
            e.printStackTrace();
        } finally {
            view.notifyTheEnd(!model.isAccess());
        }
    }

    public void setNextPlayer() {
        for (CasePresentation presentation : presentations) {
            presentation.settleNextTurn();
        }
    }

    public void actionActivate(){
        try {
            currentState.toStartAnew();
        } catch (BoardException e) {
            e.printStackTrace();
        } finally {
            view.notifyTheEnd(!model.isAccess());
        }
    }

    public void activateAll(boolean b) {
        if (b) {
            for (CasePresentation presentation : presentations) {
                presentation.actionActivate();
            }
        } else {
            for (CasePresentation presentation : presentations) {
                presentation.actionDeactivate();
            }
        }
    }
}
