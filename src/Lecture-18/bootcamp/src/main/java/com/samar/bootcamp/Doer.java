package com.samar.bootcamp;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Doer implements Runnable {
    private List<Integer> nums;
    private Integer i;

    @Override
    public void run() {
        synchronized (nums) { // apply lock on nums as it is the shared resource experiencing
            // problems due to racing condition.
            if (!nums.contains(i)) {
                for (int i = 0; i < 100000; i++) {
                }
                nums.add(i);
            }
        }
    }
}
