package dev.lochness.java;

import java.util.Arrays;
/*
  Given two arrays a and b write a function comp(a, b) (compSame(a, b) in Clojure)
  that checks whether the two arrays have the "same" elements, with the same multiplicities.
  "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
  https://www.codewars.com/kata/550498447451fbbd7600041c
*/
public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if(a == null || b == null || a.length != b.length) {
            return false;
        }
        return Arrays.equals(
                Arrays.stream(a).map(i -> i * i).sorted().toArray(),
                Arrays.stream(b).sorted().toArray()
        );
    }
}
