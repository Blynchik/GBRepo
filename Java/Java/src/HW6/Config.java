package HW6;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Config {
    private Map<Integer, Integer> ramMap;
    private Map<Integer, Integer> hddMap;
    private Map<Integer, String> osMap;
    private Map<Integer, String> colorMap;
    private List<Notebook> laptops;

    public Map<Integer, String> getOsMap() {
        return osMap;
    }

    public Map<Integer, String> getColorMap() {
        return colorMap;
    }

    public List<Notebook> getLaptops() {
        return laptops;
    }

    public void setConfig() {
        fillRamMap();
        fillHddMap();
        fillOsMap();
        fillColorMap();
        fillLaptops();
    }

    private void fillLaptops() {
        laptops = new ArrayList<>();

        for (int i = 0; i < (int) (Math.random() * 100)+1; i++) {
            laptops.add(new Notebook(
                    ramMap.get((int) (Math.random() * 6)),
                    hddMap.get((int) (Math.random() * 6)),
                    osMap.get((int) (Math.random() * 3)),
                    colorMap.get((int) (Math.random() * 6))
            ));
        }
    }

    private void fillColorMap() {
        colorMap = new HashMap<>();

        colorMap.put(0, "Color.BLACK");
        colorMap.put(1, "Color.BLUE");
        colorMap.put(2, "Color.CYAN");
        colorMap.put(3, "Color.DARK_GRAY");
        colorMap.put(4, "Color.GRAY");
        colorMap.put(5, "Color.LIGHT_GRAY");
    }

    private void fillOsMap() {
        osMap = new HashMap<>();

        osMap.put(0, "Windows");
        osMap.put(1, "Linux");
        osMap.put(2, "Mac");
    }

    private void fillRamMap() {
        ramMap = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            ramMap.put(i, (int) Math.pow(2, i));
        }
    }

    private void fillHddMap() {
        hddMap = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            hddMap.put(i, (int) Math.pow(2, i + 7));
        }
    }
}
