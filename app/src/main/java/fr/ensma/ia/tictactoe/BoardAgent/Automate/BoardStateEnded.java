package fr.ensma.ia.tictactoe.BoardAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.BoardAgent.BoardModel;
import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;

public class BoardStateEnded extends AbstractBoardState {

    private Logger LOGGER = Logger.getLogger(BoardStateChangedTurns.class.getName());

    public BoardStateEnded(BoardPresentation pres, BoardModel modl){
        super(pres, modl);
    }

    @Override
    public void toStartAnew() throws BoardException{
        pres.setCurrentState(pres.getBoardStateStarted());
        model.setAccess(true);
    }
}
