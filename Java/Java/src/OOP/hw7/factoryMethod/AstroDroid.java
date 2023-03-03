package OOP.hw7.factoryMethod;

public class AstroDroid implements Droid {

    @Override
    public void makeNoise() {
        System.out.println(AstroDroid.class + ": Бип-буп-бип!");
    }
}
