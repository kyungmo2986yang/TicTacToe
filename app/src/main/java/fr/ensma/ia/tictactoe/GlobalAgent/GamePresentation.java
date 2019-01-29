package fr.ensma.ia.tictactoe.GlobalAgent;

import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.GameException;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.GameStateBegan;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.GameStateEnded;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.GameStateInProcess;
import fr.ensma.ia.tictactoe.GlobalAgent.Automate.IGameState;
import fr.ensma.ia.tictactoe.MenuButton.MenuButtonPresentation;
import fr.ensma.ia.tictactoe.ObserverPattern.IObserver;

public class GamePresentation implements IObserver {
    private IGameView view;
    private GameModel model;

    private MenuButtonPresentation menuPres;
    private BoardPresentation boardPres;

    public MenuButtonPresentation getMenuPres() {
        return menuPres;
    }

    public void setMenuPres(MenuButtonPresentation menuPres) {
        this.menuPres = menuPres;
    }

    public BoardPresentation getBoardPres() {
        return boardPres;
    }

    public void setBoardPres(BoardPresentation boardPres) {
        this.boardPres = boardPres;
    }

    private IGameState currentState;
    private IGameState gameStateBegan;
    private IGameState gameStateEnded;
    private IGameState gameStateInProcess;

    public GamePresentation() {
        model = new GameModel();
        menuPres = new MenuButtonPresentation();
        boardPres = new BoardPresentation();
        gameStateBegan = new GameStateBegan(this, model);
        gameStateEnded = new GameStateEnded(this, model);
        gameStateInProcess = new GameStateInProcess(this, model);
    }

    public void actionStartGame(){
        try{
            currentState.toBegin();
            view.notifyAccess(model.isAccessBoard(), model.isAccessButton());
        } catch (GameException e) {
            e.printStackTrace();
        }
    }

    public void actionEndGame(){
        try{
            currentState.toTheEnd();
            view.notifyAccess(model.isAccessBoard(), model.isAccessButton());
        } catch (GameException e) {
            e.printStackTrace();
        }
    }

    public void actionProcessing(){
        try{
            currentState.intoProcess();
            view.notifyAccess(model.isAccessBoard(), model.isAccessButton());
        } catch (GameException e) {
            e.printStackTrace();
        }
    }

    public IGameView getView() {
        return view;
    }

    public void setView(IGameView view) {
        this.view = view;
    }

    public GameModel getModel() {
        return model;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }

    public IGameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IGameState currentState) {
        this.currentState = currentState;
    }

    public IGameState getGameStateBegan() {
        return gameStateBegan;
    }

    public void setGameStateBegan(IGameState gameStateBegan) {
        this.gameStateBegan = gameStateBegan;
    }

    public IGameState getGameStateEnded() {
        return gameStateEnded;
    }

    public void setGameStateEnded(IGameState gameStateEnded) {
        this.gameStateEnded = gameStateEnded;
    }

    public IGameState getGameStateInProcess() {
        return gameStateInProcess;
    }

    public void setGameStateInProcess(IGameState gameStateInProcess) {
        this.gameStateInProcess = gameStateInProcess;
    }

    @Override
    public void update() {

    }
}
