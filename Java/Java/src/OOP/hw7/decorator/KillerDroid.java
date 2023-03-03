package OOP.hw7.decorator;

public class KillerDroid implements DroidModification {

    private DroidModification droidModification;

    public KillerDroid(DroidModification droidModification) {
        this.droidModification = droidModification;
    }

    @Override
    public int getArmor() {
        return this.droidModification.getArmor() + 20;
    }

    @Override
    public int getWeapon() {
        return this.droidModification.getWeapon() + 50;
    }

    @Override
    public String toString() {
        return "KillerDroid{" +
                "droidModification=" + droidModification +
                '}';
    }
}
