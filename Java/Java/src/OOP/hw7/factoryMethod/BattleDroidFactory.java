package OOP.hw7.factoryMethod;

public class BattleDroidFactory implements DroidFactory{

    @Override
    public Droid createDroid() {
        return new BattleDroid();
    }
}
