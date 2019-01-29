package fr.ensma.ia.tictactoe.GlobalAgent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import fr.ensma.ia.tictactoe.R;

public class GameView extends LinearLayout implements IGameView {

    GamePresentation pres;

    public GameView(Context context) {
        super(context);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GamePresentation getPres() {
        return pres;
    }

    public void setPres(GamePresentation pres) {
        this.pres = pres;
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context ctx) {
        View v = inflate(ctx, R.layout.global_layout, this);
    }

    @Override
    public void notifyAccess(boolean b, boolean c) {
        if (b){

        }
        if (c){

        }
    }
}
