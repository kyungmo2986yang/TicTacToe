package fr.ensma.ia.tictactoe.CaseAgent;

public class CaseModel {
    private boolean accessible;
    private int row, column;

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public CaseModel(){
        accessible = true;
    }
}
