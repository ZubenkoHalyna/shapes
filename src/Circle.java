public class Circle extends Shape {
    private final double radius;

    public Circle(double circleRadius, Color circleColor) {
        super(circleColor);
        radius = circleRadius;
    }

    @Override
    public void paint() {
        System.out.format("Shape: circle; radius %.1f; square %.2f; color %s\n",
                radius,
                getSquare(),
                getColor().toString().toLowerCase());
    }

    @Override
    public double getSquare() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}
