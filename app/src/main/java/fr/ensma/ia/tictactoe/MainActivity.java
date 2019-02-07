package fr.ensma.ia.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;
import fr.ensma.ia.tictactoe.GlobalAgent.GameView;

public class MainActivity extends AppCompatActivity {

    private GamePresentation presentation;
    private GameView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentation = WholeActivity.getPresentation();
        view = findViewById(R.id.game);
        view.setPres(presentation);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            presentation.updateKill();
        }
        return super.onKeyDown(keyCode, event);
    }
}
