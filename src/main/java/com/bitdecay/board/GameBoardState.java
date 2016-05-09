package com.bitdecay.board;

import com.bitdecay.board.utils.Serializable;

/**
 * This is a mostly empty interface that is meant to contain all of the state for the game
 */
public interface GameBoardState extends Serializable<GameBoardState>, Cloneable {
    Object clone();
}
