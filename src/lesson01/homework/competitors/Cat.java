package lesson01.homework;

import java.util.Random;

/** Кот */
public class Cat implements Competitor {
    /** Ограничение на бег */
    private int maxRun;

    /** Ограничение на прыжки */
    private int maxJump;

    public Cat() {
        Random random = new Random();
        maxRun = random.nextInt(500);
        maxJump = random.nextInt(300);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJump){
            System.out.println("Кот прыгнул на высоту " + height + " см");
            return true;
        } else {
            System.out.println("Кот НЕ прыгнул на высоту " + height + " см. Кот сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRun){
            System.out.println("Кот пробежал " + distance + " м");
            return true;
        } else {
            System.out.println("Кот НЕ пробежал " + distance + " м. Кот сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Кот" + (maxRun > 0 && maxJump > 0 ? " (ограничение на бег " + maxRun + " м, ограничение на прыжки " + maxJump + " см)" : "");
    }
}
