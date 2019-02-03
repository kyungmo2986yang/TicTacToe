package fr.ensma.ia.tictactoe.CaseAgent;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;

import fr.ensma.ia.tictactoe.R;

public class CaseView extends AppCompatImageButton implements ICaseView, View.OnClickListener{

    private CasePresentation pres;

    public CaseView(Context context) {
        super(context);
        init(context);
    }

    public CaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context ctx){
        setImageResource(R.drawable.empty_case);
        setOnClickListener(this);
    }

    public void setPres(CasePresentation prs) {
        this.pres = prs;
        pres.setView(this);
    }

    @Override
    public void notifyAccess(boolean b) {
        if (b) {
            setImageResource(pres.getModel().getIds()[0]);
            setOnClickListener(this);
        }
        else {
            setOnClickListener(null);
        }
        setEnabled(b);
    }

    /**
     * 1.ask pres who's turn is to play OK
     * 2.pres asks to model OK
     * 3.load image consequently on the imagebutton OK
     * 4.tell pres the image is clicked OK
     * 5.pres sends coords from model to PRES OK
     * 6.PRES sends it to kernel OK
     * 7.kernel saves coords into the grid
     * 8.kernel checks if player won
     * 9.if NO : kernel checks if board is full
     * 10.if NO NO : PRES changes turns OK
     * 11.if NO YES : game ends and button activates and board deactivates
     * 12.if YES : game ends and button activates and board deactivates
     * 13.change colors sur button
     * 14.change colors on textview
     * 15.change contents of textview
     */
    @Override
    public void onClick(View v) {
        System.out.println(pres.getModel().getRow() + "//" + pres.getModel().getColumn());
        setImageResource(pres.fetchImage());
        pres.actionClick();//1-4 //1-5 in CasePresentation
    }
}
