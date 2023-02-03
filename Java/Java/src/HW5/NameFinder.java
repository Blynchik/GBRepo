package HW5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class NameFinder {
    private TreeMap<Integer, List<String>> collisions;

    private List<String> getFullNames(String names) {
        return List.of(names.split(", "));
    }

    private List<String> getNames(List<String> namesAndSurnames) {
        List<String> list = new ArrayList<>();

        for (String nameAndSurname : namesAndSurnames) {
            list.add(nameAndSurname.split(" ")[0]);
        }

        return list;
    }

    public TreeMap<Integer, List<String>> getCollisions(String str) {
        collisions = new TreeMap<>((o1, o2) -> Integer.compare(o2,o1));

        for (String name : getNames(getFullNames(str))) {
            int repeats = 0;

            for (int i = 0; i < getNames(getFullNames(str)).size(); i++) {
                if (getNames(getFullNames(str)).get(i).equals(name)) {
                    repeats++;
                }
            }

            if (!collisions.containsKey(repeats)) {
                collisions.put(repeats, new ArrayList<>());
            }

            if (!collisions.get(repeats).contains(name)) {
                collisions.get(repeats).add(name);
            }
        }

        return collisions;
    }
}
