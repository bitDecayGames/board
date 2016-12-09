package com.bytebreakstudios.board.utils;

/**
 * A generic runtime exception that is thrown when something in the board library fails
 */
public class GameBoardException extends RuntimeException {
    public GameBoardException(String message){
        super(message);
    }
    public GameBoardException(String message, Throwable e){
        super(message, e);
    }
}
