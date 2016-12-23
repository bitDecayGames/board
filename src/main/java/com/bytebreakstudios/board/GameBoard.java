package com.bytebreakstudios.board;

import com.bytebreakstudios.board.utils.GameBoardException;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the logic center for all the interactions between the various board classes
 * @param <T> The GameBoardState that this GameBoard handles
 */
public final class GameBoard<T extends GameBoardState> {
    private T currentKeyFrameState;
    private GameBoardStates<T> keyframeStates = new GameBoardStates<T>();
    private GameBoardStates<T> allStates = new GameBoardStates<T>();
    private Actions<T> actions = new Actions<T>();
    private Rules<T> rules;
    private Conditions<T> conditions;
    private List<RuleListener<T>> ruleListeners = new ArrayList<>();
    private List<ActionListener<T>> actionListeners = new ArrayList<>();

    public GameBoard(T currentState, Rules<T> rules, Conditions<T> conditions){
        if (currentState == null) throw new GameBoardException("GameBoardState cannot be null");
        if (rules == null) throw new GameBoardException("Rules cannot be null");
        if (conditions == null) throw new GameBoardException("Conditions cannot be null");

        this.currentKeyFrameState = currentState;
        keyframeStates.add(currentState);
        allStates.add(currentState);
        this.rules = rules;
        this.conditions = conditions;
    }

    public T currentState(){
        return (T) currentKeyFrameState.clone();
    }

    public GameBoard<T> submitAction(Action<T> action){
        actions.add(action);
        return this;
    }

    public boolean step(){
        applyActions();
        currentKeyFrameState = allStates.peek();
        applyConditions();
        applyActions();
        currentKeyFrameState = allStates.peek();
        if (currentKeyFrameState != keyframeStates.peek()) {
            keyframeStates.push(currentKeyFrameState);
            return true;
        }
        else return false;
    }

    private void applyActions(){
        if (actions.size() <= 0) return;
        boolean successful = true;

        while(actions.size() > 0){
            Action<T> a = actions.remove();
            T curState = allStates.peek();
            T nextState = a.apply(curState);
            for (Rule<T> r : rules){
                if (!r.apply(curState, nextState, a)) successful = false;
                final boolean ruleSuccessFinal = successful;
                ruleListeners.forEach(rl -> rl.ruleApplied(r, ruleSuccessFinal));
                if (!successful) break;
            }
            final boolean successFinal = successful;
            actionListeners.forEach(al -> al.actionApplied(a, successFinal));
            if (successful) allStates.push(nextState);
            else {
                while(actions.size() > 0) actions.remove();
                break;
            }
        }

        if (actions.size() > 0) throw new GameBoardException("All actions should have been removed from the Queue.  Remaining actions: " + actions);
        if (!successful) revertActions();
    }

    private void applyConditions(){
        T previousKeyFrameState = keyframeStates.peek();
        if (currentKeyFrameState == previousKeyFrameState) return;
        for(Condition<T, ?> c : conditions) {
            Action<T> a = c.apply(previousKeyFrameState, currentKeyFrameState);
            if (a != null) actions.add(a);
        }
    }

    private void revertActions(){
        while(allStates.peek() != currentKeyFrameState) allStates.pop();
        while(keyframeStates.peek() != currentKeyFrameState) keyframeStates.pop();
    }

    public GameBoard<T> undo(){
        if (keyframeStates.size() > 1){
            keyframeStates.pop();
            currentKeyFrameState = keyframeStates.peek();
            revertActions();
        }
        return this;
    }

    public int numberOfKeyStates(){
        return keyframeStates.size();
    }

    public GameBoard<T> listenForRules(RuleListener<T> ruleListener){
        ruleListeners.add(ruleListener);
        return this;
    }

    public GameBoard<T> stopListeningForRules(RuleListener<T> ruleListener){
        ruleListeners.remove(ruleListener);
        return this;
    }

    public GameBoard<T> listenForActions(ActionListener<T> actionListener){
        actionListeners.add(actionListener);
        return this;
    }

    public GameBoard<T> stopListeningForActions(ActionListener<T> actionListener){
        actionListeners.remove(actionListener);
        return this;
    }
}
