package OOP.hw7.decorator;

import OOP.hw7.factoryMethod.BattleDroid;
import OOP.hw7.factoryMethod.Droid;

public class HeavyBattleDroid implements DroidModification {

    private DroidModification droidModification;

    public HeavyBattleDroid(DroidModification droidModification) {
        this.droidModification = droidModification;
    }


    @Override
    public int getArmor() {
        return this.droidModification.getArmor() + 100;
    }

    @Override
    public int getWeapon() {
        return this.droidModification.getWeapon() + 100;
    }

    @Override
    public String toString() {
        return "HeavyBattleDroid{" +
                "droidModification=" + droidModification +
                '}';
    }
}
