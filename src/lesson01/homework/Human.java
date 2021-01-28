package lesson01.homework;

/** Человек */
public class Human implements Competitor {

    @Override
    public void jump() {
        System.out.println("Человек перепрыгнул");
    }

    @Override
    public void run() {
        System.out.println("Человек пробежал");
    }

    @Override
    public String toString() {
        return "Человек";
    }
}
