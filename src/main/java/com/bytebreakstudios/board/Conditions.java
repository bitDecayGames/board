package com.bytebreakstudios.board;

import com.bytebreakstudios.board.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple list of Conditions
 * @param <A> the type of GameBoardState that the conditions handle
 */
public final class Conditions<A extends GameBoardState> extends ArrayList<Condition<A, ?>> {
    public Conditions(Condition<A, ?>... conditions){
        Collections.addAll(this, conditions);
    }

    @Override
    public String toString(){
        return CollectionUtils.mkString(this, "[\n    ", ", \n    ", "\n]");
    }
}
