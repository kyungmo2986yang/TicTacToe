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
		
		// row
		boolean resultRow = true;
		for (int j=0; j<size; j++)
		{
			resultRow &= grid.get(row).get(j) == grid.get(row).get(column);
		}
		boolean result = resultRow;
		
		// colum
		boolean resultColumn = true;
		for (int i=0; i<size; i++)
		{
			resultColumn &= grid.get(i).get(column) == grid.get(row).get(column);
		}
		result |= resultColumn;
		
		// diagonal_down
		if(size*(size-1-row) == size*column)
		{
			boolean resultDiagonalDown = true;
			for (int j=0; j<size; j++)
			{
				resultDiagonalDown &= grid.get(size-1-j).get(j) == grid.get(row).get(column);
			}
			result |= resultDiagonalDown;
		}
		
		// diagonal_up
		if(row == column)
		{
			boolean resultDiagonalUp = true;
			for (int j=0; j<size; j++)
			{
				resultDiagonalUp &= grid.get(j).get(j) == grid.get(row).get(column);
			}
			result |= resultDiagonalUp;
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
				result &= grid.get(i).get(j) != EPlayer.Empty;
			}
		}
		return result;
	}

	public boolean gridIsEmpty()
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
