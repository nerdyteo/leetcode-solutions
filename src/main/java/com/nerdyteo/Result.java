package com.nerdyteo;

import java.util.List;

public record Result(int totalTestCases, List<InvalidAnswer> invalidAnswerList) {

    public int passedTestCasesCount() {
        return totalTestCases - invalidAnswerList.size();
    }

    public String invalidAnswers() {
        final StringBuilder message = new StringBuilder();
        invalidAnswerList.stream()
                .map(InvalidAnswer::toString)
                .forEach(message::append);
        return message.toString();
    }
}
