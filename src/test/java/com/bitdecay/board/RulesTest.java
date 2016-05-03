package com.bitdecay.board;

import org.junit.Assert;
import org.junit.Test;

public class RulesTest {

    @Test
    public void testRulesConstructor(){
        Rules rules = new Rules(new RuleImpl1(), new RuleImpl2());
        Assert.assertEquals(rules.toString(), "[\n    Rule implementation 1, \n    Rule implementation 2\n]");
    }

    public class RuleImpl1 implements Rule {
        @Override
        public boolean apply(Action action) {
            return false;
        }

        @Override
        public String description() {
            return "Rule implementation 1";
        }
    }

    public class RuleImpl2 implements Rule {
        @Override
        public boolean apply(Action action) {
            return false;
        }

        @Override
        public String description() {
            return "Rule implementation 2";
        }
    }
}


