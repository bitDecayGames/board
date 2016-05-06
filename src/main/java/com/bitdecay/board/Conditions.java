package com.bitdecay.board;

import com.bitdecay.board.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Conditions<A extends GameBoardState> extends ArrayList<Condition<A, ?>> {
    public Conditions(Condition<A, ?>... conditions){
        Collections.addAll(this, conditions);
    }

    @Override
    public String toString(){
        return CollectionUtils.mkString(this, "[\n    ", ", \n    ", "\n]");
    }
}
