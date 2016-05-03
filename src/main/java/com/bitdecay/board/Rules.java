package com.bitdecay.board;

import com.bitdecay.board.utils.Seq;

import java.util.Collections;

public class Rules {
    private Seq<Rule> rules = new Seq<>();
    public Rules(Rule... rules){
        Collections.addAll(this.rules, rules);
    }

    @Override
    public String toString(){
        return rules.mkString("[\n    ", ", \n    ", "\n]", Rule::description);
    }
}
