package com;

import java.io.Serializable;

abstract class Main {

    private class InnerClass {
    }


    private int count;

    public Main(int count) {
        count = count;
    }

//    private abstract void print();

    public static void main(String args) {
	// write your code here
    }

    public static void main(String[] args) {
	// write your code here
    }
}

interface Ballable extends Runnable, Serializable {

}
