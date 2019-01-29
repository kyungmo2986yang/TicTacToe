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
        setImageResource(R.drawable.empty_case);
        setOnClickListener(this);
    }

    public CaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setImageResource(R.drawable.empty_case);
        setOnClickListener(this);
    }

    public CaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        setImageResource(R.drawable.empty_case);
        setOnClickListener(this);
    }

    public void init(Context ctx){
    }

    public CasePresentation getPres(){
        return pres;
    }

    public void setPres(CasePresentation pres) {
        this.pres = pres;
    }

    @Override
    public void onClick(View v) {
        setImageResource(R.drawable.cross_case);
        pres.actionClick();
    }

    @Override
    public void notifyAccess(boolean b) {
        if (b) {
            setOnClickListener(this);
        }
        else {
            setOnClickListener(null);
        }
        setEnabled(b);
    }
}
