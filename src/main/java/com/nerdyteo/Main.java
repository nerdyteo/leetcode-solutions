package com.nerdyteo;

import com.nerdyteo.exception.InvalidAnswerException;
import com.nerdyteo.solution.Solution;
import com.nerdyteo.solution.TwoSumSolution;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class Main {

    private static final Class<? extends Solution> solutionClass = TwoSumSolution.class;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor constructor = solutionClass.getConstructor();
        Solution solution = (Solution) constructor.newInstance();
        try {
            solution.execute();
            log.info("All Test Cases Passed for {}", solution.getClass().getSimpleName());
        } catch (InvalidAnswerException iae) {
            log.info(iae.getMessage());
        }
    }
}