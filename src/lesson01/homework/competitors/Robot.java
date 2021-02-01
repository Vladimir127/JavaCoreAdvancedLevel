package lesson01.homework.competitors;

import java.util.Random;

/** Робот */
public class Robot implements Competitor {
    /** Ограничение на бег */
    private final int maxRun;

    /** Ограничение на прыжки */
    private final int maxJump;

    /**
     * Инициализирует экземпляр класса
     */
    public Robot(){
        Random random = new Random();
        maxRun = random.nextInt(500);
        maxJump = random.nextInt(300);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJump){
            System.out.println("Робот прыгнул на высоту " + height + " см");
            return true;
        } else {
            System.out.println("Робот прыгнул на высоту " + maxJump + " см. Робот сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRun){
            System.out.println("Робот пробежал " + distance + " м");
            return true;
        } else {
            System.out.println("Робот пробежал " + maxRun + " м. Робот сошёл с дистанции.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Робот" + (maxRun > 0 && maxJump > 0 ? " (ограничение на бег " + maxRun + " м, ограничение на прыжки " + maxJump + " см)" : "");
    }
}
