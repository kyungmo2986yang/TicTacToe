package fr.ensma.ia.tictactoe.MenuButton;

import fr.ensma.ia.tictactoe.MenuButton.Automate.IMenuButtonState;
import fr.ensma.ia.tictactoe.MenuButton.Automate.MenuButtonClickable;
import fr.ensma.ia.tictactoe.MenuButton.Automate.MenuButtonException;
import fr.ensma.ia.tictactoe.MenuButton.Automate.MenuButtonUnclickable;
import fr.ensma.ia.tictactoe.ObserverPattern.IObservee;
import fr.ensma.ia.tictactoe.ObserverPattern.IObserver;

public class MenuButtonPresentation implements IObservee {
    private IMenuButtonView view;
    private MenuButtonModel model;
    private IMenuButtonState currentState, unclickableState, clickableState;
    private IObserver iObserver;

    public MenuButtonPresentation(){
        model = new MenuButtonModel();
        unclickableState = new MenuButtonUnclickable(this, model);
        clickableState = new MenuButtonClickable(this, model);
        currentState = unclickableState;
    }

    public IMenuButtonView getView() {
        return view;
    }

    public MenuButtonModel getModel() {
        return model;
    }

    public void setModel(MenuButtonModel model) {
        this.model = model;
    }

    public void setCurrentState(IMenuButtonState currentState) {
        this.currentState = currentState;
    }

    public IMenuButtonState getUnclickableState() {
        return unclickableState;
    }

    public IMenuButtonState getClickableState() {
        return clickableState;
    }

    public void setView(IMenuButtonView view) {
        this.view = view;
    }

    public void actionClick(){
        iObserver.updateReset();
    }

    public void actionActivate(int reason){
        try{
            currentState.toTheEnd();
        } catch (MenuButtonException e){
            e.printStackTrace();
        } finally {
            view.notifyTheEnd(model.isAccessible(), reason);
        }
    }

    public void actionDeactivate(){
        try{
            currentState.toTheBeginning();
            view.notifyTheEnd(model.isAccessible(), 0);
        } catch (MenuButtonException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initiate(IObserver observer) {
        iObserver = observer;
    }

    @Override
    public int fetchCurrentPlayer() {
        return iObserver.notifyPlayer();
    }

    @Override
    public void notifyOnclickCoord(int x, int y) {

    }
}
