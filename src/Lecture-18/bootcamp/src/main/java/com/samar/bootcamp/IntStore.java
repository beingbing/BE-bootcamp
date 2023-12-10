package com.samar.bootcamp;

public class IntStore {
    private int x = 0;

//    public void incr() {
//        x++; // it's not an atomic instruction, it's a 3-step process
//        // x is stored in RAM
//        // code is running in CPU
//        // 1. fetch value of x from RAM and store it in local register
//        // 2. new value computed and saved in register
//        // 3. save updated value of x in RAM
//        // context switching can happen at any point of time while going
//        // through this 3-step process.
//        // this is what is called racing condition.
//    }

    // two ways of using synchronised keyword
//    public synchronized void incr() {
//        x++;
//    }

    public void incr() {
        synchronized (this) {
            x++;
        }
    }

    public int getX() {
        return x;
    }
}
