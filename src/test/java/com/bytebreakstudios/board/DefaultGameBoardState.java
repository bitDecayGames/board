package com.bytebreakstudios.board;

import com.bytebreakstudios.board.utils.GameBoardException;

public class DefaultGameBoardState implements GameBoardState {

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public DefaultGameBoardState deserialize(String data) {
        return null;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new GameBoardException("This should never happen", e);
        }
    }
}
