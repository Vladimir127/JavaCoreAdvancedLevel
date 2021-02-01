package lesson01.homework;

import java.util.Random;

/** Человек */
public class Human implements Competitor {

    /** Ограничение на бег */
    private int maxRun;

    /** Ограничение на прыжки */
    private int maxJump;

    public Human() {
        Random random = new Random();
        maxRun = random.nextInt(500);
        maxJump = random.nextInt(300);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJump){
            System.out.println("Человек прыгнул на высоту " + height + " см");
            return true;
        } else {
            System.out.println("Человек НЕ прыгнул на высоту " + height + " см. Человек сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRun){
            System.out.println("Человек пробежал " + distance + " м");
            return true;
        } else {
            System.out.println("Человек НЕ пробежал " + distance + " м. Человек сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Человек" + (maxRun > 0 && maxJump > 0 ? " (ограничение на бег " + maxRun + " м, ограничение на прыжки " + maxJump + " см)" : "");
    }
}
