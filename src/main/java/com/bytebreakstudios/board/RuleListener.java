package com.bytebreakstudios.board;

public interface RuleListener<T extends GameBoardState> {
    void ruleApplied(Rule<T> rule, boolean successful);
}
