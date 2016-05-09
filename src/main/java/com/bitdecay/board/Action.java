package com.bitdecay.board;

import com.bitdecay.board.utils.Describable;
import com.bitdecay.board.utils.GameBoardException;
import com.bitdecay.board.utils.Serializable;

/**
 * The actual things that a player can directly or indirectly DO in the game
 * @param <T> describes the kind of GameBoardState that this action handles
 */
public abstract class Action<T extends GameBoardState> implements Serializable, Describable {
    public T apply(T previous) {
        T nextState = innerApply(previous);
        checkStateValidity(nextState, previous);
        return nextState;
    }
    protected abstract T innerApply(T previous);
    public T unapply(T current){
        T previousState = innerUnapply(current);
        checkStateValidity(previousState, current);
        return previousState;
    }
    protected abstract T innerUnapply(T current);
    protected final void checkStateValidity(T a, T b){
        if (a == null || b == null) throw new GameBoardException("A GameBoardState can never be null");
        if (a == b) throw new GameBoardException("An action must return a fresh GameBoardState, it cannot reuse a previous state object");
    }
    @Override
    public String toString(){return this.description();}
}
