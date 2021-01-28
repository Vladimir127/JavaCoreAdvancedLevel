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
        maxJump = random.nextInt(200);
    }

    Добавить в эти методы параметры
    @Override
    public void jump() {
        System.out.println("Кот перепрыгнул");
    }

    @Override
    public void run() {
        System.out.println("Кот пробежал");
    }

    @Override
    public String toString() {
        return "Кот" + (maxRun > 0 && maxJump > 0 ? " (ограничение на бег " + maxRun + " см, ограничение на прыжки " + maxJump + " см)" : "");
    }
}
