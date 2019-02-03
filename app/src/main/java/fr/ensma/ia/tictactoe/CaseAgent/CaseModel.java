package fr.ensma.ia.tictactoe.CaseAgent;

import fr.ensma.ia.tictactoe.R;

public class CaseModel {
    private boolean accessible;
    private int row, column;
    private static int[] ids = {R.drawable.empty_case, R.drawable.cross_case, R.drawable.circle_case};
    private int currentId;

    public CaseModel(){
        accessible = true;
        currentId = ids[1];
    }

    public int[] getIds(){
        return ids;
    }

    public int getCurrentId(){
        return currentId;
    }
    public void setCurrentId(int anotherPlayer) {
        currentId = anotherPlayer;
    }

    public void changeId(){
        if (currentId == ids[1]){
            currentId = ids[2];
        }else{
            if (currentId == ids[2]){
                currentId = ids[1];
            }
        }
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

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }
}
