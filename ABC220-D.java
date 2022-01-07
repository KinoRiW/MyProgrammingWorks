/*
AtCoder Beginner Contest 220 D - FG operation
URL : https://atcoder.jp/contests/abc220/tasks/abc220_d
time : 35min

Change file name to "Main.java" before compiling.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        n -= 2;
        int a1 = Integer.parseInt(sc.next());
        int a2 = Integer.parseInt(sc.next());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(sc.next());
        }
        long[][] grid = new long[n+1][];
        int MOD = 998244353;
        for(int i = 0; i < n+1; i++){
            grid[i] = new long[10];
            for(int j = 0; j < 10; j++){
                grid[i][j] = 0;
            }
        }
        grid[0][(a1+a2)%10]++;
        grid[0][(a1*a2)%10]++;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 10; j++){
                int add = (a[i]+j)%10;
                int mul = (a[i]*j)%10;
                grid[i+1][add] += grid[i][j];
                grid[i+1][add] %= MOD;
                grid[i+1][mul] += grid[i][j];
                grid[i+1][mul] %= MOD;
            }
        }
        for(int i = 0; i < 10; i++){
            System.out.println(grid[n][i]);
        }
    }
}

