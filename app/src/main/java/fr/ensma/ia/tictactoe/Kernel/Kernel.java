package fr.ensma.ia.tictactoe.Kernel;

import java.util.logging.Logger;

import fr.ensma.ia.tictactoe.Kernel.Grid.EPlayer;
import fr.ensma.ia.tictactoe.Kernel.Grid.Grid;
import fr.ensma.ia.tictactoe.Kernel.Grid.OutOfGridException;

public class Kernel {
	private Grid theGrid;
	private EPlayer currentPlayer;
	private static int notEnded = 3;
	private static Logger LOGGER = Logger.getLogger(Kernel.class.getName());
	private int timerLimit;
	
	public Kernel()
	{
		theGrid = new Grid(3);
		currentPlayer = EPlayer.FirstPlayer;
	}

	public int getNotEnded(){
		return notEnded;
	}
	
	public void nextPlayer()
	{
		if(currentPlayer == EPlayer.SecondPlayer)
		{
			currentPlayer = EPlayer.FirstPlayer;
		}
		else
		{
			currentPlayer = EPlayer.SecondPlayer;
		}
	}

	public int tileClicked(int row, int column) throws OutOfGridException
	{
		theGrid.set(row, column, currentPlayer);
		if (winningLine(row, column)){
			LOGGER.info(currentPlayer + " wins");
			return currentPlayer.getPlayerVal();
		}
		if (draw()){
			LOGGER.info("draw");
			return 0;
		}
		nextPlayer();
		LOGGER.info(currentPlayer + " plays");
		return notEnded;
	}
	
	public boolean draw()
	{
		return theGrid.gridIsFull();
	}

	public boolean empty(){
		return theGrid.gridIsEmpty();
	}
	
	public boolean winningLine(int row, int column) throws OutOfGridException
	{
		return theGrid.winningLine(row, column);
	}
	
	public void resetGame()
	{
		theGrid.reset();
		currentPlayer = EPlayer.FirstPlayer;
	}

    public int getCurrentPlayer() {
		return currentPlayer.getPlayerVal();
    }

    public int getTimerLimit() {
		return timerLimit;
    }

    public void setTimerLimit(int i){
		timerLimit = i;
	}
}
