package com.bitdecay.board;

import com.bitdecay.board.utils.Serializable;

import java.util.Stack;

public class GameBoardStates extends Stack<GameBoardState> implements Serializable<GameBoardStates> {

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public GameBoardStates deserialize(String data) {
        return null;
    }
}
