package fr.ensma.ia.tictactoe.GlobalAgent;

import fr.ensma.ia.tictactoe.Kernel.Grid.OutOfGridException;
import fr.ensma.ia.tictactoe.Kernel.Kernel;
import fr.ensma.ia.tictactoe.R;

public class GameModel {
    private boolean accessible;
    private Kernel kernel;
    private static int[] playSentence = {R.string.player_1_turn, R.string.player_2_turn};
    private static int[] endingSentence = {R.string.draw, R.string.player_1_wins, R.string.player_2_wins};
    private static int[] color = {R.color.buttonColor, R.color.buttonTxtColor1, R.color.buttonTxtColor2};

    public GameModel(){
        accessible = true;
        kernel = new Kernel();
    }

    public static int[] getPlaySentence() {
        return playSentence;
    }

    public static int[] getEndingSentence() {
        return endingSentence;
    }

    public static int[] getColor() {
        return color;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public Kernel getKernel(){
        return kernel;
    }

    public int requestPlayer(){
        return kernel.getCurrentPlayer();
    }

    /**
     * this method returns the winner if the game end in a win, 0 if it's a draw,
     * or the player who's next to play
     * @param x int
     * @param y int
     * @return int
     * @throws PlayException ""
     * @see GameView
     */
    public int fillInGrid(int x, int y) throws PlayException{
        try {
            return kernel.tileClicked(x, y);
        } catch (OutOfGridException e) {
            e.printStackTrace();
        }
        throw new PlayException();
    }

    public void resetGame(){
        kernel.resetGame();
    }

    public void changePlayer() {
        kernel.nextPlayer();
    }

    public void passing() {
        kernel.nextPlayer();
    }

    public boolean emptyGrid() {
        return kernel.empty();
    }
}