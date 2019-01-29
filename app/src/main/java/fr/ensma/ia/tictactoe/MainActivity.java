package fr.ensma.ia.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.ensma.ia.tictactoe.BoardAgent.BoardPresentation;
import fr.ensma.ia.tictactoe.BoardAgent.BoardView;
import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;
import fr.ensma.ia.tictactoe.GlobalAgent.GameView;

public class MainActivity extends AppCompatActivity {

    private GamePresentation presentation;
    private GameView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentation = new GamePresentation();
        view = findViewById(R.id.game);
        view.setPres(presentation);
        presentation.setView(view);
    }
}
