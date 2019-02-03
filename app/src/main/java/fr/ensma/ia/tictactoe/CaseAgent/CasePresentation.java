package fr.ensma.ia.tictactoe.CaseAgent;

import fr.ensma.ia.tictactoe.BoardAgent.BoardObservation.ICaseObservee;
import fr.ensma.ia.tictactoe.BoardAgent.BoardObservation.ICaseObserver;
import fr.ensma.ia.tictactoe.CaseAgent.Automate.CaseException;
import fr.ensma.ia.tictactoe.CaseAgent.Automate.CaseStateUnClicked;
import fr.ensma.ia.tictactoe.CaseAgent.Automate.CaseStateUnclickable;
import fr.ensma.ia.tictactoe.CaseAgent.Automate.ICaseState;

public class CasePresentation implements ICaseObservee {
    private ICaseView view;
    private CaseModel model;
    private ICaseState currentState, unclickedState, unclickableState;

    private ICaseObserver iCaseObserver;

    public CasePresentation() {
        model = new CaseModel();
        unclickableState = new CaseStateUnclickable(this, model);
        unclickedState = new CaseStateUnClicked(this, model);
        currentState = unclickedState;
    }

    @Override
    public void caseInitiate(ICaseObserver obs) {
        iCaseObserver = obs;
    }

    public int fetchImage(){//1-2 //1-3 in CaseView
        return model.getCurrentId();
    }

    public void actionClick(){//1-5
        notifyCoords();//1-5
        actionDeactivate();
    }

    @Override
    public void notifyCoords() {//1-5 //suite in BoardPresentation
        iCaseObserver.updateCoords(model.getRow() - 1, model.getColumn() - 1);
    }

    public void actionDeactivate(){
        try {
            currentState.toUnclickable();
        }
        catch (CaseException e){
        } finally {
            view.notifyAccess(model.isAccessible());
        }
    }

    public void settleNextTurn(){
        model.changeId();
    }

    public void actionActivate(){
        try {
            currentState.toClickable();
        } catch (CaseException e) {
            e.printStackTrace();
        } finally{
            view.notifyAccess(model.isAccessible());
            model.setCurrentId(model.getIds()[1]);
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

    public void setCurrentState(ICaseState currentState) {
        this.currentState = currentState;
    }

    public ICaseState getCurrentState() {
        return currentState;
    }

    public ICaseState getUnclickedState() {
        return unclickedState;
    }

    public ICaseState getUnclickableState() {
        return unclickableState;
    }
}
