package OOP.hw7.factoryMethod;

public class BattleDroid implements Droid {
    @Override
    public void makeNoise() {
        System.out.println(BattleDroid.class + ": Смерть псам-джедаям!");
    }
}
