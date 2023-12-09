package junior.hw2;

public class Cat extends Animal {
    private String color;

    public Cat(String name, String age, String color) {
        super(name, age);
        this.color = color;
        this.voice = "Мяу";
    }

    public void makeSound() {
        System.out.println(name + " говорит: " + voice);
    }
}
