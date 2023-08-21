package hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс PitStop представляет пит-стоп для обслуживания автомобилей.
 **/
public class PitStop {
    private List<Vehicle> vehicles;
    private int length;

    /**
     * Конструктор класса PitStop.
     * Создает новый экземпляр списка Vehicle для хранения автомобилей на пит-стопе.
     **/
    public PitStop() {
        vehicles = new ArrayList<>();
    }

    /**
     * Метод добавляет автомобиль на пит-стоп.
     *
     * @param vehicle объект типа Vehicle, который будет добавлен на пит-стоп.
     **/
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Метод удаляет автомобиль с пит-стопа по указанному индексу.
     *
     * @param id индекс автомобиля в списке.
     **/
    public void remove(int id) {
        vehicles.remove(id);
    }

    /**
     * Метод возвращает автомобиль с пит-стопа по указанному индексу.
     *
     * @param id индекс автомобиля в списке.
     * @return объект типа Vehicle.
     **/
    public Vehicle get(int id) {
        return vehicles.get(id);
    }

    /**
     * Метод возвращает количество автомобилей на пит-стопе.
     *
     * @return количество автомобилей.
     **/
    public int getLength() {
        return vehicles.size();
    }
}
