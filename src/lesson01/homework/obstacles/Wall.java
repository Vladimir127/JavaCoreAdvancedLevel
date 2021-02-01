package lesson01.homework;

/** Стена */
public class Wall extends Obstacle {
    /** Высота стены */
    private int height;

    /**,
     * Инициализирует экземпляр класса
     */
    public Wall() {
    }

    /**
     * Инициализирует экземпляр класса
     * @param height
     */
    public Wall(int height) {
        this.height = height;
    }

    /**
     * Имитирует взаимодействие (встречу) прыгающего субъекта с данной стеной.
     * При встрече со стеной субъект должен её перепрыгнуть.
     * @param subject Субъект, реализующий интерфейс Competitor
     */
    public boolean interact(Competitor subject){
        subject.jump(height);
        return true;
    }

    @Override
    public String toString() {
        return "Стена"  + (height > 0 ? " высотой " + height + " см" : "");
    }
}
