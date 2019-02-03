package fr.ensma.ia.tictactoe.CaseAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.CaseAgent.CaseModel;
import fr.ensma.ia.tictactoe.CaseAgent.CasePresentation;

public class CaseStateUnclickable extends AbstractCaseState {

    private Logger LOGGER = Logger.getLogger(CaseStateUnclickable.class.getName());

    public CaseStateUnclickable(CasePresentation prs, CaseModel modl) {
        super(prs, modl);
    }

    @Override
    public void toClickable() {
        pres.setCurrentState(pres.getUnclickedState());
        model.setAccessible(true);
        LOGGER.info("Passed on to UnclickedState");
    }
}
