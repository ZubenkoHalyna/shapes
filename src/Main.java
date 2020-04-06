import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int count = random.nextInt(15) + 5;
        for (int i = 0; i < count; i++) {
            Color color = Color.values()[random.nextInt(Color.values().length)];
            switch (random.nextInt(4)) {
                case 0:
                    new Circle(random.nextInt(1000) / 100.0, color)
                            .paint();
                    break;
                case 1:
                    new Square(random.nextInt(1000) / 100.0, color)
                            .paint();
                    break;
                case 2:
                    new Trapeze.TrapezeBuilder()
                            .setFirstBaseWidth(random.nextInt(1000) / 100.0 + 1)
                            .setSecondBaseWidth(random.nextInt(1000) / 100.0 + 1)
                            .setLeftAngle(random.nextInt(71) + 20)
                            .setRightAngle(random.nextInt(71) + 20)
                            .setColor(color).build()
                            .paint();
                    break;
                default:
                    new Triangle.TriangleBuilder()
                            .setFirstSideLength(random.nextInt(1000) / 100.0 + 1)
                            .setSecondSideLength(random.nextInt(1000) / 100.0 + 1)
                            .setAngle(random.nextInt(140) + 20)
                            .setColor(color)
                            .build()
                            .paint();
            }
        }
    }
}
