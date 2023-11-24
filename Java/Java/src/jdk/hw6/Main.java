package jdk.hw6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Result> resultMap = new HashMap<>();
        play(resultMap, random);
    }

    public static Door[] getDoors(Random random) {
        Door[] doors = new Door[]{new Door(), new Door(), new Door()};
        int prizes = 0;
        while (prizes < 3) {
            int doorNum = random.nextInt(3);
            if (doors[doorNum].getPrize() == null) {
                if (prizes == 2) {
                    doors[doorNum].setPrize(new Car());
                } else {
                    doors[doorNum].setPrize(new Goat());
                }
                prizes++;
            }
        }
        return doors;
    }

    public static int makeChoice(Random random) {
        return random.nextInt(3);
    }

    public static int openAnotherDoor(int choice, Door[] doors, Random random) {
        int doorNum;
        do {
            doorNum = random.nextInt(3);
        } while (doorNum == choice && doors[doorNum].getPrize() instanceof Car);
        return doorNum;
    }

    public static int finalChoice(int anotherDoor, Random random) {
        int choice;
        do {
            choice = random.nextInt(3);
        } while (choice == anotherDoor);
        return choice;
    }

    public static void play(Map<Integer, Result> resultMap, Random random) {
        int changes = 0;
        int wins = 0;

        for (int i = 0; i < 1000; i++) {
            Door[] doors = getDoors(random);
            int choice = makeChoice(random);
            int anotherDoor = openAnotherDoor(choice, doors, random);
            int finalChoice = finalChoice(anotherDoor, random);
            Prize prize = doors[finalChoice].getPrize();

            boolean isChanged = false;
            if(choice != finalChoice){
                isChanged = true;
                changes++;
            }

            boolean isWin = false;
            if(prize instanceof Car){
                isWin = true;
                wins++;
            }
            Result result = new Result(isChanged, isWin);
            resultMap.put(i + 1, result);
        }
        System.out.println("Побед: " + wins/10.0 + "%");
        System.out.println("Сменили дверь: " + changes/10.0 + "%");
    }
}

