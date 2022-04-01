package com.practice;

public class Solution3 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printKtSpiral(arr, 4, 4, 8);
    }

    public static void printKtSpiral(int[][] arr, int rows, int columns, int k) {
        int x = 0;
        int y = 0;
        if (k <= rows) {
            y = k - 1;
        } else if (k <= rows + columns - 1) {
            x = rows - 1;
            y = columns - 1;
        } else if (k <= 2 * rows + columns - 2) {
            x =  rows - 2;
            y = columns - 1;
        }
        System.out.println(arr[x][y]);
    }
}
