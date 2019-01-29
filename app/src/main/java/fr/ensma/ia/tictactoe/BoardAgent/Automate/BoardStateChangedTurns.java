package fr.ensma.ia.tictactoe.BoardAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.BoardAgent.BoardModel;
import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;

public class BoardStateChangedTurns extends AbstractBoardState {

    private Logger LOGGER = Logger.getLogger(BoardStateChangedTurns.class.getName());

    public BoardStateChangedTurns(BoardPresentation prs, BoardModel modl) {
        super(prs, modl);
    }

    @Override
    public void toStartAnew() throws BoardException{
        pres.setCurrentState(pres.getBoardStateStarted());
        model.setAccess(true);
        LOGGER.info("Passed on to StartedState");
    }

    @Override
    public void toTheEnd() throws BoardException{
        pres.setCurrentState(pres.getBoardStateEnded());
        model.setAccess(false);
        LOGGER.info("Passed on to StateEnded");
    }
}
