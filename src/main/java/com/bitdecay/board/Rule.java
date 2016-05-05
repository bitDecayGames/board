package com.bitdecay.board;

import com.bitdecay.board.utils.Describable;
import com.bitdecay.board.utils.Serializable;

public interface Rule extends Serializable<Rule>, Describable {
    boolean apply(GameBoardState current, GameBoardState next, Action action);
}
