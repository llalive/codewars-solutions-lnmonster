package dev.lochness.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Write a function that takes an array of numbers (integers for the tests) and a target number.
    It should find two different items in the array that, when added together, give the target value.
    The indices of these items should then be returned in a tuple like so: (index1, index2).
    For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
    The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be numbers;
    target will always be the sum of two different items from that array).
    Based on: http://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static int[] twoSumSimple(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++)
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
        return result;
    }

    public static int[] twoSumHashMap(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> searchMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            searchMap.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int second = target - numbers[i];
            if (searchMap.containsKey(second) && !searchMap.get(second).equals(i)) {
                result[0] = i;
                result[1] = searchMap.get(second);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(twoSumHashMap(new int[]{3, 6, 9, 12, 26, 65, 54, 25}, 9)).forEach(System.out::println);
    }
}
