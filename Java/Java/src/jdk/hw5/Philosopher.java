package jdk.hw5;

public class Philosopher implements Runnable {

    private int id;
    private int eatCount;
    private Table table;

    public Philosopher(int id, Table table) {
        this.id = id;
        this.eatCount = 0;
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        do {
            Fork rightFork = this.table.getForks().get(this.id);
            Fork leftFork;
            if (this.id == this.table.getCapacity() - 1) {
                leftFork = this.table.getForks().get(0);
            } else {
                leftFork = this.table.getForks().get(this.id + 1);
            }

            if (!rightFork.getInUse() && !leftFork.getInUse()) {
                eat(rightFork, leftFork);
            } else {
                System.out.printf("Философ %d думает\n", this.id);
            }
        } while (this.eatCount < 3);
    }

    private void eat(Fork rightFork, Fork leftFork) {
        takeForks(rightFork, leftFork);
        putDownForks(rightFork, leftFork);
    }

    private void takeForks(Fork rightFork, Fork leftFork) {
        rightFork.take();
        System.out.printf("Философ %d взял вилку %d\n", this.id, rightFork.getId());
        leftFork.take();
        System.out.printf("Философ %d взял вилку %d\n", this.id, leftFork.getId());
        System.out.printf("Философ %d ест\n", this.id);
    }

    private void putDownForks(Fork rightFork, Fork leftFork) {
        rightFork.release();
        System.out.printf("Философ %d положил вилку %d\n", this.id, rightFork.getId());
        leftFork.release();
        System.out.printf("Философ %d положил вилку %d\n", this.id, leftFork.getId());
        eatCount++;
        System.out.printf("Философ %d поел %d раза\n", this.id, this.eatCount);
    }
}
