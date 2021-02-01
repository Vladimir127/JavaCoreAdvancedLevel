package lesson01.homework;

import lesson01.homework.competitors.Cat;
import lesson01.homework.competitors.Competitor;
import lesson01.homework.competitors.Human;
import lesson01.homework.competitors.Robot;
import lesson01.homework.obstacles.Obstacle;
import lesson01.homework.obstacles.RunningTrack;
import lesson01.homework.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        // Создаём участников и добавляем их в массив
        Competitor[] competitors = new Competitor[3];
        competitors[0] = new Human();
        competitors[1] = new Cat();
        competitors[2] = new Robot();

        // Выводим информацию об участниках на консоль
        System.out.println("Соревнования!!!\nВ соревнованиях участвуют: ");
        StringBuilder builder = new StringBuilder();
        for (Competitor competitor : competitors){
            builder.append(competitor + ", ");
        }
        builder.delete(builder.length() - 2, builder.length() - 1);
        System.out.println(builder.toString());

        // Создаём препятствия и добавляем их в массив
        Obstacle[] obstacles = new Obstacle[4];
        obstacles[0] = new RunningTrack(100);
        obstacles[1] = new Wall(50);
        obstacles[2] = new RunningTrack(250);
        obstacles[3] = new Wall(100);

        // Выводим информацию о препятствиях на консоль
        System.out.println("\nПрепятствия: ");
        builder = new StringBuilder();
        for (Obstacle obstacle : obstacles){
            builder.append(obstacle + ", ");
        }
        builder.delete(builder.length() - 2, builder.length() - 1);
        System.out.println(builder.toString());

        System.out.println("\nНа старт, внимание, марш!");

        // Выполняем перебор препятствий, выводим информацию о каждом препятствии на консоль
        for (int i = 0; i < obstacles.length; i++) {
            System.out.println("Препятствие " + (i + 1) + ": " + obstacles[i]);

            // Внутренним циклом выполняем перебор участников
            for (int j = 0; j < competitors.length; j++){

                // Если участник не равен null, вызываем метод взаимодействия препятствия с этим участником.
                // Если преодолеть препятствие не удалось, и участник сошёл с дистанции,
                // присваиваем соответствующему элементу массива значение null.
                if (competitors[j] != null){
                    if (!obstacles[i].interact(competitors[j])){
                        competitors[j] = null;
                    }
                }
            }
            System.out.println();
        }
    }
}
