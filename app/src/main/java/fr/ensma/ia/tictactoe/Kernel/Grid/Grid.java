package fr.ensma.ia.tictactoe.Kernel.Grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	private List<List<EPlayer>> grid;
	private final int size;
	
	public Grid(int size)
	{
		this.size = size;
		grid = new ArrayList<List<EPlayer>>();
		// get(row).get(column)
		for(int i=0; i<size; i++)
		{
			grid.add(new ArrayList<EPlayer>());
			for(int j=0; j<size; j++)
			{
				grid.get(i).add(EPlayer.Empty);
			}
		}
	}
	
	public void set(int row, int column, EPlayer value) throws OutOfGridException
	{
		if(row < 0 || row >= size || column < 0 || column >= size)
		{
			throw new OutOfGridException();
		}
		grid.get(row).set(column, value);
	}
	
	public EPlayer get(int row, int column) throws OutOfGridException
	{
		if(row < 0 || row >= size || column < 0 || column >= size)
		{
			throw new OutOfGridException();
		}
		return grid.get(row).get(column);
	}
	
	public boolean winningLine(int row, int column) throws OutOfGridException
	{
		if(row < 0 || row >= size || column < 0 || column >= size)
		{
			throw new OutOfGridException();
		}
		
		boolean result = false;
		
		// row
		boolean result_row = false;
		for (int j=0; j<size; j++)
		{
			result_row &= grid.get(row).get(j) == grid.get(row).get(column);
		}
		result |= result_row;
		
		// colum
		boolean result_column = false;
		for (int i=0; i<size; i++)
		{
			result_column &= grid.get(i).get(column) == grid.get(row).get(column);
		}
		result |= result_column;
		
		// diagonal_down
		if(size*(size-row) == size*column)
		{
			boolean result_diagonal_down = false;
			for (int j=0; j<size; j++)
			{
				result_diagonal_down &= grid.get(size-j).get(j) == grid.get(row).get(column);
			}
			result |= result_diagonal_down;
		}
		
		// diagonal_up
		if(row == column)
		{
			boolean result_diagonal_up = false;
			for (int j=0; j<size; j++)
			{
				result_diagonal_up &= grid.get(j).get(j) == grid.get(row).get(column);
			}
			result |= result_diagonal_up;
		}
		
		return result;
	}
	
	public boolean gridIsFull()
	{
		boolean result = true;
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				result &= grid.get(i).get(j) == EPlayer.Empty;
			}
		}
		return result;
	}
	
	public void reset()
	{
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				grid.get(i).set(j,EPlayer.Empty);
			}
		}
	}
}
