package fr.ensma.ia.tictactoe.MenuButton.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.MenuButton.MenuButtonModel;
import fr.ensma.ia.tictactoe.MenuButton.MenuButtonPresentation;

public class MenuButtonClickable extends AbstractMenuButtonState {

    private Logger LOGGER = Logger.getLogger(MenuButtonClickable.class.getName());

    public MenuButtonClickable(MenuButtonPresentation pres, MenuButtonModel model) {
        super(pres, model);
    }

    @Override
    public void toTheBeginning() {
        pres.setCurrentState(pres.getUnclickableState());
        model.setAccessible(false);
        LOGGER.info("Passed on to UnclickableState");
    }
}
