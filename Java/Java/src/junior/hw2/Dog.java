package junior.hw2;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, String age, String breed) {
        super(name, age);
        this.breed = breed;
        this.voice = "Гав-гав";
    }

    public void makeSound() {
        System.out.println(name + " говорит: " + voice);
    }
}
