package org.example.entrance;

import org.example.clazz.Decorator;
import org.example.clazz.OtherClass;

/**
 * Основной класс приложения
 */
public class App {
    /**
     * Точка входа
     * @param args аргументы клмандной строки
     */
    public static void main( String[] args )
    {
        int result = OtherClass.add(2,2);
        System.out.println(Decorator.decorate(result));

        result = OtherClass.sub(2,2);
        System.out.println(Decorator.decorate(result));

        result = OtherClass.mul(2,2);
        System.out.println(Decorator.decorate(result));

        result = OtherClass.div(2,2);
        System.out.println(Decorator.decorate(result));
    }
}
