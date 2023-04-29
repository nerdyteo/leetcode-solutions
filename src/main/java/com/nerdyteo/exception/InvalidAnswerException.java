package com.nerdyteo.exception;

import com.nerdyteo.Solution;
import com.nerdyteo.Testcase;

import java.util.Arrays;
import java.util.function.Function;

public class InvalidAnswerException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "\nInvalid Answer in [%s]. \n\t\tProblem: %s \n\t\tExpected Answer: %s \n\t\tGiven Answer: %s";
    private static final Function<Object, String> toString = object -> {
        if (object == null) {
            return "null";
        }

        if (object.getClass().isArray()) {
            return Arrays.toString((Object[]) object);
        }
        return object.toString();
    };

    public InvalidAnswerException(Class<? extends Solution> solutionClass,
                                  Testcase<?, ?> testcase,
                                  Object givenAnswer) {
        super(MESSAGE_FORMAT.formatted(solutionClass.getSimpleName(),
                toString.apply(testcase.problem()),
                toString.apply(testcase.answer()),
                toString.apply(givenAnswer)));
    }
}
