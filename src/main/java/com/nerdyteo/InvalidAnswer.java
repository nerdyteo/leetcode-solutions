package com.nerdyteo;

import com.nerdyteo.Solution;
import com.nerdyteo.Testcase;

import java.util.Arrays;
import java.util.function.Function;

public class InvalidAnswer {

    private static final String MESSAGE_FORMAT = "\n\t\tProblem: %s \n\t\tExpected Answer: %s \n\t\tGiven Answer: %s";
    private static final Function<Object, String> toString = object -> {
        if (object == null) {
            return "null";
        }

        if (object.getClass().isArray()) {
            return Arrays.toString((Object[]) object);
        }
        return object.toString();
    };

    private final String message;

    public InvalidAnswer(Testcase<?, ?> testcase,
                         Object givenAnswer) {
        this.message = MESSAGE_FORMAT.formatted(
                toString.apply(testcase.problem()),
                toString.apply(testcase.answer()),
                toString.apply(givenAnswer));
    }

    @Override
    public String toString() {
        return this.message;
    }
}
