package com.study.interview.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public void solution(int N,int L, int[] A, int[] V){
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            balls.add(new Ball(A[i], V[i]));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i - 1; j++) {

            }
        }

        //
        // write your logic here and print the desired output
        //
    }
    static int gcd ( int a, int b ) {


        if ( a==0 ) return b;
        return gcd ( b%a, a );
    }

    static class Ball {
        int position;
        int velocity;

        Ball(int position, int velocity) {
            this.position = position;
            this.velocity = velocity;
        }
    }
}

// Following is the part of the program and is provided as an assistance to read the input.
class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] A = new int[N];
        int[] V = new int[N];
        for(int i=0; i< N; i++)
            A[i]= sc.nextInt();
        for(int i=0; i< N; i++)
            V[i]= sc.nextInt();
        Solution s = new Solution();
        s.solution(N, L, A, V);
    }
}