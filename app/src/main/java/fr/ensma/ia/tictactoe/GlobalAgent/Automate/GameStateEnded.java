package fr.ensma.ia.tictactoe.GlobalAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.GlobalAgent.GameModel;
import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;

public class GameStateEnded extends AbstractGameState{

    private Logger LOGGER = Logger.getLogger(GameStateEnded.class.getName());

    public GameStateEnded(GamePresentation pres, GameModel model) {
        super(pres, model);
    }

    @Override
    public void intoProcess() throws GameException{
        pres.setCurrentState(pres.getGameStateInProcess());
        model.setAccessible(true);
        LOGGER.info("Passed on to InProcessState");
    }
}
