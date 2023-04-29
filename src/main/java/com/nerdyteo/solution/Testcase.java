package com.nerdyteo.solution;

import lombok.Builder;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Collection;

public record Testcase<D, R>(D problem, R answer) {

    public boolean validate(R givenAnswer) {
        if (answer.getClass().isArray()) {
            return Arrays.equals((Object[]) answer, (Object[]) givenAnswer);
        }

        if (answer instanceof Collection<?>) {
            return ((Collection<?>) answer).containsAll((Collection<?>) givenAnswer);
        }

        return answer.equals(givenAnswer);
    }
}
