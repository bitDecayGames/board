package com.bitdecay.board;

import com.bitdecay.board.utils.GameBoardException;

public final class GameBoard {
    private GameBoardState currentKeyFrameState;
    private GameBoardStates keyframeStates = new GameBoardStates();
    private GameBoardStates allStates = new GameBoardStates();
    private Actions actions = new Actions();
    private Rules rules;
    private Conditions conditions;

    public GameBoard(GameBoardState currentState, Rules rules, Conditions conditions){
        if (currentState == null) throw new GameBoardException("GameBoardState cannot be null");
        if (rules == null) throw new GameBoardException("Rules cannot be null");
        if (conditions == null) throw new GameBoardException("Conditions cannot be null");

        this.currentKeyFrameState = currentState;
        keyframeStates.add(currentState);
        allStates.add(currentState);
        this.rules = rules;
        this.conditions = conditions;
    }

    public GameBoard submitAction(Action action){
        actions.add(action);
        return this;
    }

    public GameBoard step(){
        applyActions();
        currentKeyFrameState = allStates.peek();
        applyConditions();
        applyActions();
        currentKeyFrameState = allStates.peek();
        if (currentKeyFrameState != keyframeStates.peek()) keyframeStates.push(currentKeyFrameState);
        return this;
    }

    private void applyActions(){
        if (actions.size() <= 0) return;
        boolean successful = true;

        while(actions.size() > 0){
            Action a = actions.remove();
            GameBoardState curState = allStates.peek();
            GameBoardState nextState = a.apply(curState);
            for (Rule r : rules){
                if (!r.apply(curState, nextState, a)) {
                    successful = false;
                    break;
                }
            }
            if (successful){
                allStates.push(nextState);
            } else {
                while(actions.size() > 0) actions.remove();
                break;
            }
        }

        if (actions.size() > 0) throw new GameBoardException("All actions should have been removed from the Queue.  Remaining actions: " + actions);
        if (!successful) revertActions();
    }

    private void applyConditions(){
        GameBoardState previousKeyFrameState = keyframeStates.peek();
        if (currentKeyFrameState == previousKeyFrameState) return;
        for(Condition c : conditions) {
            Action a = c.apply(previousKeyFrameState, currentKeyFrameState);
            if (a != null) actions.add(a);
        }
    }

    private void revertActions(){
        while(allStates.peek() != currentKeyFrameState) allStates.pop();
        while(keyframeStates.peek() != currentKeyFrameState) keyframeStates.pop();
    }

    public GameBoard undo(){
        if (keyframeStates.size() > 1){
            keyframeStates.pop();
            currentKeyFrameState = keyframeStates.peek();
            revertActions();
        }
        return this;
    }
}
