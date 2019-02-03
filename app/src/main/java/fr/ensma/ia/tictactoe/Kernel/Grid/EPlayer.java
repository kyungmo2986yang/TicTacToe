package fr.ensma.ia.tictactoe.Kernel.Grid;

public enum EPlayer {
	Empty(0), FirstPlayer(1), SecondPlayer(2);

	private int playerVal;

	EPlayer(int val) {
		playerVal = val;
	}

	public int getPlayerVal() {
		return playerVal;
	}
}
