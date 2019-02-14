package fr.ensma.ia.tictactoe.MenuButton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class MenuButtonView extends android.support.v7.widget.AppCompatButton implements IMenuButtonView, View.OnClickListener {

    private MenuButtonPresentation pres;

    public MenuButtonView(Context context) {
        super(context);
        init(context);
    }

    public MenuButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MenuButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context ctx){
        setText("Replay !");
        setOnClickListener(null);
        setBackgroundColor(getResources().getColor(MenuButtonModel.getColor()[0]));
    }

    public void setPres(MenuButtonPresentation pres) {
        this.pres = pres;
        pres.setView(this);
    }

    @Override
    public void notifyTheEnd(boolean b, int i) {
        if (b) {
            setOnClickListener(this);
            setBackgroundColor(getResources().getColor(MenuButtonModel.getColor()[i]));
        } else {
            setOnClickListener(null);
            setBackgroundColor(getResources().getColor(MenuButtonModel.getColor()[0]));
        }
    }

    @Override
    public void onClick(View v) {
        pres.actionClick();
    }
}
