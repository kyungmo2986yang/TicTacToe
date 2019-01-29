package fr.ensma.ia.tictactoe.CaseAgent;

import fr.ensma.ia.tictactoe.CaseAgent.Automate.CaseException;
import fr.ensma.ia.tictactoe.CaseAgent.Automate.CaseStateUnClicked;
import fr.ensma.ia.tictactoe.CaseAgent.Automate.CaseStateUnclickable;
import fr.ensma.ia.tictactoe.CaseAgent.Automate.ICaseState;

public class CasePresentation {
    private ICaseView view;
    private CaseModel model;
    private ICaseState currentState;
    private ICaseState unclickedState;
    private ICaseState unclickableState;

    public CasePresentation() {
        model = new CaseModel();
        unclickableState = new CaseStateUnclickable(this, model);
        unclickedState = new CaseStateUnClicked(this, model);
        currentState = unclickedState;
    }

    /**
     * action corresponding to when the case is touched
     */
    public void actionClick(){
        try {
            currentState.toClicked();
            view.notifyAccess(model.isAccessible());
        }
        catch (CaseException e){
        }
    }

    /**
     * action correponding to when the replay button is pressed
     */
    public void actionToReset(){
        try {
            currentState.toClickable();
            view.notifyAccess(model.isAccessible());
        }
        catch (CaseException e){
        }
    }

    public ICaseView getView() {
        return view;
    }

    public void setView(ICaseView view) {
        this.view = view;
    }

    public CaseModel getModel() {
        return model;
    }

    public void setModel(CaseModel model) {
        this.model = model;
    }

    public ICaseState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ICaseState currentState) {
        this.currentState = currentState;
    }

    public ICaseState getUnclickedState() {
        return unclickedState;
    }

    public void setUnclickedState(ICaseState unclickedState) {
        this.unclickedState = unclickedState;
    }

    public ICaseState getUnclickableState() {
        return unclickableState;
    }

    public void setUnclickableState(ICaseState unclickableState) {
        this.unclickableState = unclickableState;
    }
}
