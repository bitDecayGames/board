package com.bytebreakstudios.board;

import org.junit.Assert;
import org.junit.Test;

public class RulesTest {

    @Test
    public void testRulesConstructor(){
        Rules<DefaultGameBoardState> rules = new Rules<>(new RuleImpl1(), new RuleImpl2());
        Assert.assertEquals(rules.toString(), "[\n    Rule implementation 1, \n    Rule implementation 2\n]");

        DefaultGameBoardState b = new DefaultGameBoardState();

    }

    public class RuleImpl1 implements Rule<DefaultGameBoardState> {

        @Override
        public String description() {
            return "Rule implementation 1";
        }

        @Override
        public String serialize() {
            return null;
        }

        @Override
        public Rule deserialize(String data) {
            return null;
        }

        @Override
        public boolean apply(DefaultGameBoardState current, DefaultGameBoardState next, Action action) {
            return false;
        }
    }

    public class RuleImpl2 implements Rule<DefaultGameBoardState> {

        @Override
        public String description() {
            return "Rule implementation 2";
        }

        @Override
        public String serialize() {
            return null;
        }

        @Override
        public Rule deserialize(String data) {
            return null;
        }

        @Override
        public boolean apply(DefaultGameBoardState current, DefaultGameBoardState next, Action action) {
            return false;
        }
    }
}


