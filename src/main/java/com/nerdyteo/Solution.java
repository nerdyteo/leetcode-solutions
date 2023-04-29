package com.nerdyteo;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public interface Solution<D, R> {

    List<Testcase<D, R>> testCases();

    R solve(D data);

    default Result execute() {
        final List<InvalidAnswer> invalidAnswers = new LinkedList<>();
        testCases().stream()
                .filter(Objects::nonNull)
                .filter(testcase -> Objects.nonNull(testcase.problem()))
                .filter(testcase -> Objects.nonNull(testcase.answer()))
                .forEach(testcase -> {
                    final R solutionAnswer = solve(testcase.problem());
                    if (!testcase.validate(solutionAnswer)) {
                        invalidAnswers.add(new InvalidAnswer(testcase, solutionAnswer));
                    }
                });
        return new Result(testCases().size(), invalidAnswers);
    }
}
