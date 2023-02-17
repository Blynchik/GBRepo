package OOP.hw2;

public abstract class Transport {

    private String destination;

    public Transport(String destination){
        this.destination = destination;
    }

    public abstract void reachDestination();

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
