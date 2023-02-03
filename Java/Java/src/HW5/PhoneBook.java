package HW5;

import java.util.*;

public class PhoneBook {
    private HashMap<String, List<Integer>> phoneBook;

    public void getAll() {
        fillPhoneBook();
        for (Map.Entry entry : phoneBook.entrySet()) {
            System.out.println(entry);
        }
    }

    private void fillPhoneBook() {
        phoneBook = new HashMap<>();
        for (int i = 0; i < (int) (Math.random() * 20)+1; i++) {
            String name = getName();

            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, new ArrayList<>());
            }

            phoneBook.get(name).add(getPhoneNumber());
        }
    }

    private String getName() {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Мария", "Сергей", "Константин", "Ксения", "Анна"));
        return names.get((int) (Math.random() * (names.size())));
    }

    private Integer getPhoneNumber() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
