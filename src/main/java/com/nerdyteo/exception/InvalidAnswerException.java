package com.nerdyteo.exception;

import com.nerdyteo.Solution;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;

public class InvalidAnswerException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "\nInvalid Answer in [%s]. \n\t\tExpected Answer: %s \n\t\tGiven Answer: %s";
    private static Function<Object, String> toString = object -> {
        if (object == null) {
            return "null";
        }

        if (object.getClass().isArray()) {
            return Arrays.toString((Object[]) object);
        }
        return object.toString();
    };

    public InvalidAnswerException(Class<? extends Solution> solutionClass,
                                  Object expectedAnswer, Object givenAnswer) {
        super(MESSAGE_FORMAT.formatted(solutionClass.getSimpleName(),
                toString.apply(expectedAnswer),
                toString.apply(givenAnswer)));
    }
}
