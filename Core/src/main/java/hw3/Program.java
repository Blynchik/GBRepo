package hw3;

/**
 * Класс, представляющий программу.
 * Содержит метод main для запуска программы.
 */
public class Program {

    /**
     * Метод main для запуска программы.
     * Создает экземпляр класса PitStop и PitStopService.
     * Создает автомобиль и грузовик с соответствующими двигателями.
     * Добавляет автомобиль и грузовик в пит-стоп.
     * Выполняет проверку всех двигателей в пит-стопе.
     * Выполняет проверку турборежима у всех двигателей в пит-стопе.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        PitStop pitStop = new PitStop();
        PitStopService pitStopService = new PitStopServiceImpl(pitStop);

        Vehicle car = new Car(new UsualCarEngine());
        Vehicle track = new Track(new HeavyCarEngine());

        pitStop.add(car);
        pitStop.add(track);

        pitStopService.checkAllEngines();
        pitStopService.checkTurbo();
    }
}
