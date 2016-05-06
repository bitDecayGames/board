package com.bitdecay.board;

import com.bitdecay.board.utils.Describable;
import com.bitdecay.board.utils.GameBoardException;
import com.bitdecay.board.utils.Serializable;

public abstract class Condition<T extends GameBoardState> implements Serializable<Condition>, Describable {
    private Action<T> action;
    protected Boolean recurring = false;
    private Boolean occurred = false;

    public Condition(Action<T> action){
        if (action == null) throw new GameBoardException("Action cannot be null on a condition");
        this.action = action;
    }
    public Action<T> apply(T previous, T current){
        if ((this.recurring || !this.occurred) && check(previous, current)) {
            this.occurred = true;
            return this.action;
        } else return null;
    }
    public abstract boolean check(T previous, T current);

    @Override
    public String toString(){return this.description();}

}
