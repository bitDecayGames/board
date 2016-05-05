package com.bitdecay.board;

import com.bitdecay.board.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Conditions extends ArrayList<Condition> {
    public Conditions(Condition... conditions){
        Collections.addAll(this, conditions);
    }

    @Override
    public String toString(){
        return CollectionUtils.mkString(this, "[\n    ", ", \n    ", "\n]");
    }
}
