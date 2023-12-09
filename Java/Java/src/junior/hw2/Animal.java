package junior.hw2;

public abstract class Animal {
    protected String name;
    protected String age;
    protected String voice;

    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();
}
