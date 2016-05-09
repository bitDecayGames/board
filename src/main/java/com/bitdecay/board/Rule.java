package com.bitdecay.board;

import com.bitdecay.board.utils.Describable;
import com.bitdecay.board.utils.Serializable;

/**
 * The Rule class checks for invalid states.  With all of the proper rules, a GameBoardState can never enter into an invalid state.
 * @param <T> The type of GameBoardState that this rule handles
 */
public interface Rule<T extends GameBoardState> extends Serializable<Rule>, Describable {
    boolean apply(T current, T next, Action action);
}
