package com.bitdecay.board;

import com.bitdecay.board.utils.Describable;
import com.bitdecay.board.utils.GameBoardException;
import com.bitdecay.board.utils.Serializable;

public abstract class Action implements Serializable, Describable {
    public GameBoardState apply(GameBoardState previous) {
        GameBoardState nextState = innerApply(previous);
        checkStateValidity(nextState, previous);
        return nextState;
    }
    protected abstract GameBoardState innerApply(GameBoardState previous);
    public GameBoardState unapply(GameBoardState current){
        GameBoardState previousState = innerUnapply(current);
        checkStateValidity(previousState, current);
        return previousState;
    }
    protected final void checkStateValidity(GameBoardState a, GameBoardState b){
        if (a == null || b == null) throw new GameBoardException("A GameBoardState can never be null");
        if (a == b) throw new GameBoardException("An action must return a fresh GameBoardState, it cannot reuse a previous state object");
    }
    protected abstract GameBoardState innerUnapply(GameBoardState current);
    @Override
    public String toString(){return this.description();}
}
