package com.nerdyteo.solution;

import com.nerdyteo.exception.InvalidAnswerException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

public interface Solution<D, R> {

    List<Testcase<D, R>> testCases();

    R solve(D data);

    default void execute() {
        testCases().stream()
                .filter(Objects::nonNull)
                .filter(testcase -> Objects.nonNull(testcase.problem()))
                .filter(testcase -> Objects.nonNull(testcase.answer()))
                .forEach(testcase -> {
                    final R solutionAnswer = solve(testcase.problem());
                    if (!testcase.validate(solutionAnswer)) {
                        throw new InvalidAnswerException(this.getClass(), testcase.answer(), solutionAnswer);
                    }
                });
    }
}
