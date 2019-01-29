package fr.ensma.ia.tictactoe.GlobalAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.GlobalAgent.GameModel;
import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;

public class GameStateBegan extends AbstractGameState {

    private Logger LOGGER = Logger.getLogger(GameStateBegan.class.getName());

    public GameStateBegan(GamePresentation pres, GameModel model) {
        super(pres, model);
    }

    @Override
    public void intoProcess() throws GameException{
        LOGGER.info("Passed into ProcessState");
    }
}
