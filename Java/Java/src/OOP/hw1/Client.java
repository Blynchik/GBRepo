package OOP.hw1;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda", 2023, 10_000_000, "red", 1.6, 300);
        Car car2 = new Car("BMW", 2022, 9_500_000, "blue", 2.0, 250);
//        car1.getInfo();
//        car1.road("Париж");
//        car1.start();
//        car1.road("Милан");
//        car1.stop();
//        car1.road("Прага");

        Client client = new Client();
        client.makeRace(car1, car2, 10);
    }

    void makeRace(Car car1, Car car2, int distanceKm) {
        System.out.println(car1);
        System.out.println(car2);
        System.out.println("------------------");
        car1.start();
        car2.start();
        System.out.println("------------------");
        double time1 = 0.0;
        double time2 = 0.0;

        for (int i = 0; i < distanceKm; i++) {

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            checkSpeed(car1);
            checkSpeed(car2);
            System.out.println("------------------");

            checkCondition(car1, i + 1);
            time1 += (1.0 / (double) car1.getCurrentSpeed()) * 3600.0;

            checkCondition(car2, i + 1);
            time2 += (1.0 / (double) car2.getCurrentSpeed()) * 3600.0;
            System.out.println("------------------");
        }

        System.out.printf("%s прошла дистанцию за %.4f минуты\n", car1.getModel(), time1 / 60.0);
        System.out.printf("%s прошла дистанцию за %.4f минуты\n", car2.getModel(), time2 / 60.0);

        String winner;
        if(time1<time2){
            winner = car1.getModel();
        } else {
            winner = car2.getModel();
        }
        System.out.println("Победила " + winner);
    }

    void checkSpeed(Car car) {
        if (Math.random() >= 0.1) {
            car.speedUp();
        } else {
            car.speedDown();
        }
        car.nitro();
    }

    void checkCondition(Car car, int km) {
        System.out.printf("Километр %d, %s время: %.4f сек., скорость: %d км/ч\n", km, car.getModel(), (1.0 / (double) car.getCurrentSpeed()) * 3600.0, car.getCurrentSpeed());
    }
}
