package fr.ensma.ia.tictactoe.GlobalAgent;

import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.GameException;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.GameStateEnded;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.GameStateInProcess;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.IGameState;
import fr.ensma.ia.tictactoe.MenuButton.MenuButtonPresentation;
import fr.ensma.ia.tictactoe.ObserverPattern.IObserver;

public class GamePresentation implements IObserver {
    private IGameView view;
    private GameModel model;

    private MenuButtonPresentation buttonPresentation;
    private BoardPresentation boardPresentation;

    private IGameState currentState, gameStateEnded, gameStateInProcess;

    public GamePresentation() {
        model = new GameModel();
        buttonPresentation = new MenuButtonPresentation();
        boardPresentation = new BoardPresentation();
        gameStateEnded = new GameStateEnded(this, model);
        gameStateInProcess = new GameStateInProcess(this, model);
        currentState = gameStateInProcess;
        initiate();
    }

    public IGameView getView() {
        return view;
    }

    public void setView(IGameView view) {
        this.view = view;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }

    public void setCurrentState(IGameState currentState) {
        this.currentState = currentState;
    }

    public IGameState getGameStateEnded() {
        return gameStateEnded;
    }

    public IGameState getGameStateInProcess() {
        return gameStateInProcess;
    }

    public void updateOnClickCoord(int x, int y){//1-5
        try {
            int endingQuestion = model.fillInGrid(x, y);//1-5 -> 1-8
            if (endingQuestion != model.getKernel().getNotEnded()){
                actionEnd(endingQuestion);//(!1-9 && 1-11)||1-12
            } else {
                actionChangeTurns();//1-9 && 1-10
            }
        } catch (PlayException e) {
            e.printStackTrace();
        }
    }

    private void actionEnd(int endingQuestion) {//(!1-9 && 1-11)||1-12
        try {
            currentState.toTheEnd();
        } catch (GameException e) {
            e.printStackTrace();
        } finally {
            view.notifyTheEnd(!model.isAccessible(), endingQuestion);
            System.out.println(!model.isAccessible());
            boardPresentation.actionDeactivate();
            buttonPresentation.actionActivate(endingQuestion);
            System.out.println(endingQuestion);
        }
    }

    public void passTurn(){
        model.passing();
        actionChangeTurns();
    }

    private void actionChangeTurns() {//1-9 && 1-10
        view.notifyTheEnd(!model.isAccessible(), getThePlayingGuy());
        boardPresentation.setNextPlayer();
    }

    private int getThePlayingGuy(){
        return model.requestPlayer();
    }

    @Override
    public void updateReset() {
        actionReset();
    }

    @Override
    public int notifyPlayer() {
        return getThePlayingGuy();
    }

    private void actionReset(){
        model.resetGame();
        try {
            currentState.intoProcess();
        } catch (GameException e) {
            e.printStackTrace();
        } finally {
            view.notifyTheEnd(!model.isAccessible(), 1);
            buttonPresentation.actionDeactivate();
            boardPresentation.actionActivate();
        }
    }

    @Override
    public void initiate() {
        boardPresentation.initiate(this);
        buttonPresentation.initiate(this);
    }

    public BoardPresentation getBoardPresentation() {
        return boardPresentation;
    }

    public MenuButtonPresentation getButtonPresentation() {
        return buttonPresentation;
    }

    public boolean emptyGrid() {
        return model.emptyGrid();
    }
}
