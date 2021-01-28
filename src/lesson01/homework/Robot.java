package lesson01.homework;

/** Робот */
public class Robot implements Competitor {
    @Override
    public void jump() {
        System.out.println("Робот перепрыгнул");
    }

    @Override
    public void run() {
        System.out.println("Робот пробежал");
    }

    @Override
    public String toString() {
        return "Робот";
    }
}
