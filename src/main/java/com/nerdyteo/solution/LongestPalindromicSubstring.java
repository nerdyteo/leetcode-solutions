package com.nerdyteo.solution;

import com.nerdyteo.Solution;
import com.nerdyteo.Testcase;

import java.util.List;

public class LongestPalindromicSubstring implements Solution<String, String> {

    @Override
    public List<Testcase<String, String>> testCases() {
        return List.of(
                new Testcase<>("babad", "bab"),
                new Testcase<>("cbbd", "bb"),
                new Testcase<>("dd", "dd"),
                new Testcase<>("asd419uaedogeeseseegodasd913u4jds", "dogeeseseegod"),
                new Testcase<>("a", "a"),
                new Testcase<>("ac", "a"),
                new Testcase<>("aacabdkacaa", "aca")
        );
    }

    @Override
    public String solve(String s) {
        return solution1(s);
    }

    /*
        Runtime: 97 ms (37.46%)
        Memory: 43.1 MB (34.25%)
     */
    private String solution1(String s) {
        if (s.length() == 1) {
            return s;
        }
        final char[] array = s.toCharArray();
        String longestPalindromicString = String.valueOf(array[0]);

        char character;
        int leftPointer;
        int rightPointer;
        for (int i = 0; i < array.length; i++) {
            character = array[i];
            boolean isProceed = true;
            for (int z = array.length - 1; z != i; z--) {
                if (array[z] != character) {
                    continue;
                }

                if (z - 1 == i) {
                    longestPalindromicString = compare(longestPalindromicString, s.substring(i, i + 2));
                    break;
                }
                leftPointer = i;
                rightPointer = z;
                while (array[++leftPointer] == array[--rightPointer]) {
                    if (leftPointer == rightPointer
                            || leftPointer + 1 == rightPointer) {
                        longestPalindromicString = compare(longestPalindromicString, s.substring(i, z + 1));
                        isProceed = false;
                        break;
                    }
                }
                if (!isProceed) {
                    break;
                }
            }
        }
        return longestPalindromicString;
    }


    private String compare(String primary, String secondary) {
        if (primary == null || primary.length() < secondary.length()) {
            return secondary;
        }
        return primary;
    }
}
