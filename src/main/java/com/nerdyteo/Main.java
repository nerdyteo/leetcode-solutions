package com.nerdyteo;

import com.nerdyteo.solution.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class Main {

    private static final Class<? extends Solution<?, ?>> solutionClass = LongestPalindromicSubstring.class;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<?> constructor = solutionClass.getConstructor();
        Solution<?, ?> solution = (Solution<?, ?>) constructor.newInstance();
        final Result result = solution.execute();
        log.info("\nTotal Test Cases Passed: {}/{} in [{}]" +
                        "\n\tFailed Test Cases:" +
                        "{}", result.passedTestCasesCount(), result.totalTestCases(), solution.getClass().getSimpleName(),
                result.invalidAnswers());

    }
}