package fr.ensma.ia.tictactoe.BoardAgent.Automate;

import fr.ensma.ia.tictactoe.BoardAgent.BoardModel;
import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;

public abstract class AbstractBoardState implements IBoardState {
    BoardPresentation pres;
    BoardModel model;

    public AbstractBoardState(final BoardPresentation prs, final BoardModel modl){
        pres = prs; model = modl;
    }

    @Override
    public void toStartAnew() throws BoardException{
        throw new BoardException();
    }

    @Override
    public void toTheEnd() throws BoardException{
        throw new BoardException();
    }
}
