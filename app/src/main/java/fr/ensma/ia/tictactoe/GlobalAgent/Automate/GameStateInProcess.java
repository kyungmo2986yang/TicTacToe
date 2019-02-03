package fr.ensma.ia.tictactoe.GlobalAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.GlobalAgent.GameModel;
import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;

public class GameStateInProcess extends AbstractGameState{

    private Logger LOGGER = Logger.getLogger(GameStateEnded.class.getName());

    public GameStateInProcess(GamePresentation pres, GameModel model) {
        super(pres, model);
    }

    @Override
    public void toTheEnd() {
        pres.setCurrentState(pres.getGameStateEnded());
        model.setAccessible(false);
        LOGGER.info("Passed on to EndedState");
    }
}
