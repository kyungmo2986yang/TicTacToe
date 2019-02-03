package fr.ensma.ia.tictactoe.GlobalAgent;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import fr.ensma.ia.tictactoe.BoardAgent.BoardView;
import fr.ensma.ia.tictactoe.MenuButton.MenuButtonView;
import fr.ensma.ia.tictactoe.R;

import static android.content.Context.SENSOR_SERVICE;

public class GameView extends LinearLayout implements IGameView {

    private MenuButtonView menuButtonView;
    private BoardView boardView;
    private static ProgressBar progressBar;
    private MonTimer leThTimer;
    private TextView textView;
    private GamePresentation pres;

    private SensorManager sensM;
    private MDDAccel mddAccelVal;


    private class MonTimer extends AsyncTask<Integer,Integer,Void> {
        @Override
        protected Void doInBackground(Integer... integers) {
            int clock = 0;
            while (clock<5) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    clock++;
                    publishProgress(clock);
                    if (isCancelled()) {
                        return null;
                    }
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            pres.passTurn();
            leThTimer.cancel(true);
            progressBar.setProgress(0);
            leThTimer = new MonTimer();
            leThTimer.execute();
        }
    }

    private class MonAcqAccel extends AsyncTask<Void,Float,Void>{
        private float xVal;

        @Override
        protected Void doInBackground(Void... voids) {
            while(true) {
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                xVal = mddAccelVal.getXVal();
                publishProgress(xVal);
            }
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            if (xVal > 6) {
                if (!pres.emptyGrid()) {
                    pres.updateReset();
                }
            }
        }
    }

    public GameView(Context context) {
        super(context);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context ctx) {
        View v = inflate(ctx, R.layout.global_layout, this);
        menuButtonView = findViewById(R.id.menu);
        boardView = findViewById(R.id.board);
        progressBar = findViewById(R.id.la_bar);
        progressBar.setMax(5);
        textView = findViewById(R.id.description);
        leThTimer = new MonTimer();
        leThTimer.execute();
        sensM = (SensorManager) getContext().getSystemService(SENSOR_SERVICE);
        mddAccelVal = new MDDAccel();
        AcquAccel thAcell = new AcquAccel(sensM,mddAccelVal);
        thAcell.start();
        new MonAcqAccel().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void setPres(GamePresentation pres) {
        this.pres = pres;
        pres.setView(this);
        boardView.setPres(pres.getBoardPresentation());
        menuButtonView.setPres(pres.getButtonPresentation());
    }

    /**
     * the method sets the end if gameHasEnded, or prepares the views for the next turn
     * if gameHasEnded, reason is 0 : a draw, 1 : player 1 won, 2 : player 2 won.
     * since colors are the same, a unique table is enough with the same indexes,
     * so as to never encounter 0 when !gameHasEnded
     * @see GameModel
     * @param gameHasEnded
     * @param reason
     */
    @Override
    public void notifyTheEnd(boolean gameHasEnded, int reason) {
        leThTimer.cancel(true);
        progressBar.setProgress(0);
        if (gameHasEnded){
            textView.setText(GameModel.getEndingSentence()[reason]);
            textView.setTextColor(getResources().getColor(GameModel.getColor()[reason]));
        } else {
            textView.setText(GameModel.getPlaySentence()[reason - 1]);
            textView.setTextColor(getResources().getColor(GameModel.getColor()[reason]));
            leThTimer = new MonTimer();
            leThTimer.execute();
        }
    }


}
