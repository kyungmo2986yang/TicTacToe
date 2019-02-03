package fr.ensma.ia.tictactoe.BoardAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.BoardAgent.BoardModel;
import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;

public class BoardStateInPlay extends AbstractBoardState {

    private Logger LOGGER = Logger.getLogger(BoardStateInPlay.class.getName());

    public BoardStateInPlay(BoardPresentation prs, BoardModel modl) {
        super(prs, modl);
    }

    @Override
    public void toTheEnd() throws BoardException{
        pres.setCurrentState(pres.getAllDisabledState());
        model.setAccess(false);
    }
}
