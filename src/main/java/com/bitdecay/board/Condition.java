package com.bitdecay.board;

import com.bitdecay.board.utils.Describable;
import com.bitdecay.board.utils.GameBoardException;
import com.bitdecay.board.utils.Serializable;

public abstract class Condition<A extends GameBoardState, B extends Action<A>> implements Serializable<Condition>, Describable {
    protected B action;
    protected Boolean recurring = false;
    protected Boolean occurred = false;

    public Condition(B action){
        if (action == null) throw new GameBoardException("Action cannot be null on a condition");
        this.action = action;
    }
    public B apply(A previous, A current){
        if ((this.recurring || !this.occurred) && check(previous, current)) {
            this.occurred = true;
            return this.action;
        } else return null;
    }
    public abstract boolean check(A previous, A current);

    @Override
    public String toString(){return this.description();}

}
