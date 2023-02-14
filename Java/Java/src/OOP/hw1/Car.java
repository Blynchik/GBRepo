package OOP.hw1;

public class Car {

    private String model;
    private int yearOfProduction;
    private int price;
    private String color;
    private double power;
    private boolean started;
    private int maxSpeed;
    private int currentSpeed;

    public Car(String model, int yearOfProduction, int price, String color, double power, int maxSpeed) {
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
        this.color = color;
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.started = false;
        this.currentSpeed = 0;
    }

    public void getInfo() {
        System.out.printf("%s, %.1f, %d\n", model, power, yearOfProduction);
    }

    public void start() {
        this.started = true;
        System.out.printf("%s готова к старту\n", model);
    }

    public void stop() {
        this.started = false;
    }

    public void road(String destination) {
        if (started) {
            System.out.printf("Мы едем на автомобиле %s в %s\n", model, destination);
        } else {
            System.out.printf("Мы не можем ехать, автомобиль %s не заведен\n", model);
        }
    }

    public void speedUp() {
        currentSpeed += 30;

        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
            System.out.printf("%s выжимает на полную\n", model);
        }
        System.out.printf("%s разгоняется\n", model);
    }

    public void speedDown() {
        currentSpeed -= 10;

        if (currentSpeed <= 0) {
            currentSpeed = 1;
            System.out.printf("У %s технические проблемы\n", model);
        }
        System.out.printf("%s замедляется\n", model);
    }

    public void nitro() {

        if (Math.random() * 6 <= power) {
            currentSpeed += 60;
            System.out.printf("%s рванула вперед\n", model);
        }
    }

    public String getModel() {
        return model;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
