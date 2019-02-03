package fr.ensma.ia.tictactoe.MenuButton.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.MenuButton.MenuButtonModel;
import fr.ensma.ia.tictactoe.MenuButton.MenuButtonPresentation;

public class MenuButtonUnclickable extends AbstractMenuButtonState{

    private Logger LOGGER = Logger.getLogger(MenuButtonClickable.class.getName());

    public MenuButtonUnclickable(MenuButtonPresentation pres, MenuButtonModel model) {
        super(pres, model);
    }

    @Override
    public void toTheEnd() {
        pres.setCurrentState(pres.getClickableState());
        model.setAccessible(true);
        LOGGER.info("Passed on to ClickableState");
    }
}
