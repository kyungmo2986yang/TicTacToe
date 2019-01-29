package fr.ensma.ia.tictactoe.BoardAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.BoardAgent.BoardModel;
import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;

public class BoardStateStarted extends AbstractBoardState {

    private Logger LOGGER = Logger.getLogger(BoardStateStarted.class.getName());

    public BoardStateStarted(BoardPresentation prs, BoardModel modl) {
        super(prs, modl);
    }

    @Override
    public void toChangeTurns() throws BoardException{
        pres.setCurrentState(pres.getBoardStateChangedTurns());
        model.setAccess(true);
    }
}
