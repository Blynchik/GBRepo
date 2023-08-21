package hw3;

/**
 * Интерфейс PitStopService предоставляет методы для выполнения операций проверки на пит-стопе.
 **/
public interface PitStopService {

    /**
     * Метод для проверки всех двигателей на пит-стопе.
     * Этот метод должен быть реализован в соответствующей службе пит-стопа для запуска всех двигателей.
     **/
    void checkAllEngines();

    /**
     * Метод для проверки турбонаддува на пит-стопе.
     * Этот метод должен быть реализован в соответствующей службе пит-стопа для активации режима турбонаддува.
     **/
    void checkTurbo();
}
