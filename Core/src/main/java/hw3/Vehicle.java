package hw3;

/**
 * Абстрактный класс, представляющий транспортное средство.
 **/
public abstract class Vehicle {

    private Engine engine;

    /**
     * Конструктор класса Vehicle.
     *
     * @param engine двигатель, используемый в транспортном средстве
     **/
    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    /**
     * Метод для запуска транспортного средства.
     * Выводит звук, созданный двигателем.
     **/
    public void start() {
        this.engine.makeSound();
    }
}