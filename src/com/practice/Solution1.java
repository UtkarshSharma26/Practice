package com.practice;

public class Solution1 {

    public static void main(String[] args) {
        findMinimumSet("1234", 30);
    }

    public static void findMinimumSet(String s, int y) {
        int count = 0;
        int num = 0;
        int len = s.length();
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num <= y) {
                flag = true;
            } else {
                if (flag) {
                    count += 1;
                    num = s.charAt(i) - '0';
                    flag = false;

                    if (num <= y) {
                        flag = true;
                    } else {
                        num = 0;
                    }
                }
            }
        }
        if (flag) {
            count += 1;
        }
        System.out.println(count);
    }
}
