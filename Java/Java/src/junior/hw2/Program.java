package junior.hw2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> dog = Class.forName("junior.hw2.Dog");
        Class<?> cat = Class.forName("junior.hw2.Cat");
        Class<?> animal = Class.forName("junior.hw2.Animal");
        Constructor[] dogConst = dog.getConstructors();
        Constructor[] catConst = cat.getConstructors();

        Animal[] animals = new Animal[]{
                (Dog) dogConst[0].newInstance("Шарик", "1", "Дворняга"),
                (Dog) dogConst[0].newInstance("Рекс", "2", "Овчарка"),
                (Cat) catConst[0].newInstance("Барсик", "3", "Рыжий"),
                (Cat) catConst[0].newInstance("Мурзик", "4", "Черный")
        };

        Arrays.stream(animals).forEach(a -> {
            Field[] fields = animal.getDeclaredFields();
            printFields(fields, a);
            if (a instanceof Dog) {
                Field[] dogFields = dog.getDeclaredFields();
                printFields(dogFields, a);
            } else if (a instanceof Cat) {
                Field[] catFields = cat.getDeclaredFields();
                printFields(catFields, a);
            }
            a.makeSound();
            System.out.println("\n");
        });
    }

    private static void printFields(Field[] fields, Animal a) {
        Arrays.stream(fields).forEach(field -> {
            field.setAccessible(true);
            try {
                String value = (String) field.get(a);
                System.out.println(field.getName() + ": " + value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

