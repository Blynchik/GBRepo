package hw3;

/**
 * Класс Car представляет собой автомобиль.
 * Он наследует функциональность класса Vehicle и реализует интерфейс TurboRegime.
 */
public class Car extends Vehicle implements TurboRegime {

    /**
     * Конструктор класса Car.
     *
     * @param engine объект типа Engine, представляющий двигатель автомобиля.
     */
    public Car(Engine engine) {
        super(engine);
    }

    /**
     * Метод, который активирует режим турбонаддува для автомобиля.
     * Выводит сообщение о ускорении.
     */
    @Override
    public void turbo() {
        System.out.println(TurboRegime.class + ": " + "Ускорение");
    }
}
