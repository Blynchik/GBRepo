package OOP.hw7.decorator;

import OOP.hw7.factoryMethod.Droid;

public class BaseDroid implements DroidModification{
    private int hp = 1;
    private int bullets = 0;


    @Override
    public int getArmor() {
        return this.hp;
    }

    @Override
    public int getWeapon() {
        return this.bullets;
    }

    @Override
    public String toString() {
        return "BaseDroid{" +
                "hp=" + hp +
                ", bullets=" + bullets +
                '}';
    }
}
