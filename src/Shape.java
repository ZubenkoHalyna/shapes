abstract class Shape {
    public static final int SCALE = 5;
    private final Color color;

    public Shape(Color shapeColor) {
        color = shapeColor;
    }

    abstract void paint();

    abstract double getSquare();

    public Color getColor() {
        return color;
    }
}
