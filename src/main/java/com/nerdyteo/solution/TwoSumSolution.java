package com.nerdyteo.solution;

import com.nerdyteo.Solution;
import com.nerdyteo.Testcase;
import lombok.Builder;

import java.util.HashMap;
import java.util.List;

public class TwoSumSolution implements Solution<TwoSumSolution.TwoSumProblem, Integer[]> {

    @Builder
    public record TwoSumProblem(int[] nums, int target) {
    }

    @Override
    public List<Testcase<TwoSumProblem, Integer[]>> testCases() {
        return List.of(
                new Testcase<>(TwoSumProblem.builder()
                        .nums(new int[]{2, 7, 11, 15})
                        .target(9).build(), new Integer[]{0, 1}),
                new Testcase<>(TwoSumProblem.builder()
                        .nums(new int[]{3, 2, 4})
                        .target(6).build(), new Integer[]{1, 2}),
                new Testcase<>(TwoSumProblem.builder()
                        .nums(new int[]{3, 3})
                        .target(6).build(), new Integer[]{0, 1})
        );
    }

    /*
        Runtime: 2 ms (81.94%)
        Memory: 43.1 MB (29.43%)
     */
    @Override
    public Integer[] solve(TwoSumProblem data) {
        final int[] nums = data.nums;
        final int target = data.target;

        final HashMap<Integer, Integer> differences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int value = nums[i];
            final Integer key = differences.get(value);
            if (key != null) {
                return new Integer[]{key, i};
            }

            final int difference = target - value;
            if (!differences.containsKey(difference))
                differences.put(difference, i);
        }
        return new Integer[0];
    }

}
