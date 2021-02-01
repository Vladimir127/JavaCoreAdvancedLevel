package lesson01.homework.obstacles;

import lesson01.homework.competitors.Competitor;

/** Стена */
public class Wall extends Obstacle {
    /** Высота стены */
    private final int height;

    /**
     * Инициализирует экземпляр класса
     * @param height Высота стены
     */
    public Wall(int height) {
        this.height = height;
    }

    /**
     * Имитирует взаимодействие (встречу) спортсмена с данной стеной.
     * При встрече со стеной субъект должен её перепрыгнуть.
     * @param competitor Объект класса, реализующего интерфейс Competitor
     */
    public boolean interact(Competitor competitor){
        return competitor.jump(height);
    }

    @Override
    public String toString() {
        return "Стена"  + (height > 0 ? " высотой " + height + " см" : "");
    }
}
