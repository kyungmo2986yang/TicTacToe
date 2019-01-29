package fr.ensma.ia.tictactoe.BoardAgent;

import fr.ensma.ia.tictactoe.CaseAgent.ICaseView;

public interface IBoardView {
    void notifyAccess(boolean b);
    ICaseView[] getCaseViews();
}
