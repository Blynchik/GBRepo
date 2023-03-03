package OOP.hw7.decorator;


public class Program {
    public static void main(String[] args) {
        DroidModification droid = new BaseDroid();
        System.out.println(droid);

        DroidModification killerDroid = new KillerDroid(droid);
        System.out.println("KillerDroid{hp=" + killerDroid.getArmor() + ", bullets=" + killerDroid.getWeapon() + "}");

        DroidModification battleDroid = new HeavyBattleDroid(droid);
        System.out.println("HeavyBattleDroid{hp=" + battleDroid.getArmor() + ", bullets=" + battleDroid.getWeapon() + "}");
    }
}
