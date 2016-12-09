package com.bytebreakstudios.board;

public interface ActionListener<T extends GameBoardState> {
    void actionApplied(Action<T> action, boolean successful);
}
