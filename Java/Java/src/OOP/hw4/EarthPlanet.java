package OOP.hw4;

import java.util.HashMap;
import java.util.Map;

public class EarthPlanet {

    private Map<Integer, Human> humanity;

    public EarthPlanet() {
        populateEarth();
    }

    private void populateEarth() {
        humanity = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Human human = createAutoHuman();
            humanity.put(human.getId(), human);
        }
    }

    private Human createAutoHuman() {
        int nameIndex = (int) (Math.random() * Name.values().length);
        int surnameIndex = (int) (Math.random() * Surname.values().length);
        int professionIndex = (int) (Math.random() * Profession.values().length);

        return new Human(Name.values()[nameIndex].toString(),
                Surname.values()[surnameIndex].toString(),
                (int) (Math.random() * 55 + 20),
                Profession.values()[professionIndex].toString());
    }

    public void addHuman(Human human) {
        humanity.put(human.getId(), human);
    }

    public void deleteHuman(int id) {
        humanity.remove(id);
    }

    public void editHuman(int id, String name, String surname, int age, String profession) {
        Human human = humanity.get(id);
        human.setName(name);
        human.setSurname(surname);
        human.setAge(age);
        human.setProfession(profession);
    }

    public Human getHuman(int id){
        return humanity.get(id);
    }

    public Map<Integer, Human> getHumanity() {
        return humanity;
    }

    public void setHumanity(Map<Integer, Human> humanity) {
        this.humanity = humanity;
    }
}
