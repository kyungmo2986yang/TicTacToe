package fr.ensma.ia.tictactoe.MenuButton.Automate;

import fr.ensma.ia.tictactoe.MenuButton.MenuButtonModel;
import fr.ensma.ia.tictactoe.MenuButton.MenuButtonPresentation;

public abstract class AbstractMenuButtonState implements IMenuButtonState {

    protected MenuButtonPresentation pres;
    protected MenuButtonModel model;

    public AbstractMenuButtonState(MenuButtonPresentation pres, MenuButtonModel model) {
        this.pres = pres;
        this.model = model;
    }

    @Override
    public void toTheEnd()  throws MenuButtonException {
        throw new MenuButtonException();
    }

    @Override
    public void toTheBeginning()  throws MenuButtonException {
        throw new MenuButtonException();
    }
}