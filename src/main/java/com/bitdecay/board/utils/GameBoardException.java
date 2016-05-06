package com.bitdecay.board.utils;

public class GameBoardException extends RuntimeException {
    public GameBoardException(String message){
        super(message);
    }
    public GameBoardException(String message, Throwable e){
        super(message, e);
    }
}
