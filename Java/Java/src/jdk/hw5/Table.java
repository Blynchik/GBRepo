package jdk.hw5;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private int capacity = 5;
    private List<Philosopher> philosophers;
    private List<Fork> forks;

    public Table() {
        philosophers = new ArrayList<>();
        forks = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            philosophers.add(new Philosopher(i, this));
            forks.add(new Fork(i));
        }
        philosophers.forEach(p -> {
            Thread thread = new Thread(p);
            thread.start();
        });
    }

    public List<Fork> getForks() {
        return forks;
    }

    public int getCapacity() {
        return capacity;
    }
}
