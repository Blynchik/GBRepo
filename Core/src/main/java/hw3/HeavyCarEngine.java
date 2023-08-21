package hw3;

/**
 * Этот класс представляет собой двигатель для тяжелого автомобиля.
 * Он наследует функциональность класса Engine.
 **/
public class HeavyCarEngine extends Engine {
    private String sound;

    /**
     * Конструктор класса HeavyCarEngine.
     * Инициализирует звук двигателя тяжелого автомобиля.
     **/
    public HeavyCarEngine() {
        this.sound = "Тр-тр-тр-тр";
    }

    /**
     * Метод, который воспроизводит звук двигателя тяжелого автомобиля.
     **/
    @Override
    public void makeSound() {
        System.out.println(HeavyCarEngine.class + ": " + sound);
    }
}
