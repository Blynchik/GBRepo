package hw3;

/**
 * Класс, представляющий обычный автомобильный двигатель.
 * Наследуется от класса Engine.
 */
public class UsualCarEngine extends Engine {

    private String sound;

    /**
     * Конструктор класса UsualCarEngine.
     * Инициализирует звук двигателя.
     */
    public UsualCarEngine() {
        sound = "Врррррррр";
    }

    /**
     * Метод для воспроизведения звука двигателя.
     * Выводит сообщение в консоль с названием класса и звуком двигателя.
     */
    @Override
    public void makeSound() {
        System.out.println(UsualCarEngine.class + ": " + sound);
    }
}