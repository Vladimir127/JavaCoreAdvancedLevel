package lesson01.homework.obstacles;

import lesson01.homework.competitors.Competitor;

/** Абстрактный класс, представляющий препятствие */
public abstract class Obstacle {
    /**
     * Имитирует взаимодействие (встречу) спорстмена с данным препятствием
     * @param competitor Спортсмен
     * @return Истина в случае успешного прохождения препятствия, иначе - ложь.
     */
    public abstract boolean interact(Competitor competitor);
}
