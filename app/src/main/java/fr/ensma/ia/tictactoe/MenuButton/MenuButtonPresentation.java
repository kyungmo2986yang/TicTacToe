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
    private IMenuButtonState currentState;
    private IMenuButtonState unclickableState;
    private IMenuButtonState clickableState;
    private IObserver referee;

    public void actionClick(){
        try{
            currentState.toClicked();
            view.notifyAccess(model.isAccessible());
        } catch (MenuButtonException e){
            e.printStackTrace();
        }
    }

    public void actionReset(){
        try{
            currentState.toClickable();
            view.notifyAccess(model.isAccessible());
        } catch (MenuButtonException e){
            e.printStackTrace();
        }
    }

    public IMenuButtonView getView() {
        return view;
    }

    public void setView(IMenuButtonView view) {
        this.view = view;
    }

    public MenuButtonModel getModel() {
        return model;
    }

    public void setModel(MenuButtonModel model) {
        this.model = model;
    }

    public IMenuButtonState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMenuButtonState currentState) {
        this.currentState = currentState;
    }

    public IMenuButtonState getUnclickableState() {
        return unclickableState;
    }

    public void setUnclickableState(IMenuButtonState unclickableState) {
        this.unclickableState = unclickableState;
    }

    public IMenuButtonState getClickableState() {
        return clickableState;
    }

    public void setClickableState(IMenuButtonState clickableState) {
        this.clickableState = clickableState;
    }

    public MenuButtonPresentation(){
        model = new MenuButtonModel();
        unclickableState = new MenuButtonUnclickable(this, model);
        clickableState = new MenuButtonClickable(this, model);
        currentState = unclickableState;
    }

    @Override
    public void initiate(IObserver observer) {
        referee = observer;
    }

    @Override
    public void notifyModifications() {
        referee.update();
    }

    @Override
    public void notifyViews() {
        referee.updateViews();
    }

    public IObserver getReferee(){
        return referee;
    }
}
