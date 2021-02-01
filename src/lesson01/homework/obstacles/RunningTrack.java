package lesson01.homework.obstacles;

import lesson01.homework.competitors.Competitor;

/** Беговая дорожка */
public class RunningTrack extends Obstacle{

    /** Длина дорожки */
    private final int length;

    /**
     * Инициализирует экземпляр класса
     * @param length Длина дорожки
     */
    public RunningTrack(int length) {
        this.length = length;
    }

    /**
     * Имитирует взаимодействие (встречу) спортсмена с данной беговой дорожкой.
     * При встрече с беговой дорожкой субъект должен по ней пробежать.
     * @param competitor Объект класса, реализующего интерфейс Competitor
     */
    @Override
    public boolean interact(Competitor competitor){
        return competitor.run(length);
    }

    @Override
    public String toString() {
        return "Беговая дорожка" + (length > 0 ? " длиной " + length + " м" : "");
    }
}
