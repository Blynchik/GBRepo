package jdk.hw6;

public class Door {
    private Prize prize;

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Door{" +
                "prize=" + prize.getClass() +
                '}';
    }
}
