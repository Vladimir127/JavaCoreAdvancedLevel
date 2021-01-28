package lesson01.homework;

/** Интерфейс, определяющий общие поля для всех участников соревнования */
public interface Competitor {
    String name = null;
    String type = null;

    /** Имитирует бег */
    void run();

    /** Имитирует прыжок */
    void jump();
}
