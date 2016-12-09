package com.bytebreakstudios.board;

import com.bytebreakstudios.board.utils.Describable;
import com.bytebreakstudios.board.utils.GameBoardException;
import com.bytebreakstudios.board.utils.Serializable;

/**
 * A condition contains a check for a given state and then an action to apply when that check returns true
 * @param <A> the GameBoardState that this condition handles
 * @param <B> the Action that this condition applies
 */
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
