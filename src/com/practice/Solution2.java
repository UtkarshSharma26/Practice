package com.practice;

public class Solution2 {

    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 4, 4, 5, 5};
        int arr_len = 7;
        checkIfIncreasing(arr, arr_len);
    }

    public static void checkIfIncreasing(int arr[], int arr_len) {
        int count = 0;
        for (int i = 0; i < arr_len; i++) {
            for (int j = i + 1; j < arr_len; j++) {
                if (arr[i] >= arr[j]) {
                    count++;
                }
            }
        }
        if (count == 2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
