package lesson01.homework;

/** Беговая дорожка */
public class RunningTrack extends Obstacle{

    /** Длина дорожки */
    private int length;

    /**,
     * Инициализирует экземпляр класса
     */
    public RunningTrack() {
    }

    /**
     * Инициализирует экземпляр класса
     * @param length
     */
    public RunningTrack(int length) {
        this.length = length;
    }

    /**
     * Имитирует взаимодействие (встречу) бегущего субъекта с данной беговой дорожкой.
     * При встрече с беговой дорожкой субъект должен по ней пробежать.
     * @param subject Субъект, реализующий интерфейс Competitor
     */
    @Override
    public boolean interact(Competitor subject){
        return subject.run(length);
    }

    @Override
    public String toString() {
        return "Беговая дорожка" + (length > 0 ? " длиной " + length + " м" : "");
    }
}
