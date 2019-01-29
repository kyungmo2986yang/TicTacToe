package fr.ensma.ia.tictactoe.BoardAgent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import fr.ensma.ia.tictactoe.CaseAgent.CasePresentation;
import fr.ensma.ia.tictactoe.CaseAgent.CaseView;
import fr.ensma.ia.tictactoe.R;

public class BoardView extends GridLayout implements IBoardView {
    private BoardPresentation pres;
    private CaseView[] caseViews = new CaseView[9];

    public BoardPresentation getPres() {
        return pres;
    }

    public void setPres(BoardPresentation pres) {
        this.pres = pres;
        setPreses(pres.getPresentations());

    }

    public void setPreses(CasePresentation[] preses){
        for (int i = 0; i < caseViews.length; i++) {
            caseViews[i].setPres(preses[i]);
            pres.getPresentations()[i].setView(caseViews[i]);
        }
    }

    public CaseView[] getCaseViews() {
        return caseViews;
    }

    public void setCaseViews(CaseView[] caseViews) {
        this.caseViews = caseViews;
    }

    public BoardView(Context context) {
        super(context);
        init(context);

    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context ctx) {
        View v = inflate(ctx, R.layout.board_view, this);
        for(int i = 0; i < caseViews.length; i++) {
            String iD = "butt" + (i+1);
            int resID = getResources().getIdentifier(iD, "id", getContext().getPackageName());
            caseViews[i] = ((CaseView) findViewById(resID));

        }
    }

    @Override
    public void notifyAccess(boolean b){
        for(int i = 0; i < caseViews.length; i++) {
            caseViews[i].notifyAccess(b);
        }
    }
}
