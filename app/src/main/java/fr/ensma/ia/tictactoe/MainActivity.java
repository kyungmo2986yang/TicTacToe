package fr.ensma.ia.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;
import fr.ensma.ia.tictactoe.GlobalAgent.GameView;

public class MainActivity extends AppCompatActivity {

    private GamePresentation presentation;
    private GameView view;
    private ProgressBar laBarre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentation = new GamePresentation();
        view = findViewById(R.id.game);
        laBarre = findViewById(R.id.la_bar);

        laBarre.setMax(30);

        view.setPres(presentation);
        presentation.setView(view);

        presentation.getBoardPres().setView(view.getBoardView());
        presentation.getMenuPres().setView(view.getButtonView());
        view.getBoardView().setPres(presentation.getBoardPres());
        view.getButtonView().setPres(presentation.getMenuPres());
    }
}
