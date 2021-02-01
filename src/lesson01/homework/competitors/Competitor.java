package lesson01.homework;

/** Интерфейс, определяющий общие поля для всех участников соревнования */
public interface Competitor {
    /**
     * Имитирует бег
     * @param distance Расстояние
     * @return Истина в случае успешного прохождения испытания, иначе - ложь.
     */
    boolean run(int distance);

    /**
     * Имитирует прыжок
     * @param height Высота прыжка
     * @return Истина в случае успешного прохождения испытания, иначе - ложь.
     */
    boolean jump(int height);
}
