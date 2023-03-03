package OOP.hw7.factoryMethod;

public class AstroDroidFactory implements DroidFactory{

    @Override
    public Droid createDroid() {
        return new AstroDroid();
    }
}
