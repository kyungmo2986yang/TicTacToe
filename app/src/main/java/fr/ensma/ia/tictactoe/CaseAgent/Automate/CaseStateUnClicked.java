package fr.ensma.ia.tictactoe.CaseAgent.Automate;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.CaseAgent.CaseModel;
import fr.ensma.ia.tictactoe.CaseAgent.CasePresentation;

public class CaseStateUnClicked extends AbstractCaseState {

    private Logger LOGGER = Logger.getLogger(CaseStateUnclickable.class.getName());

    public CaseStateUnClicked(CasePresentation prs, CaseModel modl) {
        super(prs, modl);
    }

    @Override
    public void toClicked() throws CaseException {
        pres.setCurrentState(pres.getUnclickableState());
        model.setAccessible(false);
        LOGGER.info("Passed on to UnclickableState");
    }
}
