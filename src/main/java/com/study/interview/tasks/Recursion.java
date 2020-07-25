package com.study.interview.tasks;

public class Recursion {

    public static void main(String[] args) {
        long position = 48;

        System.out.println(getFibonacci(position));
    }

    public static long getFibonacci(long position) {
        if (position == 0 || position == 1)
            return position;
        return getFibonacci(position - 1) + getFibonacci(position - 2);
    }

}
