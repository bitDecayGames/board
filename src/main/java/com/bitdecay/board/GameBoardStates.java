package com.bitdecay.board;

import com.bitdecay.board.utils.Serializable;

import java.util.Stack;

/**
 * A simple stack of GameBoardStates
 * @param <T> the type of GameBoardState
 */
public final class GameBoardStates<T extends GameBoardState> extends Stack<T> implements Serializable<GameBoardStates> {

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public GameBoardStates deserialize(String data) {
        return null;
    }
}
