package com.bitdecay.board;

import com.bitdecay.board.utils.Describable;
import com.bitdecay.board.utils.Serializable;

public interface Rule<T extends GameBoardState> extends Serializable<Rule>, Describable {
    boolean apply(T current, T next, Action action);
}
