package OOP.hw2;

public class MyCar extends AbstractCar {

    private String id;
    private String brand;

    public MyCar(String destination, String color, String id, String brand) {
        super(destination, color);
        this.id = id;
        this.brand = brand;
    }

    @Override
    public void speedUp() {
        System.out.println(getColor() + " автомобиль марки " + brand + " c госномером " + id + " ускоряется");
    }

    @Override
    public void reachDestination() {
        System.out.println(getColor() + " автомобиль марки " + brand + " c госномером " + id + " едет в " + getDestination());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
