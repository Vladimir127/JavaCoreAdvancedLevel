package lesson01.homework.competitors;

import java.util.Random;

/** Человек */
public class Human implements Competitor {

    /** Ограничение на бег */
    private final int maxRun;

    /** Ограничение на прыжки */
    private final int maxJump;

    /**
     * Инициализирует экземпляр класса
     */
    public Human() {
        Random random = new Random();
        maxRun = random.nextInt(500);
        maxJump = random.nextInt(300);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJump){
            System.out.println("Человек прыгнул на высоту " + height + " см.");
            return true;
        } else {
            System.out.println("Человек прыгнул на высоту " + maxJump + " см. Человек сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRun){
            System.out.println("Человек пробежал " + distance + " м.");
            return true;
        } else {
            System.out.println("Человек пробежал " + maxRun + " м. Человек сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Человек" + (maxRun > 0 && maxJump > 0 ? " (ограничение на бег " + maxRun + " м, ограничение на прыжки " + maxJump + " см)" : "");
    }
}
