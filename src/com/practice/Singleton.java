package com.practice;

public class Singleton {
    private static Singleton obj;

    private Singleton() {
    }

    public static Singleton getObj() {
        if (obj == null) obj = new Singleton();
        return obj;
    }

}

class main {
    public static void main(String[] args) {
        Singleton s = Singleton.getObj();
    }
}
