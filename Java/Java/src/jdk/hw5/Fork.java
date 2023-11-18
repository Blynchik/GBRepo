package jdk.hw5;

public class Fork {
    private int id;
    private boolean inUse;

    public Fork(int id) {
        this.id = id;
        this.inUse = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public synchronized void take() {
            while (inUse) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            inUse = true;
    }

    public synchronized void release() {
            inUse = false;
           notifyAll();
        }
}
