package fr.ensma.ia.tictactoe.CaseAgent.Automate;

import fr.ensma.ia.tictactoe.CaseAgent.CaseModel;
import fr.ensma.ia.tictactoe.CaseAgent.CasePresentation;

public abstract class AbstractCaseState implements ICaseState {
    protected CasePresentation pres;
    protected CaseModel model;

    public AbstractCaseState(final CasePresentation prs, final CaseModel modl){
        pres = prs; model = modl;
    }
    @Override
    public void toClicked() throws CaseException {
        throw new CaseException();
    }

    @Override
    public void toClickable() throws CaseException {
        throw new CaseException();
    }
}
