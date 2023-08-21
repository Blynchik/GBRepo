package hw3;

/**
 * Класс, представляющий грузовик.
 * Наследуется от класса Vehicle.
 */
public class Track extends Vehicle {

    /**
     * Конструктор класса Track.
     * Создает грузовик с указанным двигателем.
     *
     * @param engine двигатель, используемый в грузовике
     */
    public Track(Engine engine) {
        super(engine);
    }
}