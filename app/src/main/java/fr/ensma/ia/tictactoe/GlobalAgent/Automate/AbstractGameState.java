package fr.ensma.ia.tictactoe.GlobalAgent.Automate;

import fr.ensma.ia.tictactoe.GlobalAgent.GameModel;
import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;

public abstract class AbstractGameState implements IGameState{
    protected GamePresentation pres;
    protected GameModel model;

    public AbstractGameState(GamePresentation pres, GameModel model) {
        this.pres = pres;
        this.model = model;
    }

    @Override
    public void toTheEnd() throws GameException{
        throw new GameException();
    }

    @Override
    public void intoProcess() throws GameException{
        throw new GameException();
    }
}
