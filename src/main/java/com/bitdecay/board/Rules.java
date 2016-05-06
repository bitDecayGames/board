package com.bitdecay.board;

import com.bitdecay.board.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Rules<T extends GameBoardState> extends ArrayList<Rule<T>> {
    public Rules(Rule<T>... rules){
        Collections.addAll(this, rules);
    }

    @Override
    public String toString(){
        return CollectionUtils.mkString(this, "[\n    ", ", \n    ", "\n]", Rule::description);
    }
}
