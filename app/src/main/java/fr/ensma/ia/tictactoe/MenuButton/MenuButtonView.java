package fr.ensma.ia.tictactoe.MenuButton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class MenuButtonView extends android.support.v7.widget.AppCompatButton implements IMenuButtonView, View.OnClickListener {

    private MenuButtonPresentation pres;

    public MenuButtonPresentation getPres() {
        return pres;
    }

    public void setPres(MenuButtonPresentation pres) {
        this.pres = pres;
    }

    public MenuButtonView(Context context) {
        super(context);
        init(context);
        setText("Replay !");
        setOnClickListener(this);
    }

    public MenuButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setText("Replay !");
        setOnClickListener(this);
    }

    public MenuButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        setText("Replay !");
        setOnClickListener(this);
    }

    public void init(Context ctx){
    }

    @Override
    public void notifyAccess(boolean b) {
        if (b) {
            setOnClickListener(this);
        } else {
            setOnClickListener(null);
        }
        setEnabled(b);
    }

    @Override
    public void onClick(View v) {

    }
}
