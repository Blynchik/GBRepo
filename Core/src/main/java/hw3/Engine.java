package hw3;

/**
 * Абстрактный класс Engine представляет собой общий класс для всех типов двигателей.
 */
public abstract class Engine {

    /**
     * Абстрактный метод, который должен быть реализован в подклассах.
     * Он отвечает за воспроизведение звука двигателя.
     */
    public abstract void makeSound();
}