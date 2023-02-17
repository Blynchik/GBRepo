package OOP.hw2;

public abstract class AbstractCar extends Transport {

    private String color;

    public AbstractCar(String destination, String color) {
        super(destination);
        this.color = color;
    }

    public abstract void speedUp();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
