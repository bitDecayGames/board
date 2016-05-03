package com.bitdecay.board;

public interface Rule {
    boolean apply(Action action);
    String description();
}
