package com.bitdecay.board;

import com.bitdecay.board.utils.CollectionUtils;
import com.bitdecay.board.utils.Serializable;

import java.util.PriorityQueue;

public class Actions<T extends GameBoardState> extends PriorityQueue<Action> implements Serializable<Actions> {
    @Override
    public String serialize() {
        return null;
    }

    @Override
    public Actions deserialize(String data) {
        return null;
    }

    @Override
    public String toString(){
        return CollectionUtils.mkString(this, "[\n    ", ", \n    ", "\n]");
    }
}
