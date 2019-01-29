package fr.ensma.ia.tictactoe.Kernel;

import fr.ensma.ia.tictactoe.Kernel.Grid.EPlayer;
import fr.ensma.ia.tictactoe.Kernel.Grid.Grid;
import fr.ensma.ia.tictactoe.Kernel.Grid.OutOfGridException;

public class Kernel {
	private Grid the_grid;
	private EPlayer current_player;
	
	public Kernel()
	{
		the_grid = new Grid(3);
		current_player = EPlayer.FirstPlayer;
	}
	
	public void next_player()
	{
		if(current_player != EPlayer.FirstPlayer)
		{
			current_player = EPlayer.FirstPlayer;
		}
		else
		{
			current_player = EPlayer.SecondPlayer;
		}
	}
	
	public EPlayer tileClicked(int row, int column) throws OutOfGridException
	{
		EPlayer just_played = current_player;
		the_grid.set(row, column, just_played);
		next_player();
		return just_played;
	}
	
	public boolean draw()
	{
		return the_grid.gridIsFull();
	}
	
	public boolean winningLine(int row, int column) throws OutOfGridException
	{
		return the_grid.winningLine(row, column);
	}
	
	public void resetGame()
	{
		the_grid.reset();
		current_player = EPlayer.FirstPlayer;
	}
}
