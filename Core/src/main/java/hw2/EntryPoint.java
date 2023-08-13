package hw2;

import java.util.Random;

public class EntryPoint {
    public static void main(String[] args) {
        PandoraBox pandoraBox = getPandoraBox();
        System.out.println("Открываем ящик Пандоры");
        CanAppear monster = pandoraBox.open();
        monster.appear();
    }

    static PandoraBox getPandoraBox(){
        double rnd = Math.random();
        System.out.println(rnd);

        if (rnd < 0.5){
            return new TrollFactory();
        }

        return new VampireFactory();
    }
}
